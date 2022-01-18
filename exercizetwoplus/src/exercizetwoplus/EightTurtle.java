package exercizetwoplus;
import java.util.Random;

public class EightTurtle extends SmartTurtle {
	private Random rand;// = new Random();
	
	public EightTurtle() {
		rand = new Random();
	}
	public void draw (int sides, double size) {
		double val = rand.nextDouble();
		if (val <= 0.7) {
			super.draw(8,size);
		}
		else {
			super.draw(sides,18);
		}
	}
}
