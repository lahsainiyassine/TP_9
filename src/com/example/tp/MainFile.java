package com.example.tp;

import java.util.List;

public class MainFile {
    public static void main(String[] args) {
        List<Integer> nums = FileUtil.readNumbers("numbers.txt");
        System.out.println("Nombres lus : " + nums);
    }
}