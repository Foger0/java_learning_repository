public class Main {
    public static void main(String[] args) {
        myPriorityQueue p=new myPriorityQueue();
        int[] a=new int[]{0,1,2,34,5};
        p.createHeap(a);
        p.push(36);
        p.pollHeap();
        p.peekHeap();
    }
}
