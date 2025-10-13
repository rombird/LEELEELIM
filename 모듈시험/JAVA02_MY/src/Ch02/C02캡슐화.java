package Ch02;

//정보 은닉을 활용하는 것 == 캡슐화
//개념정도만 챙겨둬도 됨!


//캡슐화란
//특정 목적을 가지는 기능을 구현하는데 필요한 세부 기능들을 묶어서 처리하는 방법
//특정 목적을 가지는 기능 구현에 있어서 각 과정의 일부나 전부가 외부로 노출되는 문제 막기 위해
//정보은닉을 수반한다(필수는 아님)
//캡슐화 작업은 각 공정과정에 대한 정확한 이해가 수반되어야 한다
//★작업공정에 대한 일련의 순서가 중요함★



//캡슐화 =/= 정보 은닉
//특정 목적을 위해 묶어놓는 단위긴 하지만 정보은닉 작업을 수반하기도 한다.

class Engine{
	//클래스 내에서만 동작이 가능
	private void 흡입() {System.out.println("외부로부터 공기를 빨아들인다");}
	private void 압축() {System.out.println("가둔 공기를 압축시킨다");}
	private void 폭발() {System.out.println("일정 수준압축되면 폭발!");}
	private void 배기() {System.out.println("가스를 외부로 보낸다");}
	//캡슐화
	public void EngineStart() {
		//특정 순서를 지니게끔 만듦
		흡입();
		압축();
		폭발();
		배기();
	}
}
class Car{
	
	private Engine engine; //정보은닉
	Car(){
		engine = new Engine(); //자동차 생성과 동시에 내부 엔진도 동시에 생성되도록 만듦
	}
	void run() { //run을 실행시키면 Engine도 동작시작쓰
		//
		//
		//
		engine.EngineStart();// 캡슐화된 상태
	}	
}

public class C02캡슐화 {

	public static void main(String[] args) {
		Car car = new Car();
		car.run();
	}

}
