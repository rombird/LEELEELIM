package Ch01;

class C07Simple{
	//원래는 생성자 함수 C07Simple() {}가 있어야 C07Simple(); 사용이 가능함
	//but 삽입하지 않아도 자동으로 생성자 함수가 삽입됨(디폴트 생성자)
	
	int sum(int ...arg) { //함수의 매개변수 개수는 무제한
				//...arg : 가변인자 ->Java에서는 [ ]배열형태로 받음
				//Java에서는 배열함수(Map,ForEach)사용X
		
		System.out.println(arg);

		int s=0;
		
		for(int item : arg) {
			System.out.println(item);
			s+=item;
		}
		return s; //반환값은 1개여야 함
	}
}

public class C07가변인자 {

	public static void main(String[] args) {
		C07Simple obj = new C07Simple();
		obj.sum(10,20,30,40,50); //인자를 몇 개를 써도 문제가 없음!
	}

}
