package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	private Semaphore Mutex;
	private int Dist;
	private int N;
	public ThreadPessoa(int N,int Dist,Semaphore Mutex) {
		this.Dist = Dist;
		this.Mutex = Mutex;
		this.N = N;
	}
	public void run () {
		int J=0;
		while (J <200) {
			J =(int)  (J + Math.random()*3)+4;
		}
		try {
			Mutex.acquire();
			System.out.println("A pessoa Nº"+N+" esta cruzando a porta");
			sleep((int) (Math.random()*1001)+1000);
			System.out.println("A pessoa Nº"+N+" cruzou a porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Mutex.release();
		}
	}
}
