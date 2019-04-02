package br.edu.ifpb.projetopadroes.jsf.converter;

import br.edu.ifpb.projetopadroes.entity.CPF;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converter.cpf")
public class CpfConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return new CPF(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((CPF) value).getFormatedCpf();
    }
    
}
