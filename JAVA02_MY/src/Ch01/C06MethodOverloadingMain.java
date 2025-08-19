package Ch01;

//★★★오버로딩★★★
//: 같은 이름의 메서드를 **매개변수(parameter)**의 개수 또는 타입만 다르게 하여 여러 개 정의
//: 동일한 기능이긴 하지만 파라미터를 여러 개 두는 경우면 함수의 이름을 동일하게 둔다.
//: 함수의 이름은 고정이고 파라미터는 다양하게 둘 수 있도록 허용한 문법
//: 반환 자료형은 고정임 => 다르면 애초에 다른 함수를 생성함
//: 즉, 함수의 이름과 반환 자료형은 동일해야하고 파라미터의 개수는 달라도 됨.

class C06Simple 
{
	// 속성

	// 기능
	public int sum(int n1, int n2) {
		System.out.println("sum1(int n1, int n2)");
		return n1 + n2;
	}
	
	public int sum(int n1, int n2, int n3) {
		System.out.println("(int n1, int n2, int n3)");
		return n1 + n2 + n3;
	}
	
	public int sum(int n1, int n2, int n3, int n4) {
		System.out.println("(int n1, int n2, int n3, int n4)");
		return n1 + n2 + n3 + n4;
	}

}


public class C06MethodOverloadingMain {

	public static void main(String[] args) {
		C06Simple obj = new C06Simple();
		obj.sum(10, 20); //파라미터 2개니까 첫번째 sum 사용
		obj.sum(10, 20, 30); //파라미터 3개니까 두번째 sum 사용
		obj.sum(10, 20, 30 , 40); //파라미터 4개니까 세번쨰 sum 사용
	}

}
