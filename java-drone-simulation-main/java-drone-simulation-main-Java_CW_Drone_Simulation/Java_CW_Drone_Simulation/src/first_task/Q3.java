package first_task;

public class Q3 {

	enum Letters {A,B,C}
	public static void main(String[]args) {
		for (Letters myEnums: Letters.values()) {
			System.out.println(myEnums==Letters.A || myEnums!=Letters.C? Letters.B:Letters.C);
			
		
		}
		
		
	}
}