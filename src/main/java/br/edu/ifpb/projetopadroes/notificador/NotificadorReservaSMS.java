package br.edu.ifpb.projetopadroes.notificador;

import br.edu.ifpb.projetopadroes.entity.Reserva;

public class NotificadorReservaSMS implements NotificadorReserva {

    @Override
    public void notificar(Reserva r) {
        System.out.println("Notificação de SMS ainda não disponivel. :(");
    }

}
