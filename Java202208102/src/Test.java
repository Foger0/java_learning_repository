 class Outerclass{
    static int a=10;
    static class Interclass{
        int a=5;
        static final int B=20;
        public void func(){
            System.out.println(Outerclass.this.a);
        }
    }

}


public class Test {
    public static void main(String[] args) {
        Outerclass.Interclass interclass=new Outerclass.Interclass();
        System.out.println(interclass.B);
        interclass.func();
    }
}
