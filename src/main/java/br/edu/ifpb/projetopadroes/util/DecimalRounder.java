package br.edu.ifpb.projetopadroes.util;

import java.math.BigDecimal;

public class DecimalRounder {
    
    public static float round(float valor, int decimal) {
        BigDecimal bd = new BigDecimal(Float.toString(valor));
        bd = bd.setScale(decimal, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
}
