package tolya.vaadin;

public class People {
    private int id;
    private String name;
    private String surname;
    private String town;
    private String adress;
    private int age;

    public People() {
    }

    public People(int id, String name, String surname, String town, String adress, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.town = town;
        this.adress = adress;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTown() {
        return town;
    }

    public String getAdress() {
        return adress;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
