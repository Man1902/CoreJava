package com.learning.corejava.parent;

import java.util.ArrayDeque;
import java.util.Queue;

class ProducerThread implements Runnable {
    private Queue<Integer> queue;

    public ProducerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    int no = (int) (Math.random() * (100 - 1));
                    queue.add(no);
                    System.out.println("Produced " + no + " number");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notify();
                }
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ConsumerThread implements Runnable {
    private Queue<Integer> queue;

    public ConsumerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    System.out.println("Consumed " + queue.remove() + " number");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notify();
                }
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class InterThreadCommunicationEx {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Thread producer = new Thread(new ProducerThread(queue));
        Thread consumer = new Thread(new ConsumerThread(queue));

        producer.start();
        consumer.start();
    }
}
