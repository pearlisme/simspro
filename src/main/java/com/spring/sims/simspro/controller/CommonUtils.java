package com.spring.sims.simspro.controller;

public class CommonUtils {

    public static String getCurrentMethod(){
        return new Object().getClass().getEnclosingMethod().getName();
    }
}
