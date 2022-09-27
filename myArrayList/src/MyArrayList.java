import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList{
    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList(){
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     *   根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
if(isFull()){
    this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
}
this.elem[this.usedSize]=data;
this.usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     * @return true:满   false代表空
     */
    public boolean isFull() {
return size()>=DEFAULT_SIZE;
    }


    private boolean checkPosInAdd(int pos) throws PosWrongfulException,EmptyException{
        if(isEmpty()) {
            throw new EmptyException("当前顺序表为空！");
        }
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法！");
            throw new PosWrongfulException("pos位置不合法");
        }
        return true;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
      try{
          checkPosInAdd(pos);
      }catch (PosWrongfulException e){
          e.printStackTrace();
      }catch (EmptyException e){
          e.printStackTrace();
      }
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        //2.插入数据
        this.elem[pos] = data;
        //3. usedSize++
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        try{
            checkPosInAdd(pos);
        }catch (PosWrongfulException e){
            e.printStackTrace();
        }catch (EmptyException e){
            e.printStackTrace();
        }
        return elem[pos];
    }

    private boolean isEmpty() {
return size()==0;
    }
    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        try{
            checkPosInAdd(pos);
        }catch (PosWrongfulException e){
            e.printStackTrace();
        }catch (EmptyException e){
            e.printStackTrace();
        }
        this.elem[pos]=value;
    }

    /**
     * 删除第一次出现的关键字key
     * @param key
     */
    public void remove(int key) {
       int index=0;
        for (int i = 0; i < size(); i++) {
            if(key==elem[i]){
                index=i;
                break;
            }
        }
        try{
            checkPosInAdd(index);
        }catch (PosWrongfulException e){
            e.printStackTrace();
        }catch (EmptyException e){
            e.printStackTrace();
        }
        for (int i = index; i < size()-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
return usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
}
