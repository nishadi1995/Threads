package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Threads extends Thread {

    Threads(int a) {
        myid = a;
    }

    static int[] numbers;
    static int sum;
    int myid;
    static int wsize;

    static void createArray() {                 //array creation
        numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 1;
        }
    }

    public synchronized void run() {                       
        int i, low, high = 0;
        low = myid * wsize;
        high = low + wsize;

        for (i = low; i < high; i++) {
            sum += numbers[i];
        }     
        System.out.println("Tread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        try {
            Threads.createArray();                           //creating the array
            wsize = 1000 / 2;
            Threads t1 = new Threads(0);                     //creating Thread 1
            Threads t2 = new Threads(1);                     //creating Thread 2
            t1.start();                                      
            t1.join();
            t2.start();
            t2.join();
            System.out.println("main method " + sum);               //return the final sum

        } catch (InterruptedException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
