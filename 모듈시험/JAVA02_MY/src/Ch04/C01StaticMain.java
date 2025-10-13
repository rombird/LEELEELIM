package Ch04;
//★static내의 예약어를 잘 쓰는 것이 중요함, 정확하게 static에 대해 알고 있어야 함 ★


//★static★  : 공유메모리(클래스==메서드영역)에 변수/메서드 적재
//		    : ★객체 생성과는 무관하게 공간 할당(객체 생성을 하지 않더라도 공간 만들어짐)★
//		    : 클래스명으로 접근 가능
//			: 만들어지는 객체들의 공용공간이 됨
//			: 객체 생성과는 무관하게 처음 컴파일 시 공간이 할당될 때 공간이 할당되기에 객체를 생성하지 않더라도 접근 가능

class C01Simple
{
	static int n1; //simple객체들이 만들어지만 simple객체들간의 공용 공간
	int n2;
	
	//디폴트 생성자
	public C01Simple(){}
	
	//모든 인자 생성자
	public C01Simple(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	
	//toString 재정의
	@Override
	public String toString() {
		return "C01Simple [n1=" + n1 + ", n2=" + n2 + "]";
	};
	
}

public class C01StaticMain {

	public static void main(String[] args) {
		C01Simple.n1=100;
		System.out.println(C01Simple.n1);
		
		C01Simple ob1 = new C01Simple();
		ob1.n1=300;
		C01Simple ob2 = new C01Simple();
		System.out.println("ob1: " + ob1);
		System.out.println("ob2: " + ob2);

	}

}
