package Ch02;

public class C05StringClass {

	public static void main(String[] args) {
		String str1 = "Java Powerful";
		String str2 = new String("java Programming");
		
		//반복적으로 사용하면 런타임 동안 메모리 공간을 계속해서 사용함
		String str3 = str1 + str2;
		String str4 = str1.concat(str2);
					  //str1과 str2를 붙여서 str4에 저장
//		
//		
//		//실제 문자열의 값을 확인하기 위한 용도
//		System.out.printf("%x\n",System.identityHashCode(str1));
//		System.out.printf("%x\n",System.identityHashCode(str2));
//		System.out.printf("%x\n",System.identityHashCode(str3));
//		System.out.printf("%x\n",System.identityHashCode(str4));

		//메모리 공간을 반복적으로 사용하는 걸 확인하기 위한 용도
//		int i=0;
//		String str  = "";
//		while(i<10) {
//			str +=i; //형변환 작업이 일어나면서 문자열이 덧붙여짐
//			System.out.print("str : " + str + " ");
//			System.out.printf("위치 : %x\n",System.identityHashCode(str)); //문자열이 덧붙여질 때마다 위치값 변화
//																		  //메모리 공간을 계쏙적으로 추가해서 사용
//			i++;
			
			
			
			
			
	
			
			//문자열을 덧붙이는 작업을 할때는 StringBuffer,StringBuilder를 사용하자~
			
			//문자열 덧붙이기(메모리 누수 방지 클래스 : StringBuffer , StringBuilder)
			//사이즈만 확장시켜 나가면서 시작위치로부터 계속적으로 동적확장을 해주는 클래스
			//다른 메모리를 침범하게 될 경우에 새로 만듦!
//			int i=0;
////			String str  = "";
//			StringBuilder str = new StringBuilder("");
//			while(i<10) {
////				str +=i;
//				str.append(i);
//				System.out.print("str : " + str + " ");
//				System.out.printf("위치 : %x\n",System.identityHashCode(str));
//				i++;
//			}
		
		
		
		
		
		System.out.println("문자열 길이 : " + str1.length()); //공백포함
		System.out.println("한문자 찾기 : " + str1.charAt(2)); //인덱스2번 위치의 문자 반환
		
		System.out.println("인덱스 찾기 : " + str1.indexOf('a')); //문자에 해당되는 인덱스 번호
		System.out.println("인덱스 찾기 : " + str1.lastIndexOf('a')); //문자 'a'가 
																   //마지막으로 등장하는 위치(인덱스)를 찾아 출력하는 코드
		
		System.out.println("문자열포함 여부 : " + str1.contains("va"));
		System.out.println("문자열포함 여부 : " + str1.contains("abs"));
		
		System.out.println("문자열 자르기 : " + (str1.substring(2,6)));
		
	
		//구분기호를 기준으로 잘라내기 -> 배열형태로 잘림 그렇기에 배열로 바꿔줘야함
		String str6 = "등산,탁구,축구,골프,독서,영화감상";
		String [] result = str6.split(",");
		//String [] result : String 요소를 가지는 []배열을 가리키는 result
		//[등산,탁구,축구,골프,독서,영화감상]
		
		for(String hobby : result)
			System.out.println(hobby);
		
		
		
		
		
		}
	}


