package com.example.a106332013_hw51;

import java.util.Base64;

import static java.lang.Math.exp;

public class Calculator {
    public enum Operator {ADD, SUB, DIV, MUL,POW}

    /**
     * Addition operation
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Subtract operation
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Divide operation
     */
    public double div(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    /**
     * Multiply operation
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }


    public double pow(double firstOperand, double secondOperand){
        return  Math.pow(firstOperand,secondOperand);
    }
}
