package Ch02;

public class C02ArrayIndexBoundExceptionMain {

	public static void main(String[] args) {
		
		int [] arr = {10,20,30};
		
		try{System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생! " + e);
		}finally { //예외 발생 상관없이 무조건적으로 실행되어야 하는 코드 == 예외가 발생하지 않더라도 실행됨
			System.out.println("예외발생과는 무관하게 무조건 실행되는 코드");
			//자원(JDBC,SOCKE,STREAM,SCANNER..)을 제거하는데 사용됨
			//생성된 객체들을 제거할 때 사용되는 영역
			
		}
	System.out.println("실행되어야 할 코드1");
	System.out.println("실행되어야 할 코드2");

		
	}

}
