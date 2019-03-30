package br.edu.ifpb.projetopadroes.dao;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import br.edu.ifpb.projetopadroes.entity.Reserva;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class ReservaDAOPostgres implements ReservaDAO{
    
    @PersistenceContext(unitName = "PadroesPU")
    private EntityManager em;

    @Override
    public void salvar(Reserva r) {
        em.persist(r);
    }

    @Override
    public void atualizar(Reserva r) {
        em.merge(r);
    }

    @Override
    public void remover(Reserva r) {
        em.remove(em.find(Reserva.class, r.getId()));
    }

    @Override
    public Reserva buscar(Reserva r) {
        return em.find(Reserva.class, r.getId());
    }

    @Override
    public Reserva buscar(int id) {
        return em.find(Reserva.class, id);
    }

    @Override
    public List<Reserva> listar() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Reserva> createQuery = builder.createQuery(Reserva.class);
        createQuery.select(createQuery.from(Reserva.class));
        TypedQuery<Reserva> query = em.createQuery(createQuery);
        return query.getResultList();
    }

    @Override
    public List<Reserva> listFrom(Integer idAtracao) {
        String sql = "SELECT a.reservas FROM Atracao a WHERE a.id = :id";
        TypedQuery<Reserva> query = em.createQuery(sql, Reserva.class);
        query.setParameter("id", idAtracao);
        return query.getResultList();
    }

    @Override
    public boolean reservar(Atracao a, Reserva r) {
        Atracao atracao = em.find(Atracao.class, a.getId());
        if(atracao == null) return false;
        
        atracao.getReservas().add(r);
        em.merge(atracao);
        return true;
    }
    
}
