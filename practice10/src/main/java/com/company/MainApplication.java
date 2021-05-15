package com.company;

import com.company.components.Junior;
import com.company.components.Middle;
import com.company.components.Senior;
import com.company.interfaces.Programmer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);
        Programmer pr1 = context.getBean(Junior.class);
        Programmer pr2 = context.getBean(Middle.class);
        Programmer pr3 = context.getBean(Senior.class);
        pr1.doCoding();
        pr2.doCoding();
        pr3.doCoding();
    }
}
