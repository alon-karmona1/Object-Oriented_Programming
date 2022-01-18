package exercizetwoplus;
import java.util.Random;
public class Monkey {
	
	protected int age;
	protected String name;
	private Random rand;
	
	public Monkey() {
		rand = new Random();
	}
	
	public void randAge() {
		int val = rand.nextInt(10) + 1;
		if(val<=3) { // 30%
			this.age = 2;
		}
		else { // 70%
			this.age = 1;
		}
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		 this.name ="M";
		return name;
	}
	
	public void sumAge() {
		this.age = this.age+1; 
	}
	public Monkey evolution() {
		return new Chimpanzee(1); 
	}
	public int getScore() {
		return this.age;
	}
	
}
