package com.algorithm;

public class ThreadSafeStack {
    private char[] stackArr;
    private int top;
    private int size;

    ThreadSafeStack(int size){
        this.stackArr = new char[size];
        this.top = -1;
        this.size = size;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    private boolean isFull(){
        return top == size-1;
    }
    public synchronized void push(char param){
        if(isFull())
           throw new IllegalArgumentException("stack is full");

        stackArr[++top] = param;
    }
    public synchronized char pop(){
        if(isEmpty())
            throw new IllegalArgumentException("stack is empty");

        return stackArr[top--];
    }

    public char peek(){
        if(isEmpty())
            throw new IllegalArgumentException("stack is empty");

        return stackArr[top];
    }

    public static void ThreadSafeStackTest(){

        System.out.println("ThreadSafeStackTest");
        int size = 5;
        ThreadSafeStack testStack = new ThreadSafeStack(size);

        testStack.push('a');
        testStack.push('b');
        testStack.push('c');
        testStack.push('d');
        testStack.push('e');

        Thread t1 = new Thread(()->{
            while(!testStack.isEmpty()){
                System.out.println("Thread : " + Thread.currentThread().getName() + " / pop : " + testStack.pop());
            }
        });


        Thread t2 = new Thread(()->{
            while(!testStack.isEmpty()){
                System.out.println("Thread : " + Thread.currentThread().getName() + " / pop : " + testStack.pop());
            }
        });

        t1.setName("T-1");
        t2.setName("T-2");

        t1.start();
        t2.start();
    }
}
