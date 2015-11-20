package sim.graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import sim.Carte;
import sim.Main;

public class JCarte extends JPanel {
	
	Carte carte;
	private List<Integer> posSouris;
	public JCarte(Carte carte){
		super();
		this.carte = carte;
		posSouris = new ArrayList<>();
	}
	
	public void paint(Graphics g){
		Carte c = this.carte;
		int count = 1;
		for(int i = 0;i<c.getRow();i++){
			for(int y = 0;y<c.getCol();y++){
				if(c.getEl()[i][y]==' '){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/sol.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='*'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/mur.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='G'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/herbe.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='D'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/porte.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='A'){
					
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/fromage.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}
				for(int j = 0;j<posSouris.size();j++){
					if(posSouris!=null && posSouris.get(j)==count){
						
						Image img = Toolkit.getDefaultToolkit().getImage("ressources/souris.png");
						g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
					}
				}
				count++;
			}
		}
	}
	
	public void repaint(Graphics g){
		Carte c = this.carte;
		int count = 1;
		for(int i = 0;i<c.getRow();i++){
			for(int y = 0;y<c.getCol();y++){
				if(c.getEl()[i][y]==' '){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/sol.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='*'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/mur.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='G'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/herbe.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='D'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/porte.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}else if(c.getEl()[i][y]=='A'){
					Image img = Toolkit.getDefaultToolkit().getImage("ressources/fromage.png");
					g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
				}
				for(int j = 0;j<posSouris.size();j++){
					if(posSouris!=null && posSouris.get(j)==count){
						
						Image img = Toolkit.getDefaultToolkit().getImage("ressources/souris.png");
						g.drawImage(img, (0+(y*20)), (22+(i*20)),this);
					}
				}
				count++;
			}
		}
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public List<Integer> getPosSouris() {
		return posSouris;
	}

	public void setPosSouris(List<Integer> posSouris) {
		this.posSouris = posSouris;
	}

	public void addPosSouris(Integer pos){
		posSouris.add(pos);
	}
	
	
	

}
