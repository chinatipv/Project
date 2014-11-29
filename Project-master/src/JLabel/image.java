package JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;

public class image {
ImageIcon image ;
image(Image i){
	image = new ImageIcon(i);
}
public ImageIcon getImage(){
	return image;
}
}
