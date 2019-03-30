package br.edu.ifpb.projetopadroes.notificador;

import br.edu.ifpb.projetopadroes.entity.Reserva;
import java.util.List;

public class NotificarReserva {
    
    List<NotificadorReserva> notificadores;
    
    public void registrarNotificador(NotificadorReserva ntf) {
        notificadores.add(ntf);
    }
    
    public void desregistrarNotificador(NotificadorReserva ntf) {
        notificadores.remove(ntf);
    }
    
    public void notificar(Reserva r) {
        for(NotificadorReserva ntf : notificadores){
            ntf.notificar(r);
        }
    }
    
}
