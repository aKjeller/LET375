package uppgift2;

public class Addition extends AbstractBinaryExpression {
	public Addition(Expression leftOperand,Expression rightOperand) {
		super(leftOperand,rightOperand);
	}
	public String toString() {
		/* TODO */ 
		return "(" + this.leftOperand.toString() + " + " + this.rightOperand.toString() + ")";
	}
	public Expression simplify() {
		if(this.leftOperand.isZero())
			return this.rightOperand.simplify();
		if(this.rightOperand.isZero())
			return this.leftOperand.simplify();
		else
			return new Addition(this.leftOperand.simplify(), this.rightOperand.simplify());
	}
}
