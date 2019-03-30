package br.edu.ifpb.projetopadroes.notificador;

public enum OpcaoNotificador {
    
    EMAIL("Email", new NotificadorReservaEmail()),
    SMS("SMS", new NotificadorReservaSMS()),
    PUSH("Push", new NotificadorReservaPush());
    
    private String label;
    private NotificadorReserva ntf;
    private boolean ativado;

    private OpcaoNotificador(String label, NotificadorReserva ntf) {
        this.label = label;
        this.ntf = ntf;
    }
    
    public String getLabel(){
        return label;
    }
    
    public NotificadorReserva getNotificador() {
        return ntf;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }
    
}
