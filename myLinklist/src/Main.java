public class Main {
    public static void main(String[] args) {
        MySingleList mySingleList=new MySingleList();
        mySingleList.createList();
        System.out.println(mySingleList.contains(2));
        mySingleList.display();
    }
}
