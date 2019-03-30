package br.edu.ifpb.projetopadroes.controller;

import br.edu.ifpb.projetopadroes.dao.AtracaoDAO;
import br.edu.ifpb.projetopadroes.dao.ReservaDAO;
import br.edu.ifpb.projetopadroes.entity.Atracao;
import br.edu.ifpb.projetopadroes.entity.Reserva;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ReservaController {
    
    @EJB
    private ReservaDAO rDao;
    
    private Atracao atracao;
    private Reserva reserva;

    public void reservar(){
        rDao.reservar(atracao, reserva);
    }
    
    // Getters e Setters
    public Atracao getAtracao() {
        return atracao;
    }

    public void setAtracao(Atracao atracao) {
        this.atracao = atracao;
    }
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
}
