import java.util.Scanner;

public class javahomework {
    public static int max3(int x, int y) {
        return x >= y ? x : y;
    }

    public static double max3(double x, double y, double z) {
        return (x >= y ? x : y) >= (z >= y ? z : y) ? (x >= y ? x : y) : (z >= y ? z : y);
    }

    public static void main9(String[] args) {
        System.out.println(max3(4.4, 5.5, 6.6));
        System.out.println(max3(20, 3));
    }

    public static int fact(int x) {
        int ret = 1;
        for (int i = 1; i <= x; i++) {
            ret *= i;
        }
        return ret;
    }

    public static void main3(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            sum += fact(i);
        }
        System.out.println(sum);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main2(String[] args) {
        System.out.println(fib(4));
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static float sum(float x, float y, float z) {
        return x + y + z;
    }

    public static void main8(String[] args) {
        System.out.println(sum(1.1f, 2.2f, 3.3f));
        System.out.println(sum(10, 20));
    }

    public static int recursion(int n) {
        if (n < 0) {
            System.out.println("错误");
            return 0;
        }
        if (n == 0 || n == 1)
            return 1;
        else {
            return n * recursion(n - 1);
        }
    }

    public static void main10(String[] args) {
        System.out.println(count(10));
    }

    public static int count(int n) {

        if (n > 1) {

            return count(n - 1) + n;

        } else {

            return n;

        }
    }
    public static int sumNum(int num) {
        if (num > 9) {
            return num%10+sumNum(num/10);
        }
        return num%10;
    }

    public static void main11(String[] args) {
        System.out.println(sumNum(1234));
    }

    public static void main12(String[] args) {
        int[] array1=new int[100];
        for (int i = 1; i <=100; i++) {
            array1[i-1]=i;
        }
        for (int x:
             array1) {
            System.out.println(x);
        }
        }
    public static void hanio(int n,char pos1,
                             char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanio(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanio(n-1,pos2,pos1,pos3);
    }
    public static void move(char pos1,char pos2) {
        System.out.print (pos1+" -> " + pos2+" ");
    }


    public static void main13(String[] args) {
        hanio(3,'A','B','C');

    }
    public static void printArray(int[] arr){
        for (int x:
             arr) {
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
       int[] array1=new int[10];
        printArray(array1);
    }
    }


