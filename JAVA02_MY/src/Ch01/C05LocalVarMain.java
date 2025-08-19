package Ch01;

// 변수 종류

//멤버 변수 		: 클래스 내부 - 메서드 영역 외부 사이, 객체 개별데이터 저장용도
//지역 변수		: 메서드 영역 내부에서 생성되는 변수
//					(or 매서드 영역 내부에서 {}가 명시되어 있을 때 해당{}내에서 생성되는 변수도 포함)
//					ex>파라미터 변수, 일반변수 ...
//static 변수		: 동일 클래스로부터 생성된 여러 객체 간 공유하는 멤버변수
//多사용됨(데이터를 가져오는 과정에서 java클래스로 변환시켜야하는 경우에 자주 사용됨)


class C05Simple
{
	//속성 : class내의 변수 - 메서드 영역 외부 사이의 변수를 멤버 변수라고 함!
						//동일 클래스 내의 모든 곳에 접근 가능
	int num = 10;
	
	
	
	
	//기능(메서드)
	
	//아래의 메서드는 class내부에서 전역변수이기도 함
	void Func1() {
		System.out.println("num: " + num); //멤버 변수 num 출력
		int num=20; //Func1의 지역변수
		num++; // 이름이 중첩되었을 때는 좁은 범위를 따름
		this.num++; //멤버 변수의 num에 접근하는 방법 = this.붙이기
		System.out.println("num: " + num); //Func1의 지역변수 num출력
	
	}
	
	
			//(함수안에 들어간 변수를 지역변수라고 함)	
	void Func2() {
		System.out.println("num: " + num);
		if(num>0) //멤버변수 num
		{
			int num=100; //if문 내의 지역변수 num
			System.out.println("num: " + num);
		} //{}내에서 선언된 변수는 {}를 벗어나면 자연스럽게 메모리 공간을 반환함
		
		System.out.println("num: " + num); //멤버 변수 num
		while(num<15) {
			int num=100;
			System.out.println("num: " + num);
			num++;
		}
		
	}
	//
	
	
	void Func3(int num) {
		this.num = num; //★★멤버 변수에 넣으려면 this를 사용해야 함! 아니면 자신이 지닌 num파라미터에 값을 삽입함
	}
			  
}


public class C05LocalVarMain {

	public static void main(String[] args) {
		C05Simple obj = new C05Simple();
		obj.Func1();
		System.out.println("------------------------");
//		obj.Func2();
	}

}
