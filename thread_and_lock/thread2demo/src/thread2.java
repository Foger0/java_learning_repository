class Counter{
    public int i=0;
     public void add1(){
         i++;
    }
    synchronized public void add2(){
       synchronized(this) {
            i++;
        }
    }
}
public class thread2 {

    public static void main1(String[] args) throws InterruptedException {
Counter c1=new Counter();
Thread t1=new Thread(()->{
    for (int i = 0; i < 10000; i++) {
        c1.add1();
    }
});
        Thread t2=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                c1.add2();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(c1.i);

    }
}
