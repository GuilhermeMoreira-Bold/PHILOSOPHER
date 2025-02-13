package org.example;

import java.util.concurrent.Semaphore;

class Filosofo extends Thread {
    private int id;
    private Garfo garfoEsquerdo, garfoDireito;
    private Semaphore semaphore;

    public Filosofo(int id, Garfo garfoEsquerdo, Garfo garfoDireito, Semaphore semaphore) {
        this.id = id;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
        this.semaphore = semaphore;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();


                semaphore.acquire();


                garfoEsquerdo.pegar();
                garfoDireito.pegar();

                comer();


                garfoEsquerdo.soltar();
                garfoDireito.soltar();

                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
