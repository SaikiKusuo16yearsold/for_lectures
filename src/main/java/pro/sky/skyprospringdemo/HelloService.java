package pro.sky.skyprospringdemo;

import java.util.List;

public interface HelloService {
    String sayHello();

    String answerHello(String name, int userName) throws BadPersonNumberException;

    String getPersonByNumber(int number);

    List<Person> getPersonList(Integer number);

}
