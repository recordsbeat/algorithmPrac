package com.algorithm;


public class ThreadSafeQueue{
    private char [] queueArr;
    private int front;
    private int rear;
    private int size;

    ThreadSafeQueue(int size){
        this.queueArr = new char[size];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    private boolean isFull(){
        if(this.rear == this.size-1)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
            return true;
        }
        return false;
    }
    public char peek(){
        if(isEmpty())
            throw new IllegalArgumentException("queue is empty");
        return queueArr[front];
    }
    public synchronized void enQueue(char param){
        if(isFull())
            return;
        queueArr[++rear] = param;
    }
    public synchronized char deQueue(){
        if(isEmpty())
            throw new IllegalArgumentException("queue is full");


        return queueArr[++front];
    }
    public static void ThreadSafeQueueTest(){

        System.out.println("ThreadSafeQueueTest");
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
