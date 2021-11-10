package com.example.demo;

import org.junit.Assert;
import org.junit.Test;

public class TestForTest {

    @Test
    public void doSome() {
        Assert.assertTrue(" 1234 ".matches("[0-9 ]+"));


        Assert.assertFalse(" 1234 ".matches("\\D"));
        Assert.assertFalse(" 1234 ".matches("[0-9]"));
        Assert.assertFalse("".matches("[0-9]"));
    }

    @Test
    public void doSOmeElse() {
        String origin = "aldjfla   asfgasdlk; ''' asf 12341234 lfasdjfaf; 12341234";
        String year = origin.replaceAll("\\D", "");

        System.out.println(year);
    }
}
