package com.example.tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Integer> readNumbers(String path) {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            try (FileWriter fw = new FileWriter("error.log", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("[I/O ERROR] " + e.getMessage());
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        } catch (NumberFormatException e) {
            try (FileWriter fw = new FileWriter("error.log", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("[FORMAT ERROR] Valeur non convertible : " + e.getMessage());
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }

        return list;
    }
}