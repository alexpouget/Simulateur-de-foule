package sim.graph;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.java.swing.plaf.windows.resources.windows;

import sim.Carte;
import sim.Main;

public class Window extends JFrame{
	private JPanel p;
	private JTextField porte1Field;
	private JTextField porte2Field;
	
	public Window(Carte carte){
		setTitle("simulateur de foule");
		setSize(1000, 625);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		p = new JCarte(carte);
		c.add(p,BorderLayout.CENTER);
		JPanel tableau = new JPanel();
		tableau.setBackground(Color.yellow);
		
		c.add(tableau,BorderLayout.SOUTH);
		GridBagLayout grid = new GridBagLayout();
		tableau.setLayout(grid);
		
		GridBagConstraints constraint = new GridBagConstraints();
		
		constraint.gridx=0;
		constraint.gridy=0;
		JLabel porte1Text = new JLabel("porte1");
		tableau.add(porte1Text, constraint);
		constraint.gridx=1;
		constraint.gridy=0;
		JLabel porte2Text = new JLabel("porte2");
		tableau.add(porte2Text, constraint);
		constraint.gridx=0;
		constraint.gridy=1;
		porte1Field = new JTextField(Main.souris1);
		porte1Field.setSize(50, 24);
		tableau.add(porte1Field, constraint);
		constraint.gridx=1;
		constraint.gridy=1;
		porte2Field = new JTextField(Main.souris2);
		porte2Field.setSize(50, 24);
		tableau.add(porte2Field, constraint);
		constraint.gridx=2;
		constraint.gridy=2;
		constraint.gridheight=2;
		constraint.gridwidth=2;
		Button button = new Button("depart");
		tableau.add(button, constraint);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.souris1 = Integer.valueOf(porte1Field.getText());
				Main.souris2 = Integer.valueOf(porte2Field.getText());
				
			}
			
		});
		
		
		
		setVisible(true);
		
	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}
	
	

}
