package br.edu.ifpb.projetopadroes.jsf.converter;

import br.edu.ifpb.projetopadroes.dao.AtracaoDAO;
import br.edu.ifpb.projetopadroes.entity.Atracao;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@RequestScoped
public class AtracaoIdConverter implements Converter{

    @EJB
    private AtracaoDAO dao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return dao.buscar(Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return String.valueOf(((Atracao) o).getId());
    }
    
}
