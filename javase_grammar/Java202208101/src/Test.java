public class Test{
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main4(String[] args){
        System.out.println("cnt ="+cnt);
    }
    static{
        cnt /=3;
    };
}
