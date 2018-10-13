package threads;

public class ThreadsB implements Runnable {

    int[] numbers;
    public int sum,low,high=0;

    void creatArray() {
        numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 1;
        }
    }

    public void run() {
        int wsize=1000/2;
        low;
        high= low+wsize;
        for (int j = low; j < high; j++) {
            sum += numbers[j];
        }
        System.out.println(numbers[2]);
    }
}

class TestThread {

    public static void main(String[] args) {
        ThreadsB a = new ThreadsB();
        a.creatArray();
        Thread t1 = new Thread(a, "Thread 1");
        Thread t2 = new Thread(a, "Thread 2");
        t1.start();
        t2.start();
        System.out.println("sum " + a.sum);

    }
}
