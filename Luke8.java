import java.util.ArrayList;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState.PassType;

public class Luke8{
    public static void main(String[] args){
        int sumJuletall = 0;
        int tak = 10000000;
        int i = 0;
        sekvensInneholder1(156);
    }

    static boolean sekvensInneholder1(int tall){
        ArrayList<Integer> siffere = new ArrayList<Integer>();
        String strTall = Integer.toString(tall);
        for (int i = 0; i < strTall.length(); i ++){
            char character = strTall.charAt(i);
            siffere.add(Character.getNumericValue(character));

        }
        System.out.println(siffere);
        return true;
    
        
    }
}