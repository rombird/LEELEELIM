package Ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class C00Testpract {
	
	private static Scanner sc = new Scanner(System.in); //사용자의 입력을 받음
	private static List<String> wordList = new ArrayList<String>(); //문자열(String)을 담을 리스트 생성
	
	//리스트 정렬 메서드
	public static void sort(boolean isAsend) { //boolean isAsend : 오름차순이냐? 그렇다면 True, 내림차순이라면 False
		if(isAsend) { //오름차순이라면
			wordList.sort(Comparator.naturalOrder()); //오름차순정렬
			System.out.println("오름차순 : " + wordList);
		}
		else { //아니라면(내림차순이라면)
			wordList.sort(Comparator.reverseOrder()); //내림차순 정렬
			System.out.println("내림차순 : " + wordList);
		}
	}
	
	//리스트에 단어 추가하는 메서드
	public static void add(String word) {
		wordList.add(word);
		System.out.println("단어 추가 완료!"); //한번에 공백을 포함한 여러 단어를 추가하려면 어떻게 해야할까?
	}
	
	//리스트 내용 출력 메서드
	public static void show() {
		for(String wd : wordList) { //wordList를 순회하며 하나씩 단어를 출력함
			System.out.println(wd);
		}
	}

	public static void main(String[] args) {
		int n= 0; //초기화
		
		//무한반복(메뉴 계속 보여줌)
		while(true) {
			System.out.println("----------M E N U ----------");
			System.out.println("1 추가");
			System.out.println("2 정렬");
			System.out.println("3 확인");
			System.out.println("4 종료");
			System.out.println("----------M E N U ----------");
			
			System.out.print("번호 : "); // 메뉴번호 입력 받기
			n = sc.nextInt(); // 정수 입력
			
			
			switch(n) {
			case 1 : // 1번 선택시 : 단어 추가
				System.out.println("단어 입력 : ");
				String word = sc.next(); //단어 입력받음
				add(word);	//add 메서드 호출
				break;
				
			case 2 : //2번 선택시 : 리스트 정렬
				System.out.println("오름차순 여부(1:오름차순, 0: 내림차순) : ");
				int no = sc.nextInt();
				if(no==1) sort(true); else sort(false);
				//1(오름차순)				//0(내림차순)
				
				break;
				
			case 3 : // 3번 선택시 : 리스트 내용 출력
				show(); //show 메서드 호출
				break;
				
			case 4 : //4번 선택시 : 종료
				System.out.println("종료합니다.");
				System.exit(-1); // 즉시 강제 종료
				break;
				
			default: // 그 외의 값 입력 시
				System.out.println("다시 입력하세요.");
			}
		}
	}

}
