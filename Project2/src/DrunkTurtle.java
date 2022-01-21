package exercizetwoplus;
import java.util.Random;

import Turtle.*;
public class DrunkTurtle extends Turtle {
	
	private Random rand;// = new Random();
	
	public DrunkTurtle() {
		rand = new Random();
	}
	
	public void moveForwardNormal(double distance) {
		super.moveForward(distance);
	}
	
	public void turnLeftNormal(int degrees) {
		super.turnLeft(degrees);
	}
	
	public void turnRightNormal(int degrees) {
		super.turnRight(degrees);
	}
	
	public void moveForward(double distance) {
		
	int val =  rand.nextInt((int) distance)+1;
	super.moveForward(val);
	double valLeft = rand.nextDouble();
	if (valLeft <= 0.3) {
		this.turnLeft((int) distance);
	}
	int val2 =  rand.nextInt((int) distance)+1;
	super.moveForward(val2);
	}
	
	public void turnRight(int degrees) {
		
		int val =  rand.nextInt(2*degrees)+1;
		super.turnRight(val);
	}
	
	public void turnLeft(int degrees) {
		
		int val =  rand.nextInt(2*degrees)+1;
		super.turnLeft(val);
	}

}
