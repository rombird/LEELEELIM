package Ch03;



class C04Person{
	String name;
	int age;
	//디폴트 생성자
	C04Person(){}
	//모든 인자 생성자
	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//toSTring 재정의
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
	

	
}
public class C04ClassArrayMain {// 배열 중에서는 제일 중요

	public static void main(String[] args) {
		C04Person list[] = new C04Person[3]; //클래스형 배열을 생성할 때(원시타입X) 많이 하는 실수
								//C04Person 객체의 위치값을 넣는 용도로 사용됨 : 클래스형 배열
								// = 3칸짜리의 참조변수를 받는 배열이 만들어짐
								//클래스형 배열의 요소는 각 객체를 연결해주는 참조변수
		
		list[0] = new C04Person(); // 객체를 하나 만들어서 0번 요소와 연결시켜주면 오류 해결!
		list[0].name = "홍길동"; // 오류 발생
							   // 연결된 객체가 없는 상태 == 0번이 가리키는 객체가 없는 상태임
		list[0].age = 55;
		
		System.out.println(list[0]);
	}

}
