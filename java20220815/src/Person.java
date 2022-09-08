public class Person {
	public String name;
	int age;

	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
}
class test{

	public String grade;

	public static void main(String[] args){

		Person p1= new Person("zhangsan",10);
		Person p2= new Person("zhangsan",10);
		System.out.println(p1.name.hashCode());
		System.out.println(p2.name.hashCode());
	}

}