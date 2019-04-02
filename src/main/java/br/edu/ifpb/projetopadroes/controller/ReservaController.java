package br.edu.ifpb.projetopadroes.controller;

import br.edu.ifpb.projetopadroes.dao.AtracaoDAO;
import br.edu.ifpb.projetopadroes.dao.ReservaDAO;
import br.edu.ifpb.projetopadroes.entity.Atracao;
import br.edu.ifpb.projetopadroes.entity.Reserva;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ReservaController implements Serializable{
    
    @EJB
    private ReservaDAO rDao;
    @EJB
    private AtracaoDAO aDao;
    
    private Atracao atracao;
    private Reserva reserva;

    @PostConstruct
    public void init() {
        String param = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("id");
        int id = Integer.parseInt(param);
        atracao = aDao.buscar(id);
        reserva = new Reserva();
    }
    
    public void reservar(){
        rDao.reservar(atracao, reserva);
        atracao = aDao.buscar(atracao);
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
