package Ch04;

import java.util.ArrayList;
import java.util.List;

//★★★ 지금은(8/19)데이터 추가(add) / 객체 생성 / size(확인)만 기억하기!★★★

public class C01ListMain {
	
	public static void main(String[]args) {
		
		List<String> list = new ArrayList(); // 상위클래스에 하위클래스를 연결함 : UPCASTING
		//상위클래스List			//하위클래스ArrayList
		//< > : list안에 저장된 자료형은 String임을 명시해줌
		
		//추가 - 값삽입
		list.add("HTML/CSS/JS");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");
		
		//조회
		System.out.println("개수 확인 : " + list.size());
		System.out.println("idx로 조회 : " + list.get(2));
		System.out.println("Value로 idx확인 : " + list.indexOf("JAVA")); //JAVA를 포함한 index번호
		list.forEach(System.out::println); //첨자문자
		
		//삭제
		list.remove(0);
		list.remove("JQUERY");
		System.out.println("---");
		list.forEach(System.out::println);
		
		//전체삭제
		list.clear();
	}

}









