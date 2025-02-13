package org.example;

class Garfo {
    private boolean emUso = false;

    public synchronized void pegar() throws InterruptedException {
        while (emUso) {
            wait();
        }
        emUso = true;
    }

    public synchronized void soltar() {
        emUso = false;
        notify();
    }
}