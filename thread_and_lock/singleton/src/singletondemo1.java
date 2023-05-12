class Singleton{
    private static Singleton instance=new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    private Singleton() {}
}

public class singletondemo1 {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);
    }
}
