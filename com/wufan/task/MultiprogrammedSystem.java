package com.wufan.task;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiprogrammedSystem {
	public static void main(String[] args) {

		//总时间
		int time = 0;
		//CPU中的程序
		Node CPUNode = null;
		//IO中的程序
		Node IONode = null;
		//开始队列
		ArrayList<Node> start = new ArrayList<>();
		//等待io队列
		ArrayList<Node> list_io = new ArrayList<>();
		//等待cpu队列
		ArrayList<Node> list_cpu = new ArrayList<>();
		//顺序
		boolean isFirst = true;

		//接受输入参数
		Scanner sc = new Scanner(System.in);
		System.out.println("请依次输入三个程序操作时间，回车提交，例如A程序:计算20,I/O操作30,计算10");
		System.out.println("A程序：");
		int cpuA = sc.nextInt();
		int ioA = sc.nextInt();
		int cpuA2 = sc.nextInt();
		System.out.println("B程序：");
		int cpuB = sc.nextInt();
		int ioB = sc.nextInt();
		int cpuB2 = sc.nextInt();
		System.out.println("C程序：");
		int cpuC = sc.nextInt();
		int ioC = sc.nextInt();
		int cpuC2 = sc.nextInt();
		sc.close();
		
		//初始化程序A B C
		int count = cpuA+ioA+cpuA2+cpuB+ioB+cpuB2+cpuC+ioC+cpuC2;
		Node A = new Node("A", cpuA, ioA, cpuA2,false);
		Node B = new Node("B", cpuB, ioB, cpuB2,false);
		Node C = new Node("C", cpuC, ioC, cpuC2,false);
		
		//将程序存入开始队列
		start.add(A);
		start.add(B);
		start.add(C);
		
		//判断是否全部运行完毕
		while (start.size()!=0||list_io.size()!=0||list_cpu.size()!=0) {
			//判断当前CPU是否有程序在运行
			//没有程序在运行
			if (CPUNode==null) {
				//使程序进入cpu
				if (list_cpu.size()!=0) {
					CPUNode = list_cpu.get(0);
					isFirst = false;
				}
				else if (start.size()!=0) {
					CPUNode = start.get(0);
					isFirst = true;
				}
			}
			if(CPUNode!=null){//有程序运行
				//判断是哪一次计算
				//计算1
				if (isFirst) {
						//执行计算1
						CPUNode.setCpu1(CPUNode.getCpu1()-10);
						System.out.println(CPUNode.getName()+"在CPU运行");
						//判断是否运行完毕
						//该程序计算1完毕
						if (CPUNode.getCpu1()==0) {
							System.out.println(CPUNode.getName()+"在CPU运行结束");
							start.remove(CPUNode);
							CPUNode.setRun(true);
							list_io.add(CPUNode);
							CPUNode = null;
						}
				}
				//计算2
				else{//继续运行
						//执行计算2
						CPUNode.setCpu2(CPUNode.getCpu2()-10);
						System.out.println(CPUNode.getName()+"在CPU运行");
						//判断是否运行完毕
						//该程序计算2完毕
						if (CPUNode.getCpu2()==0) {
							System.out.println(CPUNode.getName()+"运行全部结束");
							list_cpu.remove(CPUNode);
							CPUNode = null;
						}
				}
			}
			
			//有程序在等待IO
			if (list_io.size()!=0) {
				//判断当前IO是否有程序在运行
				//没有程序在运行
				if (IONode==null) {
					IONode = list_io.get(0);
				}
				if (IONode.isRun()&&IONode.getName().equals("A")) {
					IONode.setRun(false);
				}else{
					if (IONode!=null){//有程序运行
						//IO
						IONode.setIo(IONode.getIo()-10);
						System.out.println(IONode.getName()+"在IO运行");
						//该程序IO完毕
						if (IONode.getIo()==0) {
							System.out.println(IONode.getName()+"在IO运行结束");
							list_io.remove(IONode);
							list_cpu.add(IONode);
							IONode = null;
							
						}
					}
				}
				
			}
			time+=10;
			System.out.println(time);
		}
		System.out.println("单道总时间为："+count);
		System.out.println("多道总时间为："+time);
	}

	
}
