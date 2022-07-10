package com.example.demospringboot.web;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.model.Greeting;

@RestController
public class GreetingController {
    private static final String template = "Olá, %s,%s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public List<Greeting> greeting(
    		@RequestParam(value="name", defaultValue="World") String name
    		) {
    	List<Greeting> listGreeting = new ArrayList<>();
    	listGreeting.add(new Greeting(counter.incrementAndGet(),
                            String.format(template, name, name))  );
    	listGreeting.add(new Greeting(counter.incrementAndGet(),
                String.format(template, name, name))  );
    	return listGreeting;
    }
}
