package br.edu.ifpb.projetopadroes.util;

public enum Ordenacao {
    DATA(new OrdenarAtracoesData()),
    INGRESSO(new OrdenarAtracoesIngresso());
    
    private OrdenarAtracoesStrategy strategy;

    private Ordenacao(OrdenarAtracoesStrategy strategy) {
        this.strategy = strategy;
    }

    public OrdenarAtracoesStrategy getStrategy() {
        return strategy;
    }
    
}
