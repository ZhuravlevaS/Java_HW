package lessons.lesson_10_04;

import lombok.Getter;

import java.util.List;


@Getter
public class Person {
    private int id;
    private static int countId = 0;
    private String name;
    private  String surname;
    private Address address;
    private double salary;
    private Car auto;
    private List<BankAccount> bankAccounts;
    private Country citizenship;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAuto(Car auto) {
        this.auto = auto;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void setCitizenship(Country citizenship) {
        this.citizenship = citizenship;
    }

    public Person(String name, String surname, Address address, double salary, Car auto, List<BankAccount> bankAccounts, Country citizenship) {
        this.id = countId + 1;
        countId++;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.salary = salary;
        this.auto = auto;
        this.bankAccounts = bankAccounts;
        this.citizenship = citizenship;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id + '\''+
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address.toString() +
                ", salary=" + salary +
                ", citizenship=" + citizenship +
                ", auto=" + auto.toString() +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
