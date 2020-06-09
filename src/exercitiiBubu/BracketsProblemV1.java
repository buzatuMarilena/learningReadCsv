package exercitiiBubu;

import java.util.ArrayList;

public class BracketsProblemV1 {

    public static void main(String args[]) {

        String s1 = "{}{}{}}[]][";



        String s2 = "][";
        String s3 = "{[]()}";
        String s4 = "{{[{}]}}";

        correctNestedOrNot(s1);
    }

    public static void correctNestedOrNot(String stringParam){

        ArrayList<String> strArray = new ArrayList(stringParam.length());
        for (int i = 0; i < stringParam.length(); i++) {
            strArray.add(String.valueOf(stringParam.charAt(i)));
        }

        isComplementarList(strArray);

    }

    public static Boolean isComplementar(String s1, String s2) {
        if (s1.equals("(") && s2.equals(")") || s1.equals("{") && s2.equals("}") || s1.equals("[") && s2.equals("]"))
            return true;
        else return false;
    }

    public static void isComplementarList(ArrayList<String> list){
        for (int i=0; i < list.size() -1; i++){
            if(isComplementar(list.get(i),list.get(i+1))) {
                list.remove(list.get(i));
                list.remove(list.get(i));
            }
        }

        if(list.isEmpty())
            System.out.println("E BUMA");
        else {
            if (continueOrNot(list.get(0), list))
                isComplementarList(list);
            else
                System.out.println("NU E BUNA");
        }


    }

    public static Boolean continueOrNot(String caracter, ArrayList<String> list){
        for(String temp:list){
            if(caracter.equals("(") && temp.equals(")") ||
                    caracter.equals("{") && temp.equals("}")
                    || caracter.equals("[") && temp.equals("]"))
            return true;
        }
        return false;
    }

}
