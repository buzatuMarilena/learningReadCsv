package exercitiiBubu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FishProblem {

    public static void main(String args[]) {

       // List<Integer> direction = new ArrayList<>(Arrays.asList(0,1,0,0,0));
      //  List<Integer> size = new ArrayList<>(Arrays.asList(4,3,2,1,5));
        List<Integer> direction = new ArrayList<>();
        direction.add(0);
        direction.add(1);
        direction.add(0);
        direction.add(1);
        direction.add(0);
        direction.add(0);
        List<Integer> size = new ArrayList<Integer>();
        size.add(2);
        size.add(6);
        size.add(4);
        size.add(3);
        size.add(1);
        size.add(5);


        System.out.println("LaLALA"+noOfSurvivals(direction,size));


    }

    public static Integer noOfSurvivals(List<Integer> direction, List<Integer> size){

        Stack<Integer> survivalsStack = new Stack<>();
        int survivals = 0;
        for (int i=0;i<direction.size();i++){
            if(survivalsStack.isEmpty()) {
                 if(direction.get(i)==1)
                     survivalsStack.push(i);
                 else
                     survivals ++;
            }
            else {

                if (direction.get(survivalsStack.lastElement()).equals(0)){
                    survivalsStack.push(i);
                }
                else{
                    if (size.get(i) > size.get(survivalsStack.lastElement())) {
                                survivalsStack.pop();
                                survivalsStack.push(i);

                    }


                    if(direction.get(i).equals(1)){
                        survivalsStack.push(i);
                    }
                }
            }
        }

        return survivalsStack.size() + survivals;
    }

}
