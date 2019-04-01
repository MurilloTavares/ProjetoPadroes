package br.edu.ifpb.projetopadroes.controller;

import br.edu.ifpb.projetopadroes.dao.AtracaoDAO;
import br.edu.ifpb.projetopadroes.entity.Atracao;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "atracaoController")
@ViewScoped
public class AtracaoController {
    
    @EJB
    private AtracaoDAO aDao;
    
    private Atracao atracao;
    
    @PostConstruct
    public void init() {
        atracao = new Atracao();
    }
    
    public void redReserva(Atracao a) throws IOException{
        String path = "reserva.xhtml?id="+a.getId();
        FacesContext.getCurrentInstance().getExternalContext().redirect(path);
    }
    
    public List<Atracao> listar(){
        return aDao.listar();
    }
    
    public void salvar() {
        aDao.salvar(atracao);
    }
    
    public void atualizar() {
        aDao.atualizar(atracao);
    }
    
    public void remover() {
        aDao.remover(atracao);
    }

    public Atracao getAtracao() {
        return atracao;
    }

    public void setAtracao(Atracao atracao) {
        this.atracao = atracao;
    }
    
}
