package View;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Main {
	public static void main (String args[]){
		Semaphore Mutex = new Semaphore(1);
		int Dist = 200;
		for (int J = 0;J<4;J++) {
			ThreadPessoa P = new ThreadPessoa(J,Dist, Mutex);
			P.run();
		}
	}
}
