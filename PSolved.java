import java.util.ArrayList;

public class PSolved implements IPuzzle {

	private ArrayList<Pezzo>               pezzi;
	private ArrayList<Coordinate<Integer>> listaCoordinateIndex;

	private int row;
	private int col;

	public PSolved(IPuzzle puzzle){
		pezzi = puzzle.toArrayList();
		row   = puzzle.getRow();
		col   = puzzle.getCol();

		listaCoordinateIndex = new CollegaPezzi(pezzi).getCoordinateIndex();
		new VerificaStruttura(listaCoordinateIndex);
	}

	public int getRow(){ return row; }
	public int getCol(){ return col; }

	public ArrayList<Pezzo> toArrayList(){
		return pezzi;
	}

	public String toMultiLineString(){ return ""; }

	public ArrayList<Coordinate<Integer>> getListaCoordinate(){
		return listaCoordinateIndex;
	}
}