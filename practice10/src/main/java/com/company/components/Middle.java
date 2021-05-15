package com.company.components;

import com.company.interfaces.Programmer;
import org.springframework.stereotype.Component;



@Component
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is coding");
    }
}
