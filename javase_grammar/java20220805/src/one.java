import java.util.Scanner;

public class one {
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int count=0;
        for (int i = 1; i <=32; i++) {
            if((num&1)==1){
              count++;
            }
            num=num>>i;
        }
        System.out.println(count);
    }
        public static void main2(String[] args) {
            int i;
            int j = 1;
            double sum = 0;
            for(i=1;i<101;i++){
                sum += 1.0/i * j;
                j = -j;
            }
            System.out.println(sum);
        }
    public static void main3(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int h = i / 100;
            int t = i % 100 / 10;
            int s = i % 10 ;
            if (h*h*h+t*t*t+s*s*s==i){
                System.out.println(i+"是水仙花数");
            }
        }
    }

    public static void main6(String[] args) {
        for(int i=1;i<=9;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(i+"*"+j+"="+ i*j +"\t");
            System.out.println();
        }
    }

    public static void main7(String[] args) {
          Scanner scanner=new Scanner(System.in);
          int n=scanner.nextInt();
        while(n>0){
            System.out.println(n%10);
            n/=10;
        }
    }

    public static void main8(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count=3;
        while(count>=0) {
            System.out.println("请输入密码有" + count+"次机会");
            String pass=scanner.nextLine();
            if(pass.equals("123")){
                System.out.println("登录成功!");
                break;
            }
            else {
                System.out.println("登录失败!");
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int count=0;
        int temp=num;
        for (int i = 31; i>=1; i--) {

                System.out.print(temp&1);
            temp=temp>>i;
        }
        System.out.println();
        System.out.println("奇数");
        for (int i = 30; i >=0; i--) {
                System.out.print(num&1);
                num=num>>i;
        }
    }
}

