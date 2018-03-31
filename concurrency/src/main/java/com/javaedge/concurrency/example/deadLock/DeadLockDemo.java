package com.javaedge.concurrency.example.deadLock;

/**
 * @author apple
 */
public class DeadLockDemo {

    public static final Object O1 = new Object();
    public static final Object O2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (DeadLockDemo.O1) {
                    System.out.println("get o1,want o2!");
                    synchronized ((DeadLockDemo.O2)) {
                        System.out.println("get o2,want o1!");
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (DeadLockDemo.O2) {
                    System.out.println("get o2,want o1!");
                    synchronized ((DeadLockDemo.O1)) {
                        System.out.println("get o1,want o2!");
                    }
                }
            }
        }).start();
    }
}
