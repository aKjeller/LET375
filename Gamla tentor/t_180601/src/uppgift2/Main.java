package uppgift2;

public class Main {

	public static void main(String[] args) {
		Expression zero = new Constant("0");
		Expression one = new Constant("1");
		Expression x = new Variable("x");
		Expression y = new Variable("y");
		Expression e1 = new Addition(zero,x);
		Expression e2 = new Addition(y,zero);
		Expression e3 = new Addition(e1,e2);
		System.out.println(e3); 				//Utskrift: ((0 + x) + (y + 0))
		System.out.println(e3.simplify()); 		//Utskrift: (x + y)
		Expression e4 = new Multiplication(one,e1);
		Expression e5 = new Multiplication(e2,zero);
		Expression e6 = new Addition(e4,e5);
		System.out.println(e6); 				//Utskrift: ((1*(0 + x)) + ((y + 0)*0))
		System.out.println(e6.simplify()); 		//Utskrift: x
	}

}
