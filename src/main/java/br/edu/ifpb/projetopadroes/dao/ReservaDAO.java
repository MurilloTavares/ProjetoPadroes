package br.edu.ifpb.projetopadroes.dao;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import br.edu.ifpb.projetopadroes.entity.Reserva;
import java.util.List;

public interface ReservaDAO extends DAO<Reserva>{
    
    public Reserva buscar(int id);
    public List<Reserva> listFrom(Integer idAtracao);
    
    public boolean reservar(Atracao a, Reserva r);
    
}
