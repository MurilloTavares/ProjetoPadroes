package br.edu.ifpb.projetopadroes.controller;

import br.edu.ifpb.projetopadroes.dao.AtracaoDAO;
import br.edu.ifpb.projetopadroes.entity.Atracao;
import br.edu.ifpb.projetopadroes.util.Ordenacao;
import br.edu.ifpb.projetopadroes.util.OrdenarAtracoesData;
import br.edu.ifpb.projetopadroes.util.OrdenarAtracoesIngresso;
import br.edu.ifpb.projetopadroes.util.OrdenarAtracoesStrategy;
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
    private List<Atracao> lista;
    
    private Atracao atracao;
    
    @PostConstruct
    public void init() {
        atracao = new Atracao();
        lista = aDao.listar();
    }
    
    public void ordenarPorIngresso() {
        ordenarPor(new OrdenarAtracoesIngresso());
    }
    
    public void ordenarPorData() {
        ordenarPor(new OrdenarAtracoesData());
    }
    
    public void ordenarPor(OrdenarAtracoesStrategy strategy){
        this.lista = strategy.ordenar(lista);
    }
    
    public void redReserva(Atracao a) throws IOException{
        String path = "assentos.xhtml?id="+a.getId();
        FacesContext.getCurrentInstance().getExternalContext().redirect(path);
    }
    
    public List<Atracao> listar(){
        return lista;
    }
    
    public void salvar() throws IOException {
        aDao.salvar(atracao);
        String path = "home.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(path);
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
