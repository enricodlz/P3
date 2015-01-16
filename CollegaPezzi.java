import java.util.ArrayList;

public class CollegaPezzi {

	private ArrayList<Coordinate<Integer>> listaCoordinateIndex;
	private ArrayList<Pezzo>               pezzi;
	private ArrayList<String>              idList = new ArrayList<String>();;

	public CollegaPezzi(ArrayList<Pezzo> p){
		pezzi  = p;
		inizializza();
		collega();
	}

	private void inizializza(){
		
		listaCoordinateIndex = new ArrayList<Coordinate<Integer>>();

		for (int i=0; i<pezzi.size(); i++){
			idList.add( pezzi.get(i).getId() );
			listaCoordinateIndex.add(new Coordinate<Integer>(-1));
		}
	}

	private void collega(){
		for (int i=0; i<pezzi.size(); i++){
			pezzi.get(i).setCoordinateIndex(idList,listaCoordinateIndex.get(i));
		}
	}

	public ArrayList<Coordinate<Integer>> getCoordinateIndex(){
		return listaCoordinateIndex;
	}
}