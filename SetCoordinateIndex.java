import java.util.ArrayList;

public class SetCoordinateIndex {

	private ArrayList<String> id_pezzi;
	private Coordinate<String> c_id;
	private Coordinate<Integer> c_index;

	public SetCoordinateIndex(ArrayList<String> ip, Coordinate<String> cid, Coordinate<Integer> ci){
		id_pezzi = ip;
		c_id     = cid;
		c_index  = ci;
	}

	public void set(){
		for (Coordinata coordinata : Coordinata.values()) {           
            new SetCoordinataIndex(coordinata, id_pezzi, c_id, c_index).set();
        }
    }
}