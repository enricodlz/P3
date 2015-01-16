public class TesterInputException {

	public TesterInputException(){}
	
	public void error(boolean test, String error) {
		try {
			if (test) { throw new InputException(error); }
		}
		catch (InputException ie) {
			ie.printErrorAndExit();
		}	
	}

	public void warning(boolean test, String error) {
		try {
			if (test) { throw new InputException(error); }
		}
		catch (InputException ie) {
			ie.printWarning();
		}	
	}
}