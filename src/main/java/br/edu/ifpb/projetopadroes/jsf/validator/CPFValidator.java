package br.edu.ifpb.projetopadroes.jsf.validator;

import br.edu.ifpb.projetopadroes.entity.CPF;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.cpf")
public class CPFValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        CPF cpf = (CPF) value;
        if(!cpf.isValid()){
            FacesMessage msg = new FacesMessage("CPF inválido");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
