package exercizetwoplus;

public class Chimpanzee extends Monkey {

	public Chimpanzee() {
	}
	
	public Chimpanzee(int age) {
		this.age = age;
	}
	
	public String getName() {
		this.name ="C";
		return name;
	}
	
	public void sumAge() {
		this.age = this.age+2; 
	}
	
	public int getScore() {
		return (this.age)*2;
	}
	
	public Chimpanzee evolution() {
		return new Flinston(1);
	}
}
