package uppgift2;

public class Constant extends AbstractExpression {
	private String digits;
	
	public Constant(String digits) { 
		this.digits = digits; 
	}
	
	public String toString() { 
		return digits;
	}
	
	public boolean isZero() { 
		return digits.equals("0"); 
	}
	
	public boolean isOne() { 
		return digits.equals("1");
	}
	
	public Expression simplify() { 
		return new Constant(digits); 
	}
}
