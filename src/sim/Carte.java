package sim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Carte {
	private char[][] el;
	private int row;
	private int col;
	
	public Carte(String file){
		File fichier = new File(file);
        if (!fichier.exists() || !fichier.canRead()) {
            System.out.println("pb file");
            
        } else try {
            FileReader f = new FileReader(fichier);
            BufferedReader in = new BufferedReader(f);
            String line;
            line = in.readLine();
            row = Integer.parseInt(line);
            line = in.readLine();
            col = Integer.parseInt(line);
            
            this.el = new char[row][col];
            
            for(int i=0;i<row;i++){
            	line = in.readLine();
            	for(int y=0;y<col;y++){
            		el[i][y] = line.charAt(y);
            	}
            }
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
	}

	public char[][] getEl() {
		return el;
	}

	public void setEl(char[][] el) {
		this.el = el;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	
}
