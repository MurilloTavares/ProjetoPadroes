package br.edu.ifpb.projetopadroes.entity;

import br.edu.ifpb.projetopadroes.util.DecimalRounder;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
class Valor implements Serializable {
    
    private float valor;
    
    public Valor(){
        setValor(0);
    }
    
    public Valor(float valor){
        setValor(valor);
    }
    
    public void setValor(float valor){
        this.valor = DecimalRounder.round(valor, 2);
    }
    
    public float getValor(){
        return this.valor;
    }
    
    public String getFormatado() {
        return String.format("R$ %.2f", valor);
    }
    
}
