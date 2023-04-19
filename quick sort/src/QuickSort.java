import java.util.PriorityQueue;
import java.lang.Comparable;
import java.util.Comparator;

public class QuickSort  {
    public static void main(String[] args) {
        int[] arr = {35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,-39};
       
quickSort(arr, 0, arr.length - 1);
for (int i : arr) {
System.out.print(i + " ");
}
}

public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        // 找寻基准数据的正确索引
        int index = getIndex(arr, low, high);

        // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
        quickSort(arr, 0, index - 1);
        quickSort(arr, index + 1, high);
    }
}

public static int getIndex(int[] arr, int low, int high) {
    // 三数取中法选取基准数
    int mid = low + (high - low) / 2;
    if (arr[mid] > arr[high]) {
        swap(arr, mid, high);
    }
    if (arr[low] > arr[high]) {
        swap(arr, low, high);
    }
    if (arr[mid] > arr[low]) {
        swap(arr, mid, low);
    }
    int tmp = arr[low];

    // 加入小数组优化
    if (high - low <= 15) {
        InsertionSort.sort(arr, low, high);
        return low;
    }

    // 基准数据
    while (low < high) {
        // 当队尾的元素大于等于基准数据时,向前挪动high指针
        while (low < high && arr[high] >= tmp) {
            high--;
        }
        // 如果队尾元素小于tmp了,需要将其赋值给low
        arr[low] = arr[high];
        // 当队首元素小于等于tmp时,向前挪动low指针
        while (low < high && arr[low] <= tmp) {
            low++;
        }
        // 当队首元素大于tmp时,需要将其赋值给high
        arr[high] = arr[low];

    }
    // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
    // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
arr[low] = tmp;
return low; // 返回tmp的正确位置
}
public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
}

// 插入排序
class InsertionSort {
public static void sort(int[] arr, int low, int high) {
for (int i = low + 1; i <= high; i++) {
int e = arr[i];
int j = i;
for (; j > low && arr[j - 1] > e; j--) {
arr[j] = arr[j - 1];
}
arr[j] = e;
}
}
}
