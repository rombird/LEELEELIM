package Ch04;


class Company
{
	int n1;
	int n2;
	
	//싱글톤 패턴 코드 : 단일 객체만 생성, 사용 - 특정 함수를 통해 객체의 위치값만 받을 수 있음
	private static Company instance; //만들어진 Company의 객체를 내부적으로 담기 위한 용도
	private Company() {}; //★중요 point★
						  //외부에 객체 생성 불가능, 클래스 내부에서만 객체 생성 가능 (by. private)
	public static Company getInstance() {
		//외부에서 getInstance()를 사용하게 되면 객체를 생성해서 instance ..?
		if(instance==null) {
			instance = new Company(); //instance에서 Company객체를 생성해서 연결함
		}
		return instance;
	}
	
	//toString 재정의
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}
	

	
}
public class C03SingletonPattern { // 암기식으로 알고 있으면 좋음

	public static void main(String[] args) {
		//getInstance()만 접근 가능
		//n1, n2만 접근 가능
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();

		com1.n1 = 100;
		com2.n2 = 200;
		
		System.out.println("com1 : " + com1);
		System.out.println("com2 : " + com2);
	}

}
