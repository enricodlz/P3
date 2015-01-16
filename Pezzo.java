import java.util.ArrayList;

public class Pezzo {
	private String id        = "";
	private String carattere = "";

	private Coordinate<String> c_id;

	public Pezzo(String i, String c, Coordinate<String> coordinate){
		id        = i;
		carattere = c;
		c_id      = coordinate;
	}

	public void setCoordinateIndex(ArrayList<String> id_pezzi,Coordinate<Integer> c_index) {
        new SetCoordinateIndex(id_pezzi, c_id, c_index).set();
	}

	public Coordinate<String> getCoordinate() { return c_id; }

	public String getCarattere() { return carattere; }
	public String getId()        { return id;        }
}