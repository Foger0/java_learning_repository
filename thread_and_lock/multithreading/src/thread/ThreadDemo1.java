package thread;

class MyThread extends Thread{
    public void run(){
        while (true){
        System.out.println("hello huozi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
}

public class ThreadDemo1 {
    public static void main1(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        t.start();
        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
