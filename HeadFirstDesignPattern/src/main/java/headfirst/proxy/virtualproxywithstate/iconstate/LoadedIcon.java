package headfirst.proxy.virtualproxywithstate.iconstate;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

import headfirst.proxy.virtualproxywithstate.ImageProxy;

public class LoadedIcon implements Icon {

	ImageProxy imageProxy;
	
	//ImageIcon imageIcon;
	Thread retrievalThread;
	boolean retrieving = false;
	
	public LoadedIcon(ImageProxy imageProxy) {
		this.imageProxy = imageProxy;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		imageProxy.getImageIcon().paintIcon(c, g, x, y);
	}

	public int getIconWidth() {
		return imageProxy.getImageIcon().getIconWidth();
	}

	public int getIconHeight() {
		return imageProxy.getImageIcon().getIconHeight();
	}

}
