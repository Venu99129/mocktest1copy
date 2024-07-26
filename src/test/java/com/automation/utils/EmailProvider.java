package com.automation.utils;

import java.util.Random;

public class EmailProvider {

    public static String getEmail(){
        Random random = new Random();
        int num = random.nextInt(100000)+1;
        return ("rom"+num+"@gmail.com");
    }
}
