package Ch02;


//접근 한정자
//멤버/클래스의 접근 범위를 제한을 위한 예약어
//public		: 모든 클래스에서 접근 가능
//private		: 해당 클래스에서만 접근가능
//protected		: 상속관계를 가지는 (클래스 간에만)경우에 접근 가능
//default(기본)	: 동일 패키지에 속한 클래스에서 접근가능
//멤버에다가 private 지정하는 것을 '정보 은닉'이라고 한다.

class C01Person{
	//속성
	String name;
	private int age; //다른 클래스에서 속성값을 쓸려고 할 때 age값을 보지 못하게 막음
					 //but 내용 확인이나 변경이 어려움 -> setter라고 하는 함수를 이용해서 age의 기존 값을 변경O
	private String addr;

	
	//기능
	
	//setter 함수(기존데이터를 수정)
	public void setAge(int age) {
	//외부노출O   멤버변수명 O(set + 대문자로 시작해야함!)
		this.age= age;
	}
	
	//getter 함수(데이터를 외부로 반환) - 멤버변수명 set+ 대문자 시작
	public int getAge() { 	//파라미터 필요x
		return this.age; 	//속성의 일부를 return으로 반환
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	//디폴트 생성자
	public C01Person() {} //-> 만드는 이유: 프레임워크에서 디폴트 생성자 활용하는 경우 多다
	//모든인자 생성자
	public C01Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	//toString 재정의
	@Override
	public String toString() {
		return "C01Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}



}

public class C01정보은닉 {

	public static void main(String[] args) {
		C01Person person1 = new C01Person("홍길동", 55, "대구");
		person1.setAge(33); //Setter함수를 이용해서 private하게 은닉된 멤버 변수에 접근해서 값 수정함
		
		System.out.println(person1.getAge());
	}

}
