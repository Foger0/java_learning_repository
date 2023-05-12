public class thread3demo {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        Object o3=new Object();
        Thread t1=new Thread(()->{
            System.out.print('A');
            synchronized (o1){
                o1.notify();
            }

        });
        Thread t2=new Thread(()->{

                synchronized (o1) {
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('B');
                synchronized (o2){
                    o2.notify();
                }

        });
        Thread t3=new Thread(()->{
            synchronized (o2){
                try {
                    o2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println('C');
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
