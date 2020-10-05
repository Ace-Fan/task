package com.wufan.task;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiprogrammedSystem {
	public static void main(String[] args) {

		//��ʱ��
		int time = 0;
		//CPU�еĳ���
		Node CPUNode = null;
		//IO�еĳ���
		Node IONode = null;
		//��ʼ����
		ArrayList<Node> start = new ArrayList<>();
		//�ȴ�io����
		ArrayList<Node> list_io = new ArrayList<>();
		//�ȴ�cpu����
		ArrayList<Node> list_cpu = new ArrayList<>();
		//˳��
		boolean isFirst = true;

		//�����������
		Scanner sc = new Scanner(System.in);
		System.out.println("���������������������ʱ�䣬�س��ύ������A����:����20,I/O����30,����10");
		System.out.println("A����");
		int cpuA = sc.nextInt();
		int ioA = sc.nextInt();
		int cpuA2 = sc.nextInt();
		System.out.println("B����");
		int cpuB = sc.nextInt();
		int ioB = sc.nextInt();
		int cpuB2 = sc.nextInt();
		System.out.println("C����");
		int cpuC = sc.nextInt();
		int ioC = sc.nextInt();
		int cpuC2 = sc.nextInt();
		sc.close();
		
		//��ʼ������A B C
		int count = cpuA+ioA+cpuA2+cpuB+ioB+cpuB2+cpuC+ioC+cpuC2;
		Node A = new Node("A", cpuA, ioA, cpuA2,false);
		Node B = new Node("B", cpuB, ioB, cpuB2,false);
		Node C = new Node("C", cpuC, ioC, cpuC2,false);
		
		//��������뿪ʼ����
		start.add(A);
		start.add(B);
		start.add(C);
		
		//�ж��Ƿ�ȫ���������
		while (start.size()!=0||list_io.size()!=0||list_cpu.size()!=0) {
			//�жϵ�ǰCPU�Ƿ��г���������
			//û�г���������
			if (CPUNode==null) {
				//ʹ�������cpu
				if (list_cpu.size()!=0) {
					CPUNode = list_cpu.get(0);
					isFirst = false;
				}
				else if (start.size()!=0) {
					CPUNode = start.get(0);
					isFirst = true;
				}
			}
			if(CPUNode!=null){//�г�������
				//�ж�����һ�μ���
				//����1
				if (isFirst) {
						//ִ�м���1
						CPUNode.setCpu1(CPUNode.getCpu1()-10);
						System.out.println(CPUNode.getName()+"��CPU����");
						//�ж��Ƿ��������
						//�ó������1���
						if (CPUNode.getCpu1()==0) {
							System.out.println(CPUNode.getName()+"��CPU���н���");
							start.remove(CPUNode);
							CPUNode.setRun(true);
							list_io.add(CPUNode);
							CPUNode = null;
						}
				}
				//����2
				else{//��������
						//ִ�м���2
						CPUNode.setCpu2(CPUNode.getCpu2()-10);
						System.out.println(CPUNode.getName()+"��CPU����");
						//�ж��Ƿ��������
						//�ó������2���
						if (CPUNode.getCpu2()==0) {
							System.out.println(CPUNode.getName()+"����ȫ������");
							list_cpu.remove(CPUNode);
							CPUNode = null;
						}
				}
			}
			
			//�г����ڵȴ�IO
			if (list_io.size()!=0) {
				//�жϵ�ǰIO�Ƿ��г���������
				//û�г���������
				if (IONode==null) {
					IONode = list_io.get(0);
				}
				if (IONode.isRun()&&IONode.getName().equals("A")) {
					IONode.setRun(false);
				}else{
					if (IONode!=null){//�г�������
						//IO
						IONode.setIo(IONode.getIo()-10);
						System.out.println(IONode.getName()+"��IO����");
						//�ó���IO���
						if (IONode.getIo()==0) {
							System.out.println(IONode.getName()+"��IO���н���");
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
		System.out.println("������ʱ��Ϊ��"+count);
		System.out.println("�����ʱ��Ϊ��"+time);
	}

	
}
