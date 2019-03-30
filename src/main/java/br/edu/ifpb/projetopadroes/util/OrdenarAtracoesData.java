package br.edu.ifpb.projetopadroes.util;

import br.edu.ifpb.projetopadroes.entity.Atracao;
import java.util.Comparator;
import java.util.List;

public class OrdenarAtracoesData implements OrdenarAtracoesStrategy{

    @Override
    public List<Atracao> ordenar(List<Atracao> lista) {
        lista.sort(new Comparator<Atracao>(){
            @Override
            public int compare(Atracao a1, Atracao a2) {
                if(a1.getDataApresentacao().before(a2.getDataApresentacao())){
                    return -1;
                } else if(a1.getDataApresentacao().after(a2.getDataApresentacao())){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return lista;
    }
    
}
