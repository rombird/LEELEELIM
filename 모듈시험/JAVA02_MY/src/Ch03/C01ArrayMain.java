package Ch03;

import java.util.Arrays;
import java.util.Scanner;

public class C01ArrayMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int [] arr1 = new int[5]; //첨자를 위/ 아래 위치 중 어디 놔도 상관없음 
		int arr1 [] = new int[5];
//		int arr2 [] = {10,20,30} //초기값 지정
		System.out.println("배열 길이 : " + arr1.length);
		System.out.println("5개의 값을 입력하세요");
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
		
		
		
		for(int i=0;i<arr1.length;i++) {
			System.out.println(i+"." + arr1[i]);
		}
		System.out.println("------------------");
		
		
		
		for(int el : arr1) { //위의 개량폼
			System.out.println(el);
		}
		System.out.println("----------------");
		
		
		
		//배열 스트림 순회
//		Arrays.stream(arr1).forEach((el)->{System.out.println(el);});
									//()->{} : Lambda 함수(람다함수 파트가서 다시 자세히 설명!)
//		Arrays.stream(arr1).forEach(el->System.out.println(el));
									//()생략 가능
//		Arrays.stream(arr1).forEach(System.out::println);
						//단일 메서드를 사용할거면 싹 다 생략 가능 but println앞의 .->::로 변경!
		
		
		
		//배열에 입력된 정수 중에 최대값과 최소값을 출력
		int max = arr1[0]; // 처음 값을 max에 삽입하고 다른 요소들과 하나씩 비교해보면 됨
		int min = arr1[0];
		
		for(int el : arr1) {
			if(max<el) {
				max=el;
			if(min>el) {
				min=el;
			}
			System.out.println("MAX: " + max );
			System.out.println("MIN: " + min );
			}
			
			//최대, 최소값을 구해주는 Stream함수
			System.out.println("MAX: " + Arrays.stream(arr1).max().getAsInt());
										//최대값 요소에 대한 			   정수값 하나를 꺼내옴
			System.out.println("MIN: " + Arrays.stream(arr1).min().getAsInt());
										//최소값 요소에 대한 			   정수값 하나를 꺼내옴
		}
	}

}
