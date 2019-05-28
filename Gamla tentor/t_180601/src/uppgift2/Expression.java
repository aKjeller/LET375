package uppgift2;

public interface Expression {
	boolean isZero();
	boolean isOne();
	String toString();
	Expression simplify();
}