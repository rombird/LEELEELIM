package Ch03;

public class C05MainParam { //참고

	public static void main(String[] args) {
		
		System.out.println("length: " + args.length);
		for(String param: args) {
			System.out.println(param); // 외부인자가 없기 때문에 길이 0
			
		}
	}

}
