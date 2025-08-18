package section16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex {
	
	private static Scanner sc = new Scanner(System.in);
	
	//list 선언
	private static List<String> wordList = new ArrayList<String>();
	
	
	public static void sort(boolean isAsend) {
		if (isAsend=true)
			Collections.sort(wordList); // 오름차순 정렬
		else
			Collections.sort(wordList, Collections.reverseOrder()); // 내림차순 정렬
	}
	public static void add(String word) {
		wordList.add(word);
		
	}
	public static void show() {
		for(String i : wordList)
			System.out.println(i);
	}


	public static void main(String[] args) {
		int n = 0;
		while(true) {
			System.out.println("-----------M E N U------------");
			System.out.println("1 추가");
			System.out.println("2 정렬");
			System.out.println("3 확인");
			System.out.println("4 종료");
			System.out.println("-----------M E N U------------");
			System.out.print("번호 : ");
			n = sc.nextInt();
			switch(n) {
			case 1:
				System.out.print("단어 입력 : ");
				String word = sc.next();
				add(word); // add 함수 호출
				break;
			case 2:
				System.out.print("오름차순 여부(1:오름차순, 0:내림차순) : ");
				int no = sc.nextInt();
				if(no==1)sort(true); else sort(false); // sort 함수 호출
				break;
			case 3:
				show(); // show 함수 호출
				break;
			case 4: 
				System.out.println("종료합니다");
				System.exit(-1);
				break;
			default:
				System.out.println("다시입력하세요");
			}
		}

	}

}
