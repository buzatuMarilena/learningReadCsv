package objectContainers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ObjectContainersMain {

    public static void main(String args[]) {

        /** 1. You need to store Persoane in a TreeSet. Define 2 Comparators (one for name - nume
         and one for age-varsta) that will be used when creating the TreeSet;

         Add Persoane to the TreeSet; iterate throug the treeset and print the name and the age;
         NOTE: if you are using a Comparator, the class Persoana should not implement
         Comparable anymore.**/

        Comparator<PersoanaModel> comparePersonsByName = Comparator.comparing(PersoanaModel::getName);

        Comparator<PersoanaModel> comparePersonsByAge = Comparator.comparing(PersoanaModel::getAge);

        PersoanaModel person1 = new PersoanaModel();
        person1.setName("TEST1");
        person1.setAge(78);
        PersoanaModel person2 = new PersoanaModel();
        person2.setName("TEST2");
        person2.setAge(21);
        PersoanaModel person3 = new PersoanaModel();
        person3.setName("TEST3");
        person3.setAge(98);


        Set<PersoanaModel> personsSortByAge = new TreeSet<>(comparePersonsByAge);

        personsSortByAge.add(person1);
        personsSortByAge.add(person2);
        personsSortByAge.add(person3);

        Set<PersoanaModel> personsSortByName = new TreeSet<>(comparePersonsByName);

        personsSortByName.add(person1);
        personsSortByName.add(person2);
        personsSortByName.add(person3);

        System.out.println("SORT BY AGE \n");
        for (PersoanaModel temp:personsSortByAge){
            System.out.println("Name: "+temp.getName()+" age: "+temp.getAge());
        }


        System.out.println("\nSORT BY NAME \n");
        for (PersoanaModel temp:personsSortByName){
            System.out.println("Name: "+temp.getName()+" age: "+temp.getAge());
        }

        /** 2. You need to store some information about some persons: for one person, you need a list
         of his/her hobbies;
         Define for Hobby a class that contains:
         * Name of hobby (String) – eq: cycling, swimming
         * Frequency (int) – how many times a week they practice it
         * List of Addresses where this hobby can be practiced (List&lt;Adresa&gt;)
         You will use a HashMap (Persoana, List (Hobby))
         NOTE: equals() from Persoana must be overriden
         Add some information to this map; for a certain Persoana, print the names of the hobbies
         and the countries where it can be practiced **/

        HashMap<PersoanaModel, List<HobbyModel>> hMap = new HashMap<>();

        List<HobbyModel> listOfHobby = new ArrayList<>();
        HobbyModel hobbyModel1 = new HobbyModel();
        hobbyModel1.setNameOfHobby("cycling");
        hobbyModel1.setFrequency(2);
        List<AdressModel> adressList = new ArrayList<>();
        AdressModel adressModel1 = new AdressModel();
        adressModel1.setStreet("StradaTest1");
        adressModel1.setNoOfStreet(1);
        AdressModel adressModel2 = new AdressModel();
        adressModel2.setStreet("StradaTest2");
        adressModel2.setNoOfStreet(3);
        adressList.add(adressModel1);
        adressList.add(adressModel2);
        hobbyModel1.setListOfAdresses(adressList);

        HobbyModel hobbyModel2 = new HobbyModel();
        hobbyModel2.setNameOfHobby("swimming");
        hobbyModel2.setFrequency(3);
        hobbyModel2.setListOfAdresses(adressList);

        listOfHobby.add(hobbyModel1);
        listOfHobby.add(hobbyModel2);





        HobbyModel personWithHobby1 = new HobbyModel();
        personWithHobby1.setName("Dorel");
        personWithHobby1.setAge(11);


        HobbyModel personWithHobby2 = new HobbyModel();
        personWithHobby2.setName("Gigel");
        personWithHobby2.setAge(11);


        hMap.put(personWithHobby1,listOfHobby);
        hMap.put(personWithHobby2,listOfHobby);



        for (PersoanaModel key: hMap.keySet()){
            for(HobbyModel temp: hMap.get(key)) {
                for (AdressModel tempAdress : temp.getListOfAdresses()) {
                    System.out.println(key.getName() + "     hobbie: " + temp.getNameOfHobby() + " street " +
                            tempAdress.getStreet()+ "no " +tempAdress.getNoOfStreet());
                }
            }
        }


    }
}
