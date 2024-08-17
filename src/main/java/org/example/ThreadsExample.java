package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadsExample {
    private static final int CAPACITY = 5;
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    produce(i);
                }
            } catch (Exception e) {
                System.out.println("Producer exception: " + e.getMessage());
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    consume();
                }
            } catch (Exception e) {
                System.out.println("Consumer exception: " + e.getMessage());
            }
        });

        producer.start();
        consumer.start();
    }

    private static void produce(int i) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == CAPACITY) {
                queue.wait();
            }
            queue.add(i);
            System.out.println("Produced: " + i);
            queue.notifyAll();
        }
    }

    private static void consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            queue.notifyAll();
        }
    }
}
