
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
			int startRed =(int)((p.getXPos() * 255.0) / (double)(this.getWidth()));
			Color end = new Color(startRed, (int)((p.getYPos() * 255.0) / (double)(getHeight())), 0);
			//int blue = (int)Math.sqrt((p.getXVelocity() * p.getXVelocity()) + (p.getYVelocity() * p.getYVelocity()));
			if(mBlue >= 255) mBlue = 0;
			int red = (int)(p.getXVelocity() / 255);
			if(red >= 255) red = 255;
			int green = (int)(p.getYVelocity() / 255);
			if(green >= 255) green = 255;
			Color start = new Color(red, green, (int)mBlue);
			mBlue += 0.001;
			GradientPaint gradient = new GradientPaint((int)p.getXPos(), (int)p.getYPos(), start, (int)p.getXPos() + 30, (int)p.getYPos() + 30, end);
			g2d.setPaint(gradient);
			g2d.fillOval((int)p.getXPos(), (int)p.getYPos(), 30, 30);
		}
	}
	
		public void mouseClicked(MouseEvent e) {
			//mUniverse.addParticle(new Particle(e.getX(), e.getY()));
			//System.out.println("clicked");
			//this.repaint();
		}
		
		public void mousePressed(MouseEvent e) {

			mTimeStart = System.nanoTime();
			mXStart = e.getX();
			mYStart = e.getY();
		}
		
		public void mouseReleased(MouseEvent e) {

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
		
		public void mouseEntered(MouseEvent e) {

		}
		
		public void mouseExited(MouseEvent e) {
			
		}
}