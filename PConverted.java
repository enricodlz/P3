import java.util.ArrayList;

public class PConverted implements IPuzzle{
	
	private ArrayList<Pezzo> pezzi = new ArrayList<Pezzo>();

	private int nRow = 0;
	private int nCol = 0;
	private ArrayList<Coordinate<Integer>> listaCoordinateIndex;

	public PConverted(ArrayList<String> input){
		
		new TesterInputException().error(
			input.size() <= 0,
			"Puzzle composto da meno di 1 pezzo."
		);

		int nRowOvest = 0;
		int nRowEst   = 0;
		int nColNord  = 0;
		int nColSud   = 0;

		for (int i=0; i<input.size(); i++){
			
			String[] pezzo = input.get(i).split("\t");
			
			new TesterInputException().error(
				pezzo.length<6,
				"Almeno un pezzo non contiene tutti i campi."
			);
			
			new TesterInputException().warning(
				pezzo.length>6,
				"Almeno un pezzo contiene più di 6 campi."
			);

			String id        = pezzo[0];
			String carattere = pezzo[1];
			String nord      = pezzo[2];
			String est       = pezzo[3];
			String sud       = pezzo[4];
			String ovest     = pezzo[5];

			Coordinate<String> coordinate = new Coordinate<String>("");
			coordinate.set(nord, Coordinata.NORD  );
			coordinate.set(sud,  Coordinata.SUD   );
			coordinate.set(est,  Coordinata.EST   );
			coordinate.set(ovest,Coordinata.OVEST );

			nRowOvest += (ovest.equals("VUOTO") ? 1 : 0);
			nRowEst   += (  est.equals("VUOTO") ? 1 : 0);
			nColNord  += ( nord.equals("VUOTO") ? 1 : 0);
			nColSud   += (  sud.equals("VUOTO") ? 1 : 0);

			pezzi.add(new Pezzo(id,carattere, coordinate));
		}
		
		new TesterInputException().error(
			nRowEst != nRowOvest,
			"Numero di righe del puzzle non valido."
		);
		nRow = nRowEst;
		
		new TesterInputException().error(
			nColNord != nColSud,
			"Numero di colonne del puzzle non valido."
		);
		nCol = nColNord;

		new TesterInputException().error(
			input.size() != (nRow*nCol),
			"Numero pezzi non valido."
		);
	}

	public ArrayList<Pezzo> toArrayList(){ return pezzi; }
	
	public int getRow(){ return nRow; }
	public int getCol(){ return nCol; }

	public ArrayList<Coordinate<Integer>> getListaCoordinate(){
		return new ArrayList<Coordinate<Integer>>();
	}

	public String toMultiLineString(){ return ""; }
}