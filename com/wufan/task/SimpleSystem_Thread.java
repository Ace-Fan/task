package com.wufan.task;

public class SimpleSystem_Thread {
	public class Node extends Thread{
		private String name;
		private int cpu1;
		private int io;
		private int cpu2;
		
		public Node(String name, int cpu1, int io, int cpu2) {
			super();
			this.name = name;
			this.cpu1 = cpu1;
			this.io = io;
			this.cpu2 = cpu2;
		}
		
		public void run(){
			String name = Thread.currentThread().getName();
		    String cpu1 = Thread.currentThread().getName();
		    String io = Thread.currentThread().getName();
		    String cpu2 = Thread.currentThread().getName();
		}
	}

	public static void main(String[] args) {
		int time = 0;
		while (true) {
			System.out.println();
		}
	}
}
