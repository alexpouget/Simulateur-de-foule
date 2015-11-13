package sim.graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.java.swing.plaf.windows.resources.windows;

import sim.Carte;

public class Window extends JFrame{
	
	
	public Window(Carte carte){
		setTitle("simulateur de foule");
		setSize(1000, 725);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JPanel p = new JCarte(carte);
		c.add(p);
		
		
		
		setVisible(true);
		
	}

}
