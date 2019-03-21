package br.edu.ifpb.projetopadroes.util;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import java.util.List;

public abstract class OrdenarAtracoesStrategy {
    public abstract List<Atracao> ordenar(List<Atracao> lista);
}
