package uppgift2;

public abstract class AbstractBinaryExpression extends AbstractExpression {
	protected Expression leftOperand,rightOperand;
	
	public AbstractBinaryExpression(Expression leftOperand, Expression rightOperand) {
		if ( leftOperand == null || rightOperand == null )
			throw new IllegalStateException();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
}
