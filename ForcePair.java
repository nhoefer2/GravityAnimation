

public class ForcePair{
	private double mXForce;
	private double mYForce;
	
	public ForcePair(double inXForce, double inYForce){
		mXForce = inXForce;
		mYForce = inYForce;
	}
	
	public double getXForce(){
		return mXForce;
	}
	
	public void setXForce(double inXForce){
		mXForce = inXForce;
	}
	
	public double getYForce(){
		return mYForce;
	}
	
	public void setYForce(double inYForce){
		mYForce = inYForce;
	}
}