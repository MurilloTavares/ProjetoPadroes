package br.edu.ifpb.projetopadroes.jsf.converter;

import br.edu.ifpb.projetopadroes.entity.Valor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converter.valor")
public class ValorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String replace = string.replace(",", ".");
        return new Valor(Float.parseFloat(replace));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Valor) o).getFormatado();
    }
    
}
