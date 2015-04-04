

public class Particle{
	private double mXPos;
	private double mYPos;
	
	private double mXVelocity;
	private double mYVelocity;
	
	private Attraction mAttraction;
	
	public Particle(double inXPos, double inYPos){
		mAttraction = new Attraction();
		mXPos = inXPos;
		mYPos = inYPos;
	}
	
	public void computePos(){
		mXPos = mXPos + mXVelocity;
		mYPos = mYPos + mYVelocity;
	}
	
	public void changeVelocityBy(double inXChange, double inYChange){
		mXVelocity = mXVelocity + inXChange;
		mYVelocity = mYVelocity + inYChange;
	}
	
	public void reverseXVelocity(){
		mXVelocity *= -1.0f;
	}
	
	public void reverseYVelocity(){
		mYVelocity *= -1.0f;
	}
	
	public void reduceXVelocity(double inPercent){
		mXVelocity *= inPercent;
	}
	
	public void reduceYVelocity(double inPercent){
		mYVelocity *= inPercent;
	}
	
	public void setAttraction(Attraction inAttraction){
		mAttraction = inAttraction;
	}
	
	public Attraction getAttraction(){
		return mAttraction;
	}
	
	public double getXPos(){
		return mXPos;
	}
	
	public void setXPos(double inXPos){
		mXPos = inXPos;
	}
	
	public double getYPos(){
		return mYPos;
	}
	
	public void setYPos(double inYPos){
		mYPos = inYPos;
	}
	
	public double getXVelocity(){
		return mXVelocity;
	}

	public void setXVelocity(double inXVelocity){
		mXVelocity = inXVelocity;
	}
	
	public double getYVelocity(){
		return mYVelocity;
	}
	
	public void setYVelocity(double inYVelocity){
		mYVelocity = inYVelocity;
	}
}

