package headfirst.proxy.virtualproxywithstate;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import headfirst.proxy.virtualproxywithstate.iconstate.LoadedIcon;
import headfirst.proxy.virtualproxywithstate.iconstate.LoadingIcon;

public class ImageProxy implements Icon {
	ImageIcon imageIcon;
	URL imageURL;
	//Thread retrievalThread;
	//boolean retrieving = false;
    public Icon loadingIcon = new LoadingIcon(this);
    public Icon loadedIcon = new LoadedIcon(this);
	Icon iconState = loadingIcon;	//init state
    
	public ImageProxy(URL url) { imageURL = url; }
     
	public int getIconWidth() {
//		if (imageIcon != null) {
//            return imageIcon.getIconWidth();
//        } else {
//			return 800;
//		}
		
		return iconState.getIconWidth();
	}
 
	public int getIconHeight() {
//		if (imageIcon != null) {
//            return imageIcon.getIconHeight();
//        } else {
//			return 600;
//		}
		
		return iconState.getIconHeight();
	}
     
	public void paintIcon(Component c, Graphics  g, int x,  int y) {
//		if (imageIcon != null) {
//			imageIcon.paintIcon(c, g, x, y);
//		} else {
//			g.drawString("Loading CD cover, please wait...", x+300, y+190);
//			if (!retrieving) {
//				retrieving = true;
//
//				retrievalThread = new Thread(new Runnable() {
//					public void run() {
//						try {
//							imageIcon = new ImageIcon(imageURL, "CD Cover");
//							c.repaint();
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//				retrievalThread.start();
//			}
//		}
		iconState.paintIcon(c, g, x, y);
	}
	

	public URL getImageURL() {
		return imageURL;
	}
	
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	
	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	public void setIconState(Icon state){
		iconState = state;
	}
}
