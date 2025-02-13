package org.example;

import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int NUM_FILOSOFOS = 5;
        Garfo[] garfos = new Garfo[NUM_FILOSOFOS];
        Semaphore semaphore = new Semaphore(NUM_FILOSOFOS - 1);



        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            garfos[i] = new Garfo();
        }

        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Garfo garfoEsquerdo = garfos[i];
            Garfo garfoDireito = garfos[(i + 1) % NUM_FILOSOFOS];

            filosofos[i] = new Filosofo(i, garfoEsquerdo, garfoDireito, semaphore);
            filosofos[i].start();
        }
    }
}