import java.util.Arrays;

public class javaHomework {
   public static void transform(int[] arr){
       for (int i = 0; i < arr.length; i++) {
           arr[i]=2*arr[i];
       }
   }
    public static void main1(String[] args) {
int[] array1=new int[]{1,2,3};
transform(array1);
        System.out.println(Arrays.toString(array1));
    }

        public static int[] exchange(int[] nums) {
            int[] count=new int[nums.length];
            int odd=0;int eve=nums.length-1;
            for(int num:nums){
                if(num%2==0) {
                    count[eve]=num;
                    eve--;
                }
                else {
                    count[odd]=num;
                    odd++;
                }
            }
            return count;
        }


    public static double avg(int[] a){
        int ret=0;
        double sum;
        for(int x:a){
            ret+=x;
        }
        sum=ret/a.length;
        return sum;
    }


    public static int singleNumber(int[] nums) {
       int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static int majorNumber(int[] nums){
       int arr[]=new int[10];
        for (int num:
             nums) {
            arr[num]++;
        }
        int i = 0;
        for (i=0; i < arr.length; i++) {
            int max=arr[0];
            if(arr[i]>max){
                max=arr[i];
                return i;
            }
        }
return 0;
    }
    public static void main6(String[] args){
        int[] arr={1,1,1,3,5,5,7};
        System.out.println(threeConsecutiveOdds(arr) );
    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length <= 2){
            return false;
        }
        int i = 0;
        int count = 0;
        while (i < arr.length){
            if((arr[i]&1)==1){
                count++;
                if (count == 3){
                    return true;
                }
            }else {
                count=0;
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args){

        String s;

        System.out.println("s="+s);

    }
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        int middle = (low + high) / 2;
        if(arr[middle] > key){
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            return recursionBinarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }

    }
}
