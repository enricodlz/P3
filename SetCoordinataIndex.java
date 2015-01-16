import java.util.ArrayList;

public class SetCoordinataIndex {

	private Coordinata          coordinata;
	private ArrayList<String>   id_pezzi;
	private Coordinate<Integer> c_index;
	private Coordinate<String>  c_id;

	public SetCoordinataIndex(Coordinata c, ArrayList<String> ip, Coordinate<String> cid, Coordinate<Integer> ci){
		coordinata = c;
		id_pezzi   = ip;
		c_id       = cid;
		c_index    = ci;
	}

	public void set(){
	    String  cId    = c_id.get(coordinata);
		Integer cIndex = find(id_pezzi,cId);
		
		new TesterInputException().error(
			cIndex==-1,
			"Almeno un pezzo non trova un fratello."
		);
		c_index.set(cIndex,coordinata);
	}

	private int find(ArrayList<String> id_pezzi, String id_pezzo){
		boolean trovato = false;
		if (id_pezzo.equals("VUOTO")) { return -2; }
		int i;
		for ( i=0; i<id_pezzi.size() && !trovato; i++){
			trovato = (id_pezzo.equals(id_pezzi.get(i)) ? true : false);
		}
		return (trovato == true ? i-1 : -1);
	}
}