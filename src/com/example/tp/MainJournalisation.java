package com.example.tp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainJournalisation {
    public static void main(String[] args) {

        // 1. Test Calculatrice : division par zéro
        Calculator calc = new Calculator();
        try {
            System.out.println("Résultat : " + calc.div(10, 0));
        } catch (ArithmeticException e) {
            try (FileWriter fw = new FileWriter("error.log", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("[CALCULATRICE] Erreur : " + e.getMessage());
                e.printStackTrace(pw);
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }

        // 2. Test Fichier : fichier introuvable
        try {
            FileUtil.readNumbers("fichier_introuvable.txt");
        } catch (Exception e) {
            try (FileWriter fw = new FileWriter("error.log", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("[FICHIER] Erreur : " + e.getMessage());
                e.printStackTrace(pw);
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }

        // 3. Test Utilisateur : validation invalide
        User utilisateurInvalide = new User("", 15);
        try {
            utilisateurInvalide.validate();
        } catch (InvalidUserException e) {
            try (FileWriter fw = new FileWriter("error.log", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("[VALIDATION] Erreur : " + e.getMessage());
                e.printStackTrace(pw);
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }

        System.out.println("Exécution terminée. Consultez le fichier error.log.");
    }
}