package objectContainers;

import java.util.Objects;

public class PersoanaModel{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;

        final  PersoanaModel other = (PersoanaModel) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (this.age != other.age) {
            return false;
        }

        return true;
    }
}
