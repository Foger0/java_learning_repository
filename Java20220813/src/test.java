class animal{
public String name;
public int age;
public animal(String name,int age){
    this.name=name;
    this.age=age;
}
}
class dog extends animal{
    boolean silly;
    public dog(){
        super("mm",10);
        this.silly=true;
    }
    public String toString(){
        return name+","+age;
    }
}
public class test {
    public static void main(String[] args) {
dog w=new dog();
        System.out.println(w);

    }
}
