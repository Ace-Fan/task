package com.wufan.task;

//≥Ã–Ú¿‡
public class Node {
	private String name;
	private int cpu1;
	private int io;
	private int cpu2;
	private boolean isRun;
	
	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

	public Node(String name, int cpu1, int io, int cpu2) {
		super();
		this.name = name;
		this.cpu1 = cpu1;
		this.io = io;
		this.cpu2 = cpu2;
	}
	
	public Node(String name, int cpu1, int io, int cpu2, boolean isRun) {
		super();
		this.name = name;
		this.cpu1 = cpu1;
		this.io = io;
		this.cpu2 = cpu2;
		this.isRun = isRun;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCpu1() {
		return cpu1;
	}
	public void setCpu1(int cpu1) {
		this.cpu1 = cpu1;
	}
	public int getIo() {
		return io;
	}
	public void setIo(int io) {
		this.io = io;
	}
	public int getCpu2() {
		return cpu2;
	}
	public void setCpu2(int cpu2) {
		this.cpu2 = cpu2;
	}
	
}
