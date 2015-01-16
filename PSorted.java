import java.util.ArrayList;

public class PSorted implements IPuzzle {
	private ArrayList<Coordinate<Integer>> listaCoordinateInteger;
	private ArrayList<Pezzo>       pezzi = new ArrayList<Pezzo>();
	private ArrayList<Integer>     start_lines;
	private int                    row;
	private int                    col;

	public PSorted(IPuzzle puzzle) {
		int first = findFirst(puzzle.toArrayList());
		listaCoordinateInteger = puzzle.getListaCoordinate();
		start_lines = findStartLines(first);
		addPezzi(puzzle.toArrayList());

		row = puzzle.getRow();
		col = puzzle.getCol();
	}

	public int getRow(){ return row; }
	public int getCol(){ return col; }

	public String toMultiLineString(){ return ""; }

	private int findFirst(ArrayList<Pezzo> input_pezzi){
		int first = -1;
		boolean trovato = false;
		for (int i=0; i<input_pezzi.size() && !trovato; i++){
			
			Coordinate<String> c = input_pezzi.get(i).getCoordinate();

			trovato = (c.get(Coordinata.NORD).equals("VUOTO") && c.get(Coordinata.OVEST).equals("VUOTO"));

			if ( trovato ){	first = i; }
		}
		return first;
	}

	private ArrayList<Integer> findStartLines(int first){
		ArrayList<Integer> borderOvest = new ArrayList<Integer>();
		
		new TesterInputException().error(
			first==-1,
			"Almeno un pezzo del bordo ovest non è definito."
		);

		borderOvest.add(new Integer(first));
 		int next = listaCoordinateInteger.get(first).get(Coordinata.SUD);
		while ( next != -2 ){
			borderOvest.add(new Integer(next));
			next = listaCoordinateInteger.get(next).get(Coordinata.SUD);
		}
		return borderOvest;
	}

	private void addPezzi(ArrayList<Pezzo> input_pezzi){
		for (int i=0; i<start_lines.size(); i++){
			int start = start_lines.get(i);
			
			pezzi.add(input_pezzi.get(start));

			int next = listaCoordinateInteger.get(start).get(Coordinata.EST);

			while (next != -2){
				pezzi.add(input_pezzi.get(next));
				next = listaCoordinateInteger.get(next).get(Coordinata.EST);
			}
		}
	}

	public ArrayList<Pezzo> toArrayList(){
		return pezzi;
	}

	public ArrayList<Coordinate<Integer>> getListaCoordinate(){
		return new ArrayList<Coordinate<Integer>>();
	}
}