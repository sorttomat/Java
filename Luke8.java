import java.math.BigInteger;
import java.util.ArrayList;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState.PassType;

public class Luke8 {
    public static void main(String[] args) {
        int tak = 10000000;
        System.out.println(findAllChristmasNumbers(tak));
    }

    static BigInteger findAllChristmasNumbers(int max){
        int i = 0;
        BigInteger sum = BigInteger.valueOf(0);
        while (i <= max){
            ArrayList<Integer> sequence = getSequence(i);
            boolean isChristmasNumber = checkChristmasNumber(sequence);
            if(isChristmasNumber){
                sum = sum.add(BigInteger.valueOf(i));
            }
            i ++;
        }
        return sum;
    }

    static boolean checkChristmasNumber(ArrayList<Integer> sequence){
        for(int i = 0; i < sequence.size(); i ++){
            if(sequence.get(i) == 1){
                return true;
            }
        }
        return false;
    }

    static ArrayList<Integer> getSequence(int tall){
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        boolean inArray = intInArray(sequence, tall);
        while(inArray == false){
            inArray = intInArray(sequence, tall);            
            sequence.add(tall);            
            tall = summerSifferePow(tall);
        }
        return sequence;
    }

    static int summerSifferePow(int tall) {
        ArrayList<Integer> siffere = intToList(tall);
        int sumPow = 0;
        for (int i = 0; i < siffere.size(); i ++){
            sumPow += intPowerOfTwo(siffere.get(i));
        }
        return sumPow;
    }

    static int intPowerOfTwo(int tall) {
        return tall * tall;
    }

    static ArrayList<Integer> intToList(int tall){
        ArrayList<Integer> siffere = new ArrayList<Integer>();
        String strTall = Integer.toString(tall);
        for (int i = 0; i < strTall.length(); i ++){
            char character = strTall.charAt(i);
            siffere.add(Character.getNumericValue(character));
        }
        return siffere;
    }

    static boolean intInArray(ArrayList<Integer> sequence, int number){
        for(int i = 0; i < sequence.size(); i ++){
            if(sequence.get(i) == number){
                return true;
            }
        }
        return false;
    }
}