public class PuzzleUnsolvedException extends Exception {
	public PuzzleUnsolvedException(String reason){
		super(reason);
	}
	public String getReason(){
		return getMessage();
	}
}