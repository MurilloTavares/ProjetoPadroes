package br.edu.ifpb.projetopadroes.entity;

import java.io.Serializable;
import java.text.ParseException;
import javax.persistence.Embeddable;
import javax.swing.text.MaskFormatter;

@Embeddable
public class CPF implements Serializable{
    
    private String numericCpf;

    public CPF() {
    }

    public CPF(String cpf) {
        setCpf(cpf);
    }

    public void setCpf(String cpf) {
        if(cpf == null) cpf = "";
        this.numericCpf = cpf.replaceAll("\\D+",""); // extraindo apenas numeros
    }
    
    public String getNumericCpf() {
        return numericCpf;
    }
    
    public String getFormatedCpf(){
        if(!isValid()) return "";
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");  
            mf.setValueContainsLiteralCharacters(false); 
            return mf.valueToString(numericCpf);
        } catch (ParseException ex) {
            return "";
        }
    }
    
    public boolean isValid(){
        return numericCpf.length() == 11;
    }
        
}