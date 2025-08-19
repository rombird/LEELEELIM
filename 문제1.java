package ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 문제1 {

	private static Scanner sc = new Scanner(System.in);
	private static List<String> wordlist = new ArrayList<String>();
	
	public static void sort(boolean isAsend) {		// case 2
		
		if(isAsend) {
			// 오름차순일때
//			Collections.sort(wordlist); 				// Collections 메서드
			wordlist.sort(Comparator.naturalOrder());
			
			System.out.println("1"); 
		}else {	
			// 내림차순일때
//			Collections.sort(wordlist, Collections.reverseOrder());		// Collections 메서드
			wordlist.sort(Comparator.reverseOrder());
			
			System.out.println("0");
		}
		
		
	}
	public static void add(String word) {		// case 1
		wordlist.add(word);
		
	}
	public static void show() {					// case 3
		for(String el : wordlist) {
			System.out.println(el);
		}
	}
	
	
	public static void main(String[] args) {
		int n = 0;
		while(true) {
			
			System.out.println("------------M E N U------------");
			System.out.println("1 추가");
			System.out.println("2 정렬");
			System.out.println("3 확인");
			System.out.println("4 종료");
			System.out.println("------------M E N U------------");
			System.out.println("번호: ");
			
			n = sc.nextInt();
			
			switch(n) {
			case 1:
				System.out.println("단어 입력: ");
				String word = sc.next();
				add(word);
				break;
			
			case 2:
				System.out.println("오름차순 여부(1: 오름차순, 0: 내림차순): ");
				int no = sc.nextInt();
				if(no == 1) sort(true); else sort(false);
			
				break;
			case 3:
				show();
				break;
			case 4:
				System.out.println("종료합니다");
				System.exit(-1);
				break;
			default:
				System.out.println("다시입력 하세요");
				
			}
		}

		
		
		
		
		
		
		
		
	}

}
