package objectContainers;

import java.util.List;

public class HobbyModel extends PersoanaModel{

    private String nameOfHobby;
    private int frequency;
    private List<AdressModel> listOfAdresses;

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<AdressModel> getListOfAdresses() {
        return listOfAdresses;
    }

    public void setListOfAdresses(List<AdressModel> listOfAdresses) {
        this.listOfAdresses = listOfAdresses;
    }
}
