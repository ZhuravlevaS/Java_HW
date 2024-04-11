package lessons.lesson_10_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private  String surname;
    private Address address;
    private double salary;
    private Car auto;
    private BankAccount[] bankAccounts;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address.toString() +
                ", salary=" + salary +
                ", auto=" + auto.toString() +
                ", bankAccounts=" + Arrays.toString(bankAccounts) +
                '}';
    }
}
