package Ch01;

import java.util.Scanner;

//class TV{
//	//속성
//	String brandName;
//	int year;
//	int inch;
//
//	
//	//생성자 메서드 
//	TV(String brandName, int year, int inch){
//		this.brandName=brandName;
//		this.year=year;
//		this.inch=inch;
//	}
//	//기능
//	void show() { //->출력만 하고 값을 돌려줄 필요가 없기 때문
//		System.out.println(brandName + "에서 만든 " + year + "년형 " + inch + "인치 TV" );
//	}
//	
//	@Override //하지 않으면 myTV의 해쉬값이 출력됨
//	public String toString() {
//		return "TV [brandName=" + brandName + ", year=" + year + ", inch=" + inch + "]";
//	}
//
//}
//public class C09Ex {
//
//
//	public static void main(String[] args) {
//		TV myTV = new TV("LG", 2017, 32); //생성자 메서드 만들기
//		myTV.show(); //LG에서 만든 2017년형 32인치 TV
//	}
//}

class Grade{
	//속성
	int math;
	int science;
	int english;
	
	//기능
	int average() { //생성자 함수에서 이미 math,science,english값이 초기화 된 상태여서 파라미터를 삽입해서 반복할 필요X!
					//me 객체가 생성될 때 이미 math,science,english값을 자신의 필드에서 기억하고 있는 상태
		return (math + science + english)/3;
	}
	
	//생성자함수
	Grade(int math, int science, int english){
		this.math= math;
		this.science = science;
		this.english = english;
	}


@Override
	public String toString() {
		return "Grade [math=" + math + ", science=" + science + ", english=" + english + "]";
	}


public class C09Ex{
public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
	   int math = sc.nextInt();
	   int science = sc.nextInt();
	   int english = sc.nextInt();
	   Grade me = new Grade(math, science, english);
	   System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
	   
	   sc.close();
	
}
}
}


//
//	--------------------------------------------
//	문제 - 이것이자바다
//	--------------------------------------------
//	https://scksk.tistory.com/6
//
//	클래스 기본문제
//	1~7번 확인하기 
//
//	12번-16번 확인하기

// 13번 문제
//class Member{
//	String name;
//	String id;
//	String password;
//	int age;
//}
// 14번 문제
//Member(String name, String id) {
//	this.name = name;
//	this.id = id;
//}
// 15번 문제 
//class MemberService {
//	boolean login(String id, String password) {
//		if("hong".equals(id) && "12345".equals(password))
//			return true;
//		else
//			return false;
//	}
//	
//	void logout(String id) {
//		System.out.println("로그아웃 되었습니다.");
//	}
//}
//16번 문제
	


//
//	--------------------------------------------
//	--추가(명품자바)
//	--------------------------------------------
//	https://security-nanglam.tistory.com/213



//
//
//	--------------------------------------------
//	--추가
//	--------------------------------------------
//	https://iu-corner.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%AC%B8%EC%A0%9C-%EB%AA%A8%EC%9D%8C-1
//

