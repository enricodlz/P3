import java.util.ArrayList;

public class PString implements IPuzzle {
	private ArrayList<Pezzo>               pezzi;
	private int                            row;
	private int                            col;
	private ArrayList<Coordinate<Integer>> listaCoordinateIndex;

	public PString(IPuzzle puzzle) {

		pezzi = puzzle.toArrayList();
		row   = puzzle.getRow();
		col   = puzzle.getCol();
	}

	public ArrayList<Pezzo> toArrayList(){
		return pezzi;
	}

	public int getRow(){ return row; }
	public int getCol(){ return col; }

	public String toString(){
		String line = "";
		for (int i=0; i<pezzi.size(); i++){
			line += pezzi.get(i).getCarattere();
		}
		return line;
	}

	public String toMultiLineString(){
		String multiLine = "";

		int nPezzi = pezzi.size();

		for (int i=0; i<nPezzi; i++){
			multiLine += pezzi.get(i).getCarattere();
			if (pezzi.get(i).getCoordinate().get(Coordinata.EST).equals("VUOTO") && i < nPezzi-1){
				multiLine += "\n";
			}
		}
		return multiLine;
	}

	public ArrayList<Coordinate<Integer>> getListaCoordinate(){
		if (listaCoordinateIndex == null) {
			listaCoordinateIndex = new CollegaPezzi(pezzi).getCoordinateIndex();
			new VerificaStruttura(listaCoordinateIndex);
		}
		return listaCoordinateIndex;
	}
}