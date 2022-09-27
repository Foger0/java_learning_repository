public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.display();

        myArrayList.display();
        System.out.println("==========================");
        System.out.println(myArrayList.contains(10));
        System.out.println(myArrayList.contains(100));
        System.out.println(myArrayList.indexOf(10));
        System.out.println(myArrayList.indexOf(100));
        System.out.println("==========================");

        myArrayList.set(0, 99);
        myArrayList.display();
        System.out.println("==========================");

        myArrayList.remove(10);
        myArrayList.display();
        System.out.println("==========================");

        myArrayList.clear();
        myArrayList.display();

        myArrayList.add(19999);
        myArrayList.display();
    }
    }
