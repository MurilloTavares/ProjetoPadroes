package br.edu.ifpb.projetopadroes.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atracao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataApresentacao;
    @Embedded
    private Valor valorIngresso;
    private int duracaoMin;
    
    @OneToMany
    @JoinColumn(name = "atracao")
    private List<Reserva> reservas;
    
    // numero maximo de reservas
    private int quantIngresso;

    public Atracao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataApresentacao() {
        return dataApresentacao;
    }

    public void setDataApresentacao(Date dataApresentacao) {
        this.dataApresentacao = dataApresentacao;
    }

    public Valor getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(Valor valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int getQuantIngresso() {
        return quantIngresso;
    }

    public void setQuantIngresso(int quantIngresso) {
        this.quantIngresso = quantIngresso;
    }
    
}
