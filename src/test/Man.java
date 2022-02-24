package test;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/09/ 11:18
 */
public class Man implements Cloneable{
    String name;
    int age;
    int gender;

    public Man() {
    }

    public Man(String name) {
        this.name = name;
    }

    public Man(String name, int age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    protected Man clone() throws CloneNotSupportedException {
        return (Man)super.clone();
    }
}
