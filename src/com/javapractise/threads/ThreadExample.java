package com.javapractise.threads;

class RunnableClass implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i < 10; i++)
			System.out.println(i);
		
	}
};
public class ThreadExample {
	
	public static void main(String[] args) {
		
		RunnableClass runnableClass = new RunnableClass();
		new Thread(runnableClass).start();
		
	}
}
