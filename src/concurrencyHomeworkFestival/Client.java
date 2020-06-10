package concurrencyHomeworkFestival;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Client {

    private String ticket;
    List<String> ticketList = Arrays.asList("full","full-vip", "free-pass","one-day","one-day-vip");

    public String getTicket() {
        return getRandomElement(ticketList);
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getRandomElement(List<String> list){
        Random random = new Random();
        return  list.get(random.nextInt(list.size()));
    }
}
