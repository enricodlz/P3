import java.util.EnumMap;


public class Coordinate<T> {
	
	private EnumMap<Coordinata, T> coordinate = new EnumMap<Coordinata, T>(Coordinata.class);

	Coordinate(T empty){
		for (Coordinata coordinata : Coordinata.values()) {
            coordinate.put(coordinata, empty);
        }
	}
	
	public T get(Coordinata coordinata){
		return coordinate.get(coordinata);
	}

	public void set(T d, Coordinata coordinata) {
		coordinate.put(coordinata, d);
	}
}