public class Example{
    public static void main2(String[] args) {
        String s="hello   world  hello";
        String[] result = s.split(" ");
        System.out.println(s.indexOf("hello"));
        System.out.println(s.indexOf("hello",2));
    }
}