package Ch01;

//C02PersonMain안에 다른 Class 둘 수 있음
class C02Person {
	//속성
	public String name;
	public int age;
	public float height;
	public double weight;
	
	//기능
	
}


public class C02PersonMain { //파일과 동일한 클래스 필수!

	public static void main(String[] args) {
		C02Person hong = new C02Person();	
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);

	}

}
