import java.util.ArrayList;

public class VerificaStruttura {

	private ArrayList<Coordinate<Integer>> listaCoordinateIndex;


	public VerificaStruttura(ArrayList<Coordinate<Integer>> lci){
		listaCoordinateIndex = lci;
		verifica();
	}

	private void verifica(){
		for (int index=0; index<listaCoordinateIndex.size(); index++){
			
			Coordinate<Integer> c_pezzo = listaCoordinateIndex.get(index);

			String errore = "Struttura puzzle non corretta.";

			for (Coordinata coordinata : Coordinata.values()) {
			
				int c_index = c_pezzo.get(coordinata);
				if (c_index != -2){
					new TesterInputException().error(
						listaCoordinateIndex.get(c_index).get(coordinata.opposta()) != index,
						errore
					);
				}
			}
		}
	}
}