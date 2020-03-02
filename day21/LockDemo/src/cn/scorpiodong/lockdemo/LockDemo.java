package cn.scorpiodong.lockdemo;

class Data {
    private int data = 10;

    public synchronized int getData() {
        return data;
    }

    public synchronized void setData(int data) {
        this.data = data;
    }
}

class MyThread1 implements Runnable {
    private Data data;

    public MyThread1(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            data.setData(data.getData() + 1);
            System.out.println("Thread1 + 1 : " + data.getData());
        }
    }
}

class MyThread2 implements Runnable {
    private Data data;

    public MyThread2(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            data.setData(data.getData() + 2);
            System.out.println("Thread2 + 2 : " + data.getData());
        }
    }
}

class MyThread3 implements Runnable {
    private Data data;

    public MyThread3(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            data.setData(data.getData() - 1);
            System.out.println("Thread3 - 1 : " + data.getData());
        }
    }
}

class MyThread4 implements Runnable {
    private Data data;

    public MyThread4(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            data.setData(data.getData() - 3);
            System.out.println("Thread4 - 3 : " + data.getData());
        }
    }
}

class MyThread5 implements Runnable {
    private Data data;

    public MyThread5(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            data.setData(data.getData() + 3);
            System.out.println("Thread5 + 3 : " + data.getData());
        }
    }
}

/**
 * 用一个锁对象操作五个线程
 *
 * @author ScorpioDong
 */
public class LockDemo {
    public static void main(String[] args) {

        Data data = new Data();

        new Thread(new MyThread1(data)).start();
        new Thread(new MyThread2(data)).start();
        new Thread(new MyThread3(data)).start();
        new Thread(new MyThread4(data)).start();
        new Thread(new MyThread5(data)).start();
    }
}
