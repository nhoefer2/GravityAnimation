
import javax.swing.SwingUtilities;
public class Physics{
	
	public static MainFrame mView;
	public static void main(String[] args){
		    SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI(mView);
            }

            private void createAndShowGUI(MainFrame mView) {
                mView = new MainFrame();
                mView.setVisible(true);
            }
        });
        
	}
}