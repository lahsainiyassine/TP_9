package com.example.tp;

public class MainCalc {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            System.out.println("10 / 2 = " + calc.div(10, 2));
            System.out.println("10 / 0 = " + calc.div(10, 0));
        } catch (ArithmeticException ex) {
            System.err.println("Erreur de calcul : " + ex.getMessage());
        } finally {
            System.out.println("Fin du calcul.");
        }
    }
}