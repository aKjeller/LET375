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
		/* TODO */ 
		return null;
	}
}
