package com.algorithm;

public class Main {

    public static void main(String[] args) {
        ThreadSafeQueueTest();
    }


    public static void ThreadSafeQueueTest(){
        int size = 5;
        ThreadSafeQueue testQueue = new ThreadSafeQueue(size);

        testQueue.enQueue('a');
        testQueue.enQueue('b');
        testQueue.enQueue('c');
        testQueue.enQueue('d');
        testQueue.enQueue('e');

        Thread t1 = new Thread(()->{
            while(!testQueue.isEmpty()){
                System.out.println("Thread : " + Thread.currentThread().getName() + " / dequeue : " + testQueue.deQueue());
            }
        });
        Thread t2 = new Thread(()->{
            while(!testQueue.isEmpty()){
                System.out.println("Thread : " + Thread.currentThread().getName() + " / dequeue : " + testQueue.deQueue());
            }
        });
        t1.setName("T-1");
        t2.setName("T-2");

        t1.start();
        t2.start();

        /*
        for(int i =0; i<size; i++){
            System.out.println(testQueue.deQueue());
        }
        System.out.println(testQueue.deQueue());

         */
    }

}
