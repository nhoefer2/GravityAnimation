
import java.util.*;

public class Universe{
	private ArrayList<Particle> mParticles = new ArrayList<Particle>();
	private GraphicsPanel mGraphicsPanel;
	
	public synchronized void addParticle(Particle inParticle){
		mParticles.add(inParticle);
	}
	
	public void setGraphicsPanel(GraphicsPanel inPanel){
		mGraphicsPanel = inPanel;
	}
	
	public synchronized void resetUniverse(){
		mParticles.clear();
	}
	
	
	public synchronized void computeFrame(){
		//System.out.println("computing");
		for(int i = 0; i < mParticles.size(); i++){
			for(int j = 0; j < mParticles.size(); j++){
				if(i != j){
					mParticles.get(i).computePos();
					ForcePair fp = mParticles.get(j).getAttraction().getForceWithDistance(mParticles.get(i).getXPos(),
																					mParticles.get(j).getXPos(),
																					mParticles.get(i).getYPos(),
																					mParticles.get(j).getYPos());
					mParticles.get(i).changeVelocityBy(fp.getXForce(), fp.getYForce());
				}
				
			}/*
			if( (mParticles.get(i).getYPos() >= (mGraphicsPanel.getHeight() - 30.0f)) && mParticles.get(i).getYVelocity() > 0){
				mParticles.get(i).reverseYVelocity();
				mParticles.get(i).reduceYVelocity(0.5);
			}
			if (mParticles.get(i).getYPos() <= 0 && mParticles.get(i).getYVelocity() < 0){
				mParticles.get(i).reverseYVelocity();
				mParticles.get(i).reduceYVelocity(0.5);
			}
			if (mParticles.get(i).getXPos() <= 0 && mParticles.get(i).getXVelocity() < 0){
				mParticles.get(i).reverseXVelocity();
				mParticles.get(i).reduceXVelocity(0.5);
			}
			if (mParticles.get(i).getXPos() >= (mGraphicsPanel.getWidth() - 30.0f) && mParticles.get(i).getXVelocity() > 0){
				mParticles.get(i).reverseXVelocity();
				mParticles.get(i).reduceXVelocity(0.5);
			}*/
		}
	}
	
	public ArrayList<Particle> getParticles(){
		return mParticles;
	}
}