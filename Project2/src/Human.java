package exercizetwoplus;

public class Human extends Flinston {
	
	private int money;
	 
	 public Human(){
	 }
	 
	 public Human(int age, int money) {
		 this.age = age;
		 this.money = money;
	 }
	 public void sumAge() {
			this.age = this.age+1; 
		}
	 
	public String getName() {
		this.name ="H";
		return name;
	}
	public void sumMoney() {
		this.money = this.money*2;
	}
	public int getScore() {
		return (this.age)*4;
	}
	public int getMoney() {
		return money;
	}
}
