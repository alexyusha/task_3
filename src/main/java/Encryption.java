import java.util.HashMap;
import java.util.Map;

public class Encryption {

    private  String checkLengthLine(String line){
        if (line.length() > 100){
            line = line.substring(0, 100);
        }
        return line;
    }

   public String encryption(String string){
        String сheck = checkLengthLine(string);
        String binary = stringToBinary(сheck);
        HashMap<Integer, Integer> hashMap = sequenceAmount(binary);
        String answer = buildString(hashMap, binary);
        return  answer;
    }

    private   String stringToBinary(String string){
        StringBuilder fullBinary = new StringBuilder();
        for (int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);
            String binary = Integer.toBinaryString(ch);
            String temp = ("00000000" + binary).substring(binary.length());
            fullBinary.append(temp);
        }
        return fullBinary.toString();
    }

    private   HashMap<Integer, Integer> sequenceAmount(String string){
        int count = 1;
        int marker = 0;
        String[] symbolArray = string.split("");
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 1; i < symbolArray.length; i++) {
            if (symbolArray[i].equals(symbolArray[i-1])){
                count++;
                marker++;
            }
            else{
                hashMap.put(marker, count);
                count = 1;
                marker++;
            }
            if (i == symbolArray.length -1){
                hashMap.put(marker, count);
            }
        }
        return hashMap;
    }

    private String getZero(int count){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count;i++){
            builder.append("0");
        }
        return builder.toString();
    }

    private String buildString(HashMap<Integer, Integer> map, String string){
        String zero = "00";
        String one = "0";
        StringBuilder encrypt = new StringBuilder();
        String[] symbolArray = string.split("");
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (symbolArray[pair.getKey()].equals("0")){
                encrypt.append(zero).append(" ").append(getZero(pair.getValue())).append(" ");
            }
            else{
                encrypt.append(one).append(" ").append(getZero(pair.getValue())).append(" ");
            }
        }
        encrypt.deleteCharAt(encrypt.length()-1);
       return encrypt.toString();
    }
}
