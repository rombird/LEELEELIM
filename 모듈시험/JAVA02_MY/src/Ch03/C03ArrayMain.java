package Ch03;

public class C03ArrayMain {
	public static void main(String[] args) {

		
//		1차원 배열 VS 2차원 배열
//		int arr[] = new int[3]
//
//		1차원 배열의 배열 요소는 해당 배열을 이루는 자료형 단위
//
//		int arr [][] = new int [2][3]
//
//		2차원 배열의 배열 요소는 1차원 배열
//
//		3차원 배열의 배열 요소는 2차원 배열
//

		
		
		//2차원 배열의 배열요소는 1차원 배열
		int arr[][] = {
				{10,20,30}, //1차원 배열
				{40,50,60,65,67}, //1차원 배열
				{70,80,90,96,11,56}, //1차원 배열
				{100,110,120,15,22,33,44}, //1차원 배열
		};
		
		System.out.println("행의 길이 : "  + arr.length); //4개, r: 1차원 배열요소가 총 4개있으니까
		System.out.println("행의 길이 : "  + arr[0].length);
		System.out.println("행의 길이 : "  + arr[1].length);
		System.out.println("행의 길이 : "  + arr[2].length);
		System.out.println("행의 길이 : "  + arr[3].length);
	}
}

