

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
	private Universe mUniverse;
	private GraphicsPanel mGraphicsPanel;
	public ControlPanel mControlPanel;
	
	public MainFrame(){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mUniverse = new Universe();
		mGraphicsPanel = new GraphicsPanel(mUniverse);
		mUniverse.setGraphicsPanel(mGraphicsPanel);
		mGraphicsPanel.addMouseListener(mGraphicsPanel);
		mControlPanel = new ControlPanel();
		mControlPanel.setLayout(new BoxLayout(mControlPanel, BoxLayout.X_AXIS));
		getContentPane().add(BorderLayout.NORTH, mControlPanel);
		getContentPane().add(BorderLayout.CENTER, mGraphicsPanel);
		Simulator sim = new Simulator(mUniverse, mGraphicsPanel);
		Thread t = new Thread(sim);
		t.start();
		
		Dimension size = mControlPanel.getPreferredSize();
		setSize((int)size.getWidth()+50, 300);
		
	}
	
	
	public class ControlPanel extends JPanel implements ActionListener, ItemListener{
		private JButton mResetButton;
		private JButton mIncreaseGravity;
		private JButton mDecreaseGravity;
		public JCheckBox mTrace;
		
		public ControlPanel(){
			mResetButton = new JButton("Reset");
			mResetButton.addActionListener(ControlPanel.this);
			ControlPanel.this.add(mResetButton);
			
			mIncreaseGravity = new JButton("Increase Gravity");
			mIncreaseGravity.addActionListener(ControlPanel.this);
			ControlPanel.this.add(mIncreaseGravity);
			
			mDecreaseGravity = new JButton("Decrease Gravity");
			mDecreaseGravity.addActionListener(ControlPanel.this);
			ControlPanel.this.add(mDecreaseGravity);
			
			mTrace = new JCheckBox("Trace");
			mTrace.addItemListener(ControlPanel.this);
			ControlPanel.this.add(mTrace);
		}
		
		public void actionPerformed(ActionEvent inEvent){
			String command = inEvent.getActionCommand();
			switch(command){
				case "Reset":
					mUniverse.resetUniverse();
					break;
				case "Increase Gravity":
					Attraction.sGravity += 0.0001f;
					break;
				case "Decrease Gravity":
					Attraction.sGravity -= 0.0001f;
				break;
			}
			
		}
		
		public void itemStateChanged(ItemEvent ev){
			mGraphicsPanel.mTrace = mTrace.isSelected();
		}
		
	}
}