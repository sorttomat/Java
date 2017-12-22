import java.util.HashMap;

public class Luke22{
    public static void main(String[] args){

        String string = "FJKAUNOJDCUTCRHBYDLXKEODVBWTYPTSHASQQFCPRMLDXIJMYPVOHBDUGSMBLMVUMMZYHULSUIZIMZ"
        + "TICQORLNTOVKVAMQTKHVRIFMNTSLYGHEHFAHWWATLYAPEXTHEPKJUGDVWUDDPRQLUZMSZOJPSIKAIHLTONYXAULECXXKW"
        + "FQOIKELWOHRVRUCXIAASKHMWTMAJEWGEESLWRTQKVHRRCDYXNTLDSUPXMQTQDFAQAPYBGXPOLOCLFQNGNKPKOBHZWHRXAW"
        + "AWJKMTJSLDLNHMUGVVOPSAMRUJEYUOBPFNEHPZZCLPNZKWMTCXERPZRFKSXVEZTYCXFRHRGEITWHRRYPWSVAYBUHCERJXDC"
        + "YAVICPTNBGIODLYLMEYLISEYNXNMCDPJJRCTLYNFMJZQNCLAGHUDVLYIGASGXSZYPZKLAWQUDVNTWGFFYFFSMQWUNUPZRJM"
        + "THACFELGHDZEJWFDWVPYOZEVEJKQWHQAHOCIYWGVLPSHFESCGEUCJGYLGDWPIWIDWZZXRUFXERABQJOXZALQOCSAYBRHXQQ"
        + "GUDADYSORTYZQPWGMBLNAQOFODSNXSZFURUNPMZGHTAJUJROIGMRKIZHSFUSKIZJJTLGOEEPBMIXISDHOAIFNFEKKSLEXSJ"
        + "LSGLCYYFEQBKIZZTQQXBQZAPXAAIFQEIXELQEZGFEPCKFPGXULLAHXTSRXDEMKFKABUTAABSLNQBNMXNEPODPGAORYJXCHCG"
        + "KECLJVRBPRLHORREEIZOBSHDSCETTTNFTSMQPQIJBLKNZDMXOTRBNMTKHHCZQQMSLOAXJQKRHDGZVGITHYGVDXRTVBJEAHYBY"
        + "RYKJAVXPOKHFFMEPHAGFOOPFNKQAUGYLVPWUJUPCUGGIXGRAMELUTEPYILBIUOCKKUUBJROQFTXMZRLXBAMHSDTEKRRIKZUF"
        + "NLGTQAEUINMBPYTWXULQNIIRXHHGQDPENXAJNWXULFBNKBRINUMTRBFWBYVNKNKDFR";
        String subString = "ABCDA";
        HashMap<Character , Integer > characters = new HashMap<Character, Integer>();        
        for(int i = 0; i < subString.length(); i++){
            char character = subString.charAt(i);
            if(characters.containsKey(character)){
                characters.put(character, characters.get(character) + 1);
            }
            else{
                characters.put(character, 1);
            }
        }
        
        String shortestSubstring = string;
        for (int i = 0; i < string.length(); i++){
            char character = string.charAt(i);

            if (charInString(subString, character)){
                String possibleSolution = "";

                for (int j = i; j < string.length(); j++){
                    possibleSolution += string.charAt(j);

                    if (allCharsInString(possibleSolution, subString)){

                        if(possibleSolution.length() < shortestSubstring.length() && checkRightNumberOfCharacters(possibleSolution, characters)){
                            shortestSubstring = possibleSolution;
                            System.out.println(shortestSubstring);
    
                        }
                    }   
                }
            }   
        }
    }

    static int howManyOfCharInString(String string, char character){
        int count = 0;
        for (int i = 0; i < string.length(); i ++){
            if (string.charAt(i) == character){
                count ++;
            }
        }
        return count;
    }

    static boolean charInString(String string, char character){
        for (int i = 0; i < string.length(); i ++){
            if (string.charAt(i) == character){
                return true;
            }
        }
        return false;   
    }

    static boolean allCharsInString(String string, String characters){
        for (int i = 0; i < characters.length(); i++){
            char character = characters.charAt(i);
            if (charInString(string, character) != true){
                return false;
            }
        }
        return true;
    }

    static boolean checkRightNumberOfCharacters(String string, HashMap<Character, Integer> characters){
        for (int i = 0; i < string.length(); i++ ){
            if(characters.containsKey(string.charAt(i))){
                int number = characters.get(string.charAt(i));
                int antall = howManyOfCharInString(string, string.charAt(i));
                if (number != antall){
                    return false;
                }
            }
        }
        return true;
    }
}