package Ch01;
//★★★★★★생성자 메서드★★★★★★
//ex) Scanner sc = new Scanner(System.in);
				  //new Scanner(System.in);이 생성자 메서드
//생성자 메서드 Scanner();

//객체 생성 시 한번만(최초 1회) 호출되는 메서드 (만들어진 후에는 관여 불가능)
//생성된 객체 내에서는 사용이 불가능
//객체 생성 시에 필요한 메모리 공간 형성과 "초기값 부여"에 사용
//생성자 메서드의 이름은 클래스이름과 동일하게 부여
//생성자 메서드는 반환자료형을 가지지 않음

//생성자 함수를 클래스 내에서 명시하지 않으면(코드 삽입X)
//컴파일러에 의해 기본 생성자 함수가 주입됨(디폴트 생성자)


class C08Simple{
	
	//속성
	int n1;
	double n2;
	boolean n3;
	String n4;
	
	//기능
	
	//생성자 메서드 생성 시 클래스명과 동일해야하고 반환자료형은 필요없음!
	//생성자 메서드 : 클래스명(){}
	//생성자 호출 후 초기값 부여! - 초기값을 주지 않으면 기본값으로 False(숫자0)를 줌
	
	//디폴트 생성자 메서드 - 오버로딩 가능!
	C08Simple(){
		System.out.println("C08Simple() 생성자 호출");
		this.n1=10;	//멤버 변수 불러오는 this.함수 사용
		this.n2=10.10;
		this.n3=true;
		this.n4="TEST";
	}
	
	//생성자 메서드 오버로딩
				//: 함수의 이름과 반환자료형은 고정, 파라미터를 다양하게 가능~
	C08Simple(int n1){
		System.out.println("C08Simple(int n1) 생성자 호출");
		this.n1 = n1;
	}
	C08Simple(int n1, double n2){
		System.out.println("C08Simple(int n1, double n2) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
	}
	C08Simple(int n1, double n2,boolean n3){
		System.out.println("C08Simple(int n1, double n2,boolean n3) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
//	C08Simple(int n1, double n2,boolean n3, String n4){
//		System.out.println("C08Simple(int n1, double n2,boolean n3, String n4) 생성자 호출");
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//	}
	
	
	@Override
	public String toString() {
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}

	public C08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	
	
}

public class C08ConstructorMain {

	public static void main(String[] args) {
		C08Simple ob0 = new C08Simple();
							//생성자 함수 호출(디폴트)
							//생성자 함수가 하나 이상 들어가있으면 디폴트 생성자 함수는 삽입 불필요함
		C08Simple ob1 = new C08Simple(10);
		C08Simple ob2 = new C08Simple(10, 10.10);
		C08Simple ob3 = new C08Simple(10, 20.20,true);
		C08Simple ob4 = new C08Simple(10,20.20,true,"홍길동");
		
//		System.out.println(ob0);
		//결과값 : C08Simple [n1=0, n2=0.0, n3=false, n4=null]
		
	}

}
