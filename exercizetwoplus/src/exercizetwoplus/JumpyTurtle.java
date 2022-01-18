package exercizetwoplus;

public class JumpyTurtle extends SmartTurtle {
	
	private boolean isTailUp;

	@Override
	public void tailUp() {
		// TODO Auto-generated method stub
		super.tailUp();
		isTailUp = true;
	}

	@Override
	public void tailDown() {
		// TODO Auto-generated method stub
		super.tailDown();
		isTailUp = false;
	}


	public void moveForward(double distance) {
		if (isTailUp)
			super.moveForward(distance);
		else {
			for(int j = 0; j < distance; j++) {
				if(j%5==0)
				{
					if(isTailUp) {
						this.tailDown();
					}
					else {
						this.tailUp();
					}
					super.moveForward(5);
				}
			}
		}
		this.tailDown();
	}
	public void draw (int sides, double size) {
		for (int i = 0; i<sides; i++) {
			super.tailDown();
			this.turnRight(360/sides);
			this.moveForward(size);
			
			
		}
	

}
}