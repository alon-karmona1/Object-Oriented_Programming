package exercizetwoplus;

public class Flinston extends Chimpanzee {
	
	public Flinston() {
	}
	
	public Flinston(int x) {
		this.age = x;	
	}
	public Flinston evolution() {
		return new Human(1,2);
	}
	
	public void sumAge() {
		this.age = this.age+1; 
	}
	
	public int getScore() {
		return (this.age)*3;
	}
	public String getName() {
		this.name ="F";
		return name;
	}
	
}
