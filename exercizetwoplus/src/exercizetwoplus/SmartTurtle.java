package exercizetwoplus;
import Turtle.*;
public class SmartTurtle extends Turtle {
	
	
	public void draw (int sides, double size) {
		for (int i = 0; i<sides; i++) {
			super.tailDown();
			super.turnRight(360/sides);
			super.moveForward(size);
			
			
		}
	}
}