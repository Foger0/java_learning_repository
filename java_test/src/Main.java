public class Main {
    public static void main1(String[] args) {
        String s1="127\\0\\0\\1";//1
        String[] s2=s1.split("/");//2
        System.out.println(s1);
        for (String x:s2) {
            System.out.println(x);
        }

    }
}
