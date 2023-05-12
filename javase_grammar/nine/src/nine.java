import java.util.Scanner;

public class nine {
    public static void main(String[] args) {
        for (int i = 1; i <=100; i++) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int num) {
        int prime=2;
        boolean flag=false;
        while(prime < num){
            if(num % prime == 0){
               flag=false;
               break;
            }else{
                prime++;
            }
        }
        if(prime>=num){
            flag=true;
        }
               return flag;

}
}
