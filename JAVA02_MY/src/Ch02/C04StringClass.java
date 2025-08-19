package Ch02;

public class C04StringClass {

	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		//실제 위치 정보 확인
		System.out.printf("%X\n",System.identityHashCode(str1));
		System.out.printf("%X\n",System.identityHashCode(str2));
		System.out.printf("%X\n",System.identityHashCode(str3));
		System.out.printf("%X\n",System.identityHashCode(str4));
		
		
		System.out.println("---------------------");
		System.out.println("str1==str2 ? " + (str1==str2));
		System.out.println("str3==str4 ? " + (str3==str4));
		System.out.println("str1==str3 ? " + (str1==str3));
		System.out.println("str2==str4 ? " + (str2==str4));
		System.out.println("---------------------");
		
		//Heap과 Stack 개념정리 ㅠ,ㅠ,ㅠ,ㅠ
		
		//equals : String 클래스에서 제공하는 기본 함수
		//			위치값이 아닌 위치열에 있는 문자열의 일치 여부를 비교함 즉, "java"를 비교
		
		System.out.println("str1==str2 ? " + (str1.equals(str2)));
		System.out.println("str3==str4 ? " + (str3.equals(str4)));
		System.out.println("str1==str3 ? " + (str1.equals(str3)));
		System.out.println("str2==str4 ? " + (str2.equals(str4)));

	}

}
