package pro.sky.skyprospringdemo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Person {
    String firstName;
    String secondName;
    String passport;
    Set<Integer> professionNumber;

    public Person(String firstName, String secondName, String passport, int professionNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.passport = passport;
        this.professionNumber = new HashSet<>(List.of(professionNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person employee = (Person) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(secondName, employee.secondName) &&
                Objects.equals(passport, employee.passport) &&
                Objects.equals(professionNumber, employee.professionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, passport, professionNumber);
    }

}
