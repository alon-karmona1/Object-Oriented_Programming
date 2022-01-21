package exercizetwoplus;
import java.util.Scanner;
import Turtle.Turtle;

public class Army {

	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		Turtle[] arrayArmyTurtles = new Turtle[5];
		
		System.out.println("Choose the type of a turtle:");
		System.out.println("1.	Simple\r\n" + 
				"2.	Smart\r\n" + 
				"3.	Drunk\r\n" + 
				"4.	Jumpy\r\n" + 
				"5.	Eight");
		
		for( int i=0;i<5;i++) {
			int userInput = sc.nextInt();
			if (userInput == 1) {
				arrayArmyTurtles[i] = new Turtle();
			}
			if (userInput ==2) {
				arrayArmyTurtles[i] = new SmartTurtle();
			}
			if (userInput == 3) {
				arrayArmyTurtles[i] =  new DrunkTurtle();
			}
			if (userInput == 4) {
				arrayArmyTurtles[i] = new JumpyTurtle();
			}
			if (userInput == 5) {
				arrayArmyTurtles[i] = new EightTurtle();
			}	
		}
		
		int distance = 120;
		int i = 0;
		for(Turtle turtle :arrayArmyTurtles) {
			if(turtle instanceof DrunkTurtle) {
				DrunkTurtle drunk = ((DrunkTurtle) turtle);
				drunk.tailUp();
				drunk.turnRightNormal(90);
				drunk.moveForwardNormal(i*distance);
				drunk.turnLeftNormal(90);
			}
			else {
				turtle.tailUp();
				turtle.turnRight(90);
				turtle.moveForward(i*distance);
				turtle.turnLeft(90);
			}
			i++;
		}
		for(Turtle turtle :arrayArmyTurtles) {
		turtle.tailDown();
		turtle.moveForward(65);
		turtle.turnLeft(40);
		turtle.moveForward(75);
	
		 if( turtle instanceof JumpyTurtle) {
			JumpyTurtle jumpy = ((JumpyTurtle) turtle);
			jumpy.draw(6,40);
			}
		 else if(turtle instanceof EightTurtle  ) {
			EightTurtle eight = ((EightTurtle) turtle);
			eight.draw(6,40);
			}
		 else if(turtle instanceof SmartTurtle) {
			SmartTurtle smart = ((SmartTurtle) turtle);
			smart.draw(6,40);
			}
		
		i++;
		}
		for(Turtle turtle :arrayArmyTurtles) {
			turtle.hide();
		i++;	
		}
	}
}
