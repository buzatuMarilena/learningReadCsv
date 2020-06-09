package java8Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Homework {

    public static void main(String args[]){

        /**
         * Create a Person / Car custom object of choice with any number of fields (> 2) of different types.
         *
         * 1) Write 5 different instances of that object. Add the instances to a list.
         * **/

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();

        person1.setName("Maani");
        person1.setAge(37);

        person2.setName("Anna");
        person2.setAge(27);

        person3.setName("Bob");
        person3.setAge(17);

        person4.setName("Mari");
        person4.setAge(7);

        person5.setName("Adda");
        person5.setAge(40);

        List<Person> personList = Arrays.asList(person1,person2,person3,person4,person5);

        /**
         * 2) Find the elements containing the letter "a"; that start with "M"; and print them out.
         * Add the instances to a set.
         * */

        findElements(personList);

        /**
         * 3) Find the "min" using a custom comparing criteria of choice
         * */

        Collections.sort(personList, Comparator.comparing(Person::getName));
        System.out.println("Min: "+ personList.get(0).getName());


        /**4) Generate 5 random Strings and add them to a Set. Find the "max" (while explaining as
         Javadoc how comparing Strings works)
         * */

        findMaxInRandomStrings();

        /**
         * 5) Generate a random number of Integers and then count them. "Map" the exponential to
         * the numbers and then print them out.
         * */

        exponentialToTheRandomNumbers();

        /**
         * Create a map of "n" (K,V) elements and print "how many" elements have value over 10
         * (the key is of your choice)
         */

        mapElementsHaveValueOver10();

    }



    private static void findElements(List<Person> personList) {
        System.out.println("elements containing the letter \"a\" that start with \"M\"");
        List<Person> filteredList = personList.stream().filter(person -> String.valueOf(person.getName().charAt(0)).equals("M") &&
                person.getName().contains("a"))
                .collect(Collectors.toList());
        for(Person temp:filteredList){
            System.out.println(temp.getName());
        }
    }

    private static void findMaxInRandomStrings(){

        int leftLimit = 97; //litera a
        int rightLimit = 122; //z
        int targetStringLenght = 7;
        Random random = new Random();
        List<String> randomStrings = new ArrayList<>();
        for (int i=0;i<5;i++) {
            randomStrings.add(random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLenght)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
        }
        System.out.println("LISTA RANDOM:");
        for (String temp: randomStrings){
            System.out.println(temp);
        }
        Collections.sort(randomStrings);

        System.out.println("max din lista randon: "+
        randomStrings.stream().reduce((first,second) -> second).orElse(null));
    }

    private static void exponentialToTheRandomNumbers() {
        Random rn = new Random();
        Random tempRn = new Random();
        int max = 7;
        int random = rn.nextInt(max);

        System.out.println("List of random Integers: ");
        List<Integer> randomIntList = new ArrayList<>();
        for(int i=0;i<random;i++){
            Integer temp = tempRn.nextInt(7);
            randomIntList.add(temp);
            System.out.println(temp);
        }

        System.out.println("exponential to the numbers: ");
        for(Integer temp: randomIntList){
            System.out.println(Math.pow(temp, randomIntList.size()));
        }

    }

    private static void mapElementsHaveValueOver10(){

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,11);
        map.put(3,7);
        map.put(4,56);
        int i=0;

        for(Integer key : map.keySet()){

            if(map.get(key)>10)
                i++;

        }
        System.out.println("how many elements have value over 10: "+i);
    }
}
