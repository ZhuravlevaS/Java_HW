package lessons.testCollection.university_tasks;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person implements Comparable<Person>, Descriable {
    private String name;
    private String surname;
    private int age;

    public void setName(String name) {
        if(!name.isEmpty()) this.name = name;
    }

    public void setSurname(String surname) {
        if(!surname.isEmpty()) this.surname = surname;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    @Override
    public int compareTo(Person o) {
        int result = this.age - o.getAge();
        if (result == 0){
            result = this.name.compareTo(o.getName());
        }

        return result;
    }

    public Person(String name, String surname, int age) {
            // TODO: make exceptions
        if(!name.isEmpty()) this.name = name;
        if(!surname.isEmpty()) this.surname = surname;
        if (age > 0) this.age = age;
    }

    @Override
    public String describe() {
        return "Это Person с именем " + name + " " + surname;
    }
}
