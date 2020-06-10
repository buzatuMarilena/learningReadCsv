package concurrencyHomeworkFestival;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyHomeworkFestival {

    public static void main(String args[]) {

        /**
        *Concurrency Homework
         * Festival Statistics
         * Every Festival has a gate, where people have to show their tickets.
         * Write an application where every person (client) is represented by a special Thread that is
         * instantiated with random ticket data. Possible ticket types: full, full-vip, free-pass, one-day,
         * one-day-vip
         * FestivalGate gate = new FestivalGate();
         * TicketType ticketType = // this should be enum value randomly generated.
         * FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
         * Every attendee validates the ticket, and the ticket-data is kept is a queue.
         * Meanwhile, every 5 seconds a FestivalStatisticsThread wakes up and reads the new data
         * from the gate and generates statistics: 
         *
         * e.g 
         * 100 people entered
         * 57 people have full tickets
         * 30 have free passes
         * 3 have full VIP passes
         * 10 have one-day passes
         * 0 have one-day VIP passes
         *
         * FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
         * statsThread.start();
         * Note:
         *  There can be only one stats Thread
         *  Stats thread reads from the gate-data only if it's not empty
         *  There can be unlimited attendee threads
         *  Attendee threads can add data to the gate regardless of the gate data being empty
         * or full
         *  The app must randomly generate multiple attendee threads - at least 100
         *  Use Thread.sleep in both thread types
         *  Try synchronizing the data
         *  Implement Runnable or extend ThreaConcurrency Homework
         * Festival Statistics
         * Every Festival has a gate, where people have to show their tickets.
         * Write an application where every person (client) is represented by a special Thread that is
         * instantiated with random ticket data. Possible ticket types: full, full-vip, free-pass, one-day,
         * one-day-vip
         * FestivalGate gate = new FestivalGate();
         * TicketType ticketType = // this should be enum value randomly generated.
         * FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
         * Every attendee validates the ticket, and the ticket-data is kept is a queue.
         * Meanwhile, every 5 seconds a FestivalStatisticsThread wakes up and reads the new data
         * from the gate and generates statistics: 
         *
         * e.g 
         * 100 people entered
         * 57 people have full tickets
         * 30 have free passes
         * 3 have full VIP passes
         * 10 have one-day passes
         * 0 have one-day VIP passes
         *
         * FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
         * statsThread.start();
         * Note:
         *  There can be only one stats Thread
         *  Stats thread reads from the gate-data only if it's not empty
         *  There can be unlimited attendee threads
         *  Attendee threads can add data to the gate regardless of the gate data being empty
         * or full
         *  The app must randomly generate multiple attendee threads - at least 100
         *  Use Thread.sleep in both thread types
         *  Try synchronizing the data
         *  Implement Runnable or extend Thread
        * **/

        ArrayDeque<String> clintiQueue = new ArrayDeque<>();
        AtomicInteger var = new AtomicInteger(7);

        Thread threadAddQueue = new Thread(() -> {
            while (var.get() >0){
                Client client = new Client();
                clintiQueue.addLast(client.getTicket());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var.getAndDecrement();
            }
            //System.out.println(clintiQueue.size() + " people entered");
        });

        Thread threadAddQueue2 = new Thread(() -> {
            while (var.get() >0 ){
                Client client = new Client();
                clintiQueue.addLast(client.getTicket());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var.getAndDecrement();
            }
        });

        threadAddQueue.start();
        threadAddQueue2.start();

        Thread statistics = new Thread(() -> {

            int full =0;
            int full_vip = 0;
            int free_pass =0;
            int one_day = 0;
            int one_day_vip = 0;

               try {
                   while (!clintiQueue.isEmpty()) {

                       try {
                           Thread.sleep(5000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                       if (clintiQueue.getFirst().equals("full")) {
                           full++;
                           clintiQueue.removeFirst();
                       }
                       if (clintiQueue.getFirst().equals("full-vip")) {
                           full_vip++;
                           clintiQueue.removeFirst();
                       }
                       if (clintiQueue.getFirst().equals("free-pass")) {
                           free_pass++;
                           clintiQueue.removeFirst();
                       }
                       if (clintiQueue.getFirst().equals("one-day")) {
                           one_day++;
                           clintiQueue.removeFirst();
                       }
                       if (clintiQueue.getFirst().equals("one-day-vip")) {
                           one_day_vip++;
                           clintiQueue.removeFirst();
                       }
                   }
               }catch (NoSuchElementException e){
                   e.printStackTrace();
               }
            System.out.println(full + "people have full tickets");
            System.out.println(full_vip + "have free passes");
            System.out.println(free_pass + "have full VIP passes");
            System.out.println(one_day + "have one-day passes");
            System.out.println(one_day_vip + "have one-day VIP passes");

        });
        statistics.start();


    }
}
