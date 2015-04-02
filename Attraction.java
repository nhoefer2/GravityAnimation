

public class Attraction{
	
	public static double sGravity = 0.01f;
	
	
	public static ForcePair getSimpleForce(double inXStart, double inXEnd, double inYStart, double inYEnd){
		double x = 0.00001f;
		double y = 0.00001f;
		if(inXStart > inXEnd) {
			x *= -1.0f;
		}
		if(inYStart > inYEnd){
			y *= -1.0f;
		}
		return new ForcePair(x, y);
	}
	
	public static ForcePair getForceWithDistance(double inXStart, double inXEnd, double inYStart, double inYEnd){
		double xDist = Math.abs(inXStart - inXEnd);
		double yDist = Math.abs(inYStart - inYEnd);
		
		double totalForce = sGravity / Math.pow(Math.sqrt((xDist * xDist) + (yDist * yDist)), 1);
		
		double angle = Math.atan(yDist/xDist);
		
		double xForce = totalForce * Math.cos(angle);
		double yForce = totalForce * Math.sin(angle);
		if(inXStart > inXEnd) {
			xForce *= -1.0f;
		}
		if(inYStart > inYEnd){
			yForce *= -1.0f;
		}
		return new ForcePair(xForce, yForce);
	}
}