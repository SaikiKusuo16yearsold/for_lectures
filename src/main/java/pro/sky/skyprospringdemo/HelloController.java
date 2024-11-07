package pro.sky.skyprospringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping
    public String sayHello() {
        return helloService.sayHello();
    }

    @GetMapping(path = "/plus/add")
    public String answer(@RequestParam("name") String userName, @RequestParam("name") int number) {
        final String answer;
        try {
            answer = helloService.answerHello(userName, number);
        } catch (BadPersonNumberException e) {
            throw new RuntimeException(e);
        }

        return answer;


    }

    @GetMapping(path = "person")
    public String answer(@RequestParam("age") int userName) {
        return helloService.getPersonByNumber(userName);
    }

    @GetMapping(path = "/persons/by-proffesion")
    public String getByProffesion(@RequestParam("proffesion") int proffesion) {
        List<Person> persons = helloService.getPersonList(proffesion);
        final List<String> passports = new ArrayList<>();
        for (final Person person : persons) {
            passports.add(person.passport);
        }
        final String collect = persons.stream()
                .map(person -> person.passport)
                .filter(passp -> passp.startsWith("5"))
                .map(passport -> "?" + passport)
                .findAny()
                .orElseThrow(RuntimeException::new);


        return collect;
    }

}
