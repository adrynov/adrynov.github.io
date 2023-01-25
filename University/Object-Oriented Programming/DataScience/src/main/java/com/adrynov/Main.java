package com.adrynov;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        t.start();

        System.out.println(Thread.currentThread().getName());
    }
}