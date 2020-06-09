package exercitiiBubu;

import java.util.ArrayList;
import java.util.Stack;

public class BracketsProblemV2 {

    public static void main(String args[]) {

        String s1 = "{(){}[()]}";

        ArrayList<String> strArray = new ArrayList(s1.length());
        ArrayList<String> copyStrArray = new ArrayList(s1.length());

        for (int i = 0; i < s1.length(); i++) {
            strArray.add(String.valueOf(s1.charAt(i)));
            copyStrArray.add(String.valueOf(s1.charAt(i)));
        }
        if(correctNestedOrNot(strArray))
            System.out.println(s1 + " OK");
        else
            System.out.println(s1 + " NOT OK");


    }

    public static Boolean correctNestedOrNot(ArrayList<String> arrayParam){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < arrayParam.size(); i++){
            if(isOpenBracket(arrayParam.get(i))) {
                stack.push(arrayParam.get(i));
            } else {

                if(!stack.isEmpty() && isPair(stack.lastElement(), arrayParam.get(i)))
                    stack.pop();
                else
                    return false;
            }
        }

        if(stack.isEmpty())
            return true;

        return false;
    }



    public static Boolean isOpenBracket(String bracket){
        if(bracket.equals("{")||bracket.equals("[")||bracket.equals("("))
            return true;
        return false;
    }

    public static Boolean isPair(String bracket1, String bracket2){
        if(bracket1.equals("(") && bracket2.equals(")") || bracket1.equals("{") && bracket2.equals("}") || bracket1.equals("[") && bracket2.equals("]"))
            return true;
        return false;
    }

}
