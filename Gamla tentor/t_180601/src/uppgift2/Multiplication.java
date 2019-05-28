package uppgift2;

public class Multiplication extends AbstractBinaryExpression {
	
	public Multiplication(Expression leftOperand,Expression rightOperand) {
		super(leftOperand,rightOperand);
	}	
	public String toString() { 
		return "(" + this.leftOperand.toString() + "*" + this.rightOperand.toString() + ")";
	}
	public Expression simplify() {
		if(this.leftOperand.isOne())
			return this.rightOperand.simplify();
		if(this.rightOperand.isOne())
			return this.leftOperand.simplify();
		if(this.leftOperand.isZero() || this.rightOperand.isZero())
			return new Constant("0");
		return new Multiplication(this.leftOperand.simplify(), this.rightOperand.simplify());
	}
}