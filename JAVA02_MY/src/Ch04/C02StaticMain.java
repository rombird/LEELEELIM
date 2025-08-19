package Ch04;

//static 사용시 주의할 점

class C02Simple
{
	static int n1; //객체가 없어도 호출 가능!(이미 공간이 형성되어있는 상태)
				   //클래스가 로딩될 때 메모리에 올라감(객체 없이도 존재)
	int n2; //n2는 객체가 필수적으로 있어야만 존재하는 변수
			//객체가 생성될 때 메모리에 만들어짐(객체가 있어야 존재)
	
	void func1() { 
		n1 = 100;
		n2 = 200;
	}
	
	static void func2() { //func2이 먼저 만들어짐
		n1 = 300;
//		n2 = 400; //문제 발생! 왜?? n2는 객체를 생성한 후 나오는 개별공간, 즉 아직 생성여부를 알지 못하는데 값을 삽입
								//하려고 하니 문제 발생
					//static 함수에서 사용되는 변수는 static 변수 or 지역변수만 가능(일반 멤버변수는 사용x)
	}
}

public class C02StaticMain {

	public static void main(String[] args) {

	}

}
