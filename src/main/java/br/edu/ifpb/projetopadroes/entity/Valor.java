package br.edu.ifpb.projetopadroes.entity;

import br.edu.ifpb.projetopadroes.util.DecimalRounder;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Valor implements Serializable {
    
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Float.floatToIntBits(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Valor other = (Valor) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        return true;
    }
    
    
    
}
