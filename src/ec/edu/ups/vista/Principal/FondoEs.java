/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.Principal;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author ByronPC
 */
public class FondoEs implements Border{
    
    public BufferedImage back;
 
    public FondoEs(){
        try {
            URL imagePath = new URL(getClass().getResource("../Principal/hiper.png").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if(back !=null);{
      
     g.drawImage(back, 0, 0,width,height, null);
 
    
    }}
 
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    public boolean isBorderOpaque() {
        return false;
    }
}
