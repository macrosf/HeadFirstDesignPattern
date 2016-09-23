package headfirst.proxy.virtualproxywithstate.iconstate;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import headfirst.proxy.virtualproxywithstate.ImageProxy;

public class LoadingIcon implements Icon {

	ImageProxy imageProxy;
	
	//ImageIcon imageIcon;
	Thread retrievalThread;
	boolean retrieving = false;
	
	public LoadingIcon(ImageProxy imageProxy) {
		this.imageProxy = imageProxy;
	}
	
	public int getIconWidth() {
		return 800;	
	}

	public int getIconHeight() {
		return 600;
	}

	public void paintIcon(final Component c, Graphics g, int x, int y) {

		g.drawString("Loading CD cover, please wait...", x+300, y+190);
		if (!retrieving) {
			retrieving = true;
			
			retrievalThread = new Thread(new Runnable() {
				public void run() {
					try {
						imageProxy.setImageIcon(
								new ImageIcon(imageProxy.getImageURL(), "CD Cover"));
						c.repaint();
						imageProxy.setIconState(imageProxy.loadedIcon);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			retrievalThread.start();
		}		
	}

}
