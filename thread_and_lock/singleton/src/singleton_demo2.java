class Singleton2{
    private volatile static Singleton2 instance=null;
    private Singleton2(){}
    public static Singleton2 getInstance1(){
       if (instance==null){
           synchronized (Singleton2.class){
        if(instance==null){
            instance=new Singleton2();
        }
           }
       }
        return instance;
    }
}

public class singleton_demo2 {
}
