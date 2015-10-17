package sim.graph;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.java.swing.plaf.windows.resources.windows;

public class Window extends JFrame{
	
	public Window(){
		setTitle("simulateur de foule");
		setSize(1000, 725);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container container = getContentPane();
		JPanel pane = new JPanel();
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		container.add(pane);
		pane.setLayout(grid);
		

		c.gridheight = 1;
		c.gridwidth = 1;
		
		
		//sol
		
		//horizontal
		for(int i=1;i<48;i++){
			for(int y=1;y<21;y++){
				c.gridx = i;
				c.gridy = y;
				
				pane.add(new JLabel(new ImageIcon("ressources/sol.png")),c);
				
			}	
		}
		
		//mur
		//horizontal
		for(int i=0;i<49;i++){
			c.gridx = i;
			c.gridy = 0;
			pane.add(new JLabel(new ImageIcon("ressources/mur.png")),c);
		}
		//horizontal
		for(int i=0;i<49;i++){
			c.gridx = i;
			c.gridy = 21;
			pane.add(new JLabel(new ImageIcon("ressources/mur.png")),c);
		}
		//vertical
		for(int i=0;i<22;i++){
			c.gridx = 0;
			c.gridy = i;
			pane.add(new JLabel(new ImageIcon("ressources/mur.png")),c);
		}
		//vertical
		for(int i=0;i<22;i++){
			c.gridx = 48;
			c.gridy = i;
			pane.add(new JLabel(new ImageIcon("ressources/mur.png")),c);
		}
		
//		fromage 1
		c.gridx = 5;
		c.gridy = 2;
		pane.add(new JLabel(new ImageIcon("ressources/fromage.png")),c);
		
//		fromage 2
		c.gridx = 43;
		c.gridy = 1;
		pane.add(new JLabel(new ImageIcon("ressources/fromage.png")),c);
		
		
		
		setVisible(true);
	}

}
