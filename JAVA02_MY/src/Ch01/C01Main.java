package Ch01;

public class C01Main {

	public static void main(String[] args) {
		C01Person hong = new C01Person();	//초기값이 없으면 String은 null, int는 0, 실수형은 0.0이 초기값으로 설정됨
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
	}

}
