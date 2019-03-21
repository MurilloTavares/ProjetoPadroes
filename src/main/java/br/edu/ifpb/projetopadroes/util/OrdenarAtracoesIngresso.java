package br.edu.ifpb.projetopadroes.util;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import br.edu.ifpb.projetopadroes.entity.Valor;
import java.util.Comparator;
import java.util.List;

public class OrdenarAtracoesIngresso extends OrdenarAtracoesStrategy{

    @Override
    public List<Atracao> ordenar(List<Atracao> lista) {
        lista.sort(new Comparator<Atracao>(){
            @Override
            public int compare(Atracao a1, Atracao a2) {
                float valor1 = a1.getValorIngresso().getValor();
                float valor2 = a2.getValorIngresso().getValor();
                
                if(valor1 == valor2){
                    return 0;
                }
                return valor1 < valor2 ? -1 : 1;
            }
        });
        return lista;
    }
    
}