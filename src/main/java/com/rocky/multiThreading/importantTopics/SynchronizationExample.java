package com.rocky.multiThreading.importantTopics;

class Shared {
    synchronized void printNumbers() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                wait();
            }
        } catch (InterruptedException e) { }
    }

    synchronized void resume() {
        notify();
    }
}