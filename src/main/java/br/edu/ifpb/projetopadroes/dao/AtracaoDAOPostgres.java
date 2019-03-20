package br.edu.ifpb.projetopadroes.dao;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class AtracaoDAOPostgres implements AtracaoDAO{
    
    @PersistenceContext(unitName = "PadroesPU")
    private EntityManager em;
    
    @Override
    public void salvar(Atracao atracao) {
        em.persist(atracao);
    }
    
    @Override
    public void atualizar(Atracao atracao){
        em.merge(atracao);
    }
    
    @Override
    public void remover(Atracao atracao) {
        em.remove(em.find(Atracao.class, atracao.getId()));
    }
    
    @Override
    public Atracao buscar(Atracao atracao) {
        return em.find(Atracao.class, atracao.getId());
    }
    
    @Override
    public List<Atracao> listar() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Atracao> createQuery = builder.createQuery(Atracao.class);
        createQuery.select(createQuery.from(Atracao.class));
        TypedQuery<Atracao> query = em.createQuery(createQuery);
        return query.getResultList();
    }

}
