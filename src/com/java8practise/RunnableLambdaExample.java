package com.java8practise;


public class RunnableLambdaExample {

    public static void main(String[] args) {

        /*
          prior Java 8
         */
        //TODO_U

        //Implementation Style 1 - Prior Java8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };

        new Thread(runnable).start();

        // java 8 lambda
        // ()->{};
        //Implementation Style 2 - Using Lambda function defined outside
        Runnable runnableLambda = () -> {
            System.out.println("Inside Runnable 2");
        };
        Runnable runnableLambda1 = () -> {
            System.out.println("Inside Runnable 3");
            System.out.println("Inside Runnable 3");
        };
        new Thread(runnableLambda).start();
        new Thread(runnableLambda1).start();


        //Implementation style 3 : Using lambda but defined implicitly and used
        new Thread(() -> System.out.println("Inside Runnable 4")).start();


    }
}
