package Ch02;

import java.util.Scanner;

public class C03Ex {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try{System.out.print("나눗셈 위한 두 값을 입력하세요: ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println("나눗셈 결과 : " + n1/n2);} // n/0시 예외 발생!}
		
		//예외 발생 후 처리할 코드 블록
		catch(ArithmeticException e) {
			System.out.println("예외발생 : " + e);
		}
		
		//예외발생 여부와 상관없이 실행되어야 하는 코드
		finally {
		System.out.println("실행되어야 할 코드 1");
		System.out.println("실행되어야 할 코드 2");
		System.out.println("프로그램 종료");
		}
	}

}
