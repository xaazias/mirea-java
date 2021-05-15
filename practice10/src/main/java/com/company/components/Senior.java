package com.company.components;

import com.company.interfaces.Programmer;
import org.springframework.stereotype.Component;


@Component
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding");
    }
}
