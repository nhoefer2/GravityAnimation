

public class Simulator implements Runnable{

	private Universe mUniverse;
	private GraphicsPanel mGraphicsPanel;
	public Simulator(Universe inUniverse, GraphicsPanel inPanel){
		mUniverse = inUniverse;
		mGraphicsPanel = inPanel;
	}

	public void run(){
		System.out.println("running");
		for(;;){
			
			mUniverse.computeFrame();
			mGraphicsPanel.repaint();
			
			try{
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}