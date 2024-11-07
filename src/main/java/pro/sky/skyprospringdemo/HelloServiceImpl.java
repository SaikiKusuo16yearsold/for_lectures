package pro.sky.skyprospringdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class HelloServiceImpl implements HelloService {
    Map<String, Person> map = new HashMap<>(Map.of(
            "12345", new Person("Жан", "Ренно", "12345", 2),
            "54321", new Person("Антон", "Антонов", "54321", 3),
            "1488", new Person("Антони", "Антонович", "54ды321", 3)));

    String[] proffesions = {
            "безработный",
            "водитель",
            "плотник"
    };

    Map<String, Integer> professionCodes = Map.of(
            "безработный", 0,
            "водитель", 1,
            "плотник", 2
    );

    @Override
    public String sayHello() {
        return "";
    }

    @Override
    public String answerHello(String name, int userName) throws BadPersonNumberException {
        return "";
    }

    @Override
    public String getPersonByNumber(int number) {
        return "";
    }

    @Override
    public List<Person> getPersonList(Integer number) {
//        List<Person> personList = new ArrayList<>();
        return (map.values().stream().filter(p -> p.professionNumber.contains(number))
                .collect(Collectors.toList()))     ;

    }


}
