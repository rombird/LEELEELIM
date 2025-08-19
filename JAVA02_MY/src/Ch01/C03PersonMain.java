package Ch01;

//C02PersonMain안에 다른 Class 둘 수 있음
class C03Person {
	//속성
	public String name;
	public int age;
	public float height;
	public double weight;
	
	//기능
	void talk() {System.out.printf("%s님이 말합니다.\n", this.name);}
													  //만들어질 객체 자체 = this
	void walk() {System.out.printf("%s님이 걷습니다..\n", this.name);}
	void showInfo() {
		System.out.printf("%s %d %f %f\n", this.name, this.age, this.height,this.weight);
	}
	@Override
	public String toString() {
			//반환자료형 : String
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
		//문자열 범위 내의 속성값들을 함께 실어서 전송해줌
	}
	
	//toString() : 속성을 표시해줌
	
	
}


public class C03PersonMain { //파일과 동일한 클래스 필수!

	public static void main(String[] args) {
		//속성
		C03Person hong = new C03Person();	
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		//기능 : return은 되나 return값은 없는 상태!
		//모든 함수는 return을 함 == 효출했던 위치로 다시 돌아옴
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println(hong.toString());
		System.out.println(hong); //toString()을 쓰지 않고 이름으로만 접근해서 참조변수만 볼 수 잇음
		
//		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);

	}

}
