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

}
