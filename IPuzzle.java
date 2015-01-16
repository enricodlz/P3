import java.util.ArrayList;

public interface IPuzzle{
    public ArrayList<Pezzo>               toArrayList();
    public int                            getRow();
    public int                    		  getCol();
    public ArrayList<Coordinate<Integer>> getListaCoordinate();
    public String                         toString();
    public String                         toMultiLineString();
}