package Ch05Inheritance;

class Point2D{
	int x;
	int y;
	
	Point2D(){
		System.out.println("Point2D생성자 호출");
	}
	Point2D(int x) {
		this.x = x;
		System.out.println("Point2D(int x) 호출");
	}
	Point2D(int x, int y ) {
		this.x= x;
		this.y=y;
		System.out.println("Point2D(int x, int y)생성자 호출");}
}

class Point3D extends Point2D{ //하위클래스 extends 상위클래스 : 상속받겠다!
	int z;
	
	//Point2D 생성자를 먼저 호출해서 공간을 선확보한 후 Point3D공간을 확보함
	//상위클래스 생성자를 먼저 호출해서 공간을 선확보한 후 하위클래스 공간을 확보함
	//이유 : 	super(); -> 상위클래스의 생성자를 먼저 호출하는 기본적인 예약어 코드가 삽입되어있음
	

	
	Point3D(){
		super(); //상위클래스의 생성자를 먼저 호출하는 기본적인 예약어 코드가 삽입되어있음
				 //상위클래스 Point2D() 생성자 호출
		System.out.println("Point3D생성자 호출");
	}
	
	Point3D(int x){
		super(x);		//상위클래스 Point2D(int x) 생성자 호출
						//오버로딩된 상위클래스 생성자가 호출됨
		System.out.println("Point3D(int x) 생성자 호출");
	}
	
	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
}

public class C02InheritanceMain {

	public static void main(String[] args) {
		Point3D ob = new Point3D(10);
		ob.x=10;
		ob.y=20;
		ob.z=30;
		System.out.println(ob);
	};

}
