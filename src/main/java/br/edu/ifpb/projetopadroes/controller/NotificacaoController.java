package br.edu.ifpb.projetopadroes.controller;

import br.edu.ifpb.projetopadroes.entity.Reserva;
import br.edu.ifpb.projetopadroes.notificador.NotificarReserva;
import br.edu.ifpb.projetopadroes.notificador.OpcaoNotificador;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NotificacaoController {
    
    private NotificarReserva notificador;
    private List<OpcaoNotificador> opcoes;
    
    @PostConstruct
    public void init() {
        opcoes = Arrays.asList(OpcaoNotificador.values());
    }
    
    public void addNotificador(OpcaoNotificador opcao){
        notificador.registrarNotificador(opcao.getNotificador());
    }
    
    public void removerNotificador(OpcaoNotificador opcao){
        notificador.desregistrarNotificador(opcao.getNotificador());
    }
    
    public void notificar(Reserva r){
        notificador.notificar(r);
    }

    public NotificarReserva getNotificador() {
        return notificador;
    }

    public List<OpcaoNotificador> getOpcoes() {
        return opcoes;
    }
    
}
