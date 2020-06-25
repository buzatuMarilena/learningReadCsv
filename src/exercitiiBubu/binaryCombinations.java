package exercitiiBubu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Output:
 * 0
 * 1
 * 00
 * 01
 * 10
 * 11
 * 000
 * 001
 * 010
 * 011
 * 100
 * ..
 * ..
 * ..
 */

public class binaryCombinations {

    public static void main(String args[]) {

      binaryCombinations bn = new binaryCombinations();
      bn.generate();

      for(int i=0;i<100;i++) {
          String test = Integer.toBinaryString(i);
          System.out.println("TEST " + test);
      }

    }

    private void generate(){
        Queue<String> queue = new LinkedList<>();
        queue.add("0");
        queue.add("1");
        int count = 100;
        while (count>0){
            String peek = queue.poll();
            System.out.println(peek);
            queue.add(peek+"0");
            queue.add(peek+"1");
            count--;
        }
    }


}
