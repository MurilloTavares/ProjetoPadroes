package br.edu.ifpb.projetopadroes.util;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import java.util.List;

public interface OrdenarAtracoesStrategy {
    public List<Atracao> ordenar(List<Atracao> lista);
}
