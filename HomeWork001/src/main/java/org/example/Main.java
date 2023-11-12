package org.example;

import Calculator.Calculator;

public class Main {

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculatingDiscount(2000, 50));
    }

}