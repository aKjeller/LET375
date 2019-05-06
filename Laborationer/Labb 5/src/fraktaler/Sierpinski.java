package fraktaler;

public class Sierpinski extends Flake {

	public void draw(Turtle turtle,int n,double size) {
		this.turtle = turtle;
		turtle.turnTo(0.0);
		drawSide(n,size);
		turtle.turn(-120.0);
		drawSide(n,size);
		turtle.turn(-120.0);
		drawSide(n,size);
		turtle.turn(-120.0);
	}

	private void drawSide(int n,double size) {
		if ( n <= 0 )
			turtle.walk(size);
		else {
			double l = size/2.0;
			drawSide(n-1,l);
			turtle.turn(-120);
			drawSide(n-1,l);
			turtle.turn(-120);
			drawSide(n-1,l);
			turtle.turn(-120);
			drawSide(n-1,size);
		}
	}
}
