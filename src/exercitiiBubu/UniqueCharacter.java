package exercitiiBubu;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueCharacter {
    public static void main(String args[]) {

        List<Character> charactersList = Arrays.asList('x','t','p','z','a');
        Collections.sort(charactersList);

        if(uniqueCharacters(charactersList))
            System.out.println("OK");
        else
            System.out.println("NOT OK");

        if(uniqueCharactersWithSET(charactersList))
            System.out.println("OK SET");
        else
            System.out.println("NOT OK SET");

    }

    private static Boolean uniqueCharacters(List<Character> charactersList) {

        for(int i=0;i<charactersList.size()-1;i++){
            if(charactersList.get(i).equals(charactersList.get(i+1))){
                return false;
            }
        }
        return true;
    }

    public static Boolean uniqueCharactersWithSET(List<Character> characterList){
        Set<Character> set = new HashSet<>();
        for(Character temp:characterList){
            if(set.contains(temp))
                return false;
            else
                set.add(temp);
        }

        return true;
    }

}
