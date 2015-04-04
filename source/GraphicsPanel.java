
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements MouseListener{
	private Universe mUniverse;
	private ArrayList<Particle> mParticles;
	
	private double mXStart;
	private double mXEnd;
		
	private double mYStart;
	private double mYEnd;
		
	private long mTimeStart;
	private long mTimeEnd;
	
	private double mBlue = 0;
	
	public boolean mTrace = false;
		
	public GraphicsPanel(Universe inUniverse){
		//super();
		mUniverse = inUniverse;
		mParticles = inUniverse.getParticles();
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.BLACK);
		if(!mTrace){
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		
		for(Particle p : mParticles){
			int endRed =(int)((p.getXPos() * 255.0) / (double)(this.getWidth()));
			int endGreen =  (int)((p.getYPos() * 255.0) / this.getHeight());
			if(endRed >= 255) endRed = 255;
			if(endGreen >= 255) endGreen = 255;
			if(endRed <=0) endRed = 0;
			if(endGreen <= 0) endGreen = 0;
			Color end = new Color(endRed, endGreen, 0);
			//int blue = (int)Math.sqrt((p.getXVelocity() * p.getXVelocity()) + (p.getYVelocity() * p.getYVelocity()));
			if(mBlue >= 255) mBlue = 0;
			if(mBlue <= 0) mBlue = 0;
			int startRed = (int)(p.getXVelocity() / 255);
			if(startRed >= 255) startRed = 255;
			int startGreen = (int)(p.getYVelocity() / 255);
			if(startGreen >= 255) startGreen = 255;
			if(startRed <= 0) startRed = 0;
			if(startGreen <= 0) startGreen = 0;
			Color start = new Color(startRed, startGreen, (int)mBlue);
			mBlue += (Attraction.sGravity / 5.0);
			GradientPaint gradient = new GradientPaint((int)p.getXPos(), (int)p.getYPos(), start, (int)p.getXPos() + 30, (int)p.getYPos() + 30, end);
			g2d.setPaint(gradient);
			g2d.fillOval((int)p.getXPos(), (int)p.getYPos(), 30, 30);
		}
	}
	
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3){
				mUniverse.addParticle(new ParticleOne(e.getX(), e.getY()));
			}
		}
		
		public void mousePressed(MouseEvent e) {

			mTimeStart = System.nanoTime();
			mXStart = e.getX();
			mYStart = e.getY();
		}
		
		public void mouseReleased(MouseEvent e) {

			if(e.getButton() == MouseEvent.BUTTON1){
				
			
				mTimeEnd = System.nanoTime();
				Particle particle = new Particle(e.getX(), e.getY());
			
				mXEnd = e.getX();
				mYEnd = e.getY();
				long timeDiff = mTimeEnd - mTimeStart;
			
				double xDiff = mXEnd - mXStart;
				double yDiff = mYEnd - mYStart;
			
				particle.setXVelocity((xDiff / timeDiff)  * 50000);
				particle.setYVelocity((yDiff / timeDiff) * 50000);
			
				mUniverse.addParticle(particle);
				repaint();
			}
		}
		
		public void mouseEntered(MouseEvent e) {

		}
		
		public void mouseExited(MouseEvent e) {
			
		}
}