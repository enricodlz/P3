public class InputException extends Exception {
	public InputException(String reason){
		super(reason);
	}
	public String getReason(){
		return getMessage();
	}

	public void printErrorAndExit(){
		System.out.println("Errore:\t"+ getMessage());
		System.exit(0);
	}

	public void printWarning(){
		System.out.println("Warning:\t"+ getMessage());
	}
}