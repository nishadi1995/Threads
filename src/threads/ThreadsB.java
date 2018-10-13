package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadsB implements Runnable {

    int myid;
    static int[] numbers;
    public static int sum, low, high = 0;

    ThreadsB(int a) {
        myid = a;
    }

    static void creatArray() {
        numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 1;
        }
    }

    public synchronized void run() {
        int wsize = 1000 / 2;
        low = wsize * myid;
        high = low + wsize;
        for (int j = low; j < high; j++) {
            sum += numbers[j];
        }
    }
}

class TestThread {

    public static void main(String[] args) {
        try {
            ThreadsB a = new ThreadsB(0);
            ThreadsB b = new ThreadsB(1);
            ThreadsB.creatArray();
            
            Thread t1 = new Thread(a, "Thread 1");             //creating Thread 1
            Thread t2 = new Thread(b, "Thread 2");             //creating Thread 2
            t1.start();                                        //Starting Thread 1
            t1.join();                                         //asking main thread to wait until Thread 1 finishes it's work
            t2.start();                                        //starting Thread 2(Runnable state)
            t2.join();                                         //asking main thread to wait until Thread 2 finishes it's work
            System.out.println("sum " + a.sum);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
