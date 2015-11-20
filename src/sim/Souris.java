package sim;

import algo.graph.interfaces.INode;
import algo.graph.router.PathFinder;
import algo.stack.interfaces.ILifo;

public class Souris {

	private int id;
	private ILifo<INode<String, Object>> chemin;
	private Carte carte;
	private Integer porte;
	private Integer fromage;
	
	public Souris() {
		super();
		
	}
	public Souris(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ILifo<INode<String, Object>> getChemin() {
		return chemin;
	}
	public void setChemin(ILifo<INode<String, Object>> chemin) {
		this.chemin = chemin;
	}
	public void findChemin(){
		PathFinder p = new PathFinder();
		p.Find(carte.getGraph(), carte.getStart().get(id%carte.getStart().size()),carte.getFin().get(id%carte.getFin().size()));
		chemin = p.recompile(carte.getStart().get(id%carte.getStart().size()),carte.getFin().get(id%carte.getFin().size()));
		
	}
	
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	public void initCarte(String file) {
		this.carte = new Carte(file);
	}
	public Integer getPorte() {
		return porte;
	}
	public void setPorte(Integer porte) {
		this.porte = porte;
	}
	public Integer getFromage() {
		return fromage;
	}
	public void setFromage(Integer fromage) {
		this.fromage = fromage;
	}
	
	
}
