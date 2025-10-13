package Ch01;

import java.util.Scanner;

class MethodTest {
	// 속성
	Scanner sc = new Scanner(System.in);
	// 기능
	public int sum1(int n1, int n2) {
		return n1 + n2;
	}
	public int sum2() {
		return sc.nextInt() + sc.nextInt(); //키보드로부터 받을 값을 기다림
		//반환자료형이 있으면 return이 필수로 있어야 함!
	}
	public void sum3(int n1, int n2) {
		System.out.println(n1 + n2);
		//반환자료형 void이기 때문에 return값을 주지 않아도 됨!
		//return은 되지만 return값을 안 주는 것
	}
	public void sum4() {
		System.out.println(sc.nextInt() + sc.nextInt());
	}
}
public class C04MethodMain {

	public static void main(String[] args) {
		MethodTest sumCalc = new MethodTest(); //객체 생성
		System.out.println(sumCalc.sum1(10, 20));
		System.out.println(sumCalc.sum2());
		sumCalc.sum3(10,20);
		sumCalc.sum4();
	}

}

