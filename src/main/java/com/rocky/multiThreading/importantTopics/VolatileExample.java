package com.rocky.multiThreading.importantTopics;

class VolatileExample {
    private volatile boolean flag = false;

    public void writer() {
        flag = true;
    }

    public boolean reader() {
        return flag;
    }
}