 import java.util.PriorityQueue;

public class myPriorityQueue {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_SIZE = 10;
 
    public myPriorityQueue() {
        elem=new int[DEFAULT_SIZE];
    }
    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
            shiftDown(parent,usedSize);
        }
    }
 
    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        int parent=root;
        int child=2*parent+1;
        while (child<len){
        if(child+1<len&&elem[child]<elem[child+1]){
            child=child+1;
        }
        if(elem[parent]>=elem[child]){
            break;
        }else{
            int tmp=elem[parent];
            elem[parent]=elem[child];
            elem[child]=tmp;
            parent=child;
            child=parent*2+1;
        }
        }
    }
 
 
    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        elem[usedSize++]=val;
        shiftUp(usedSize-1);
    }
 
    private void shiftUp(int child) {
        int parent=(child-1)/2;
        while(child>0){
            if(elem[parent]<elem[child]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
 
    public boolean isFull() {
        if(usedSize==DEFAULT_SIZE){
            return true;
        }
        return false;
    }
 
    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        elem[0]=elem[--usedSize];
        shiftDown(0,usedSize);
    }
 
    public boolean isEmpty() {
        if (usedSize==0){
            return true;
        }else{
            return false;
        }
    }
 
    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        return elem[0];
    }
}