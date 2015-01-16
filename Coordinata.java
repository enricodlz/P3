public enum Coordinata {
	NORD, SUD, EST, OVEST;

	public Coordinata opposta() {
        switch(this) {
            case NORD  : return Coordinata.SUD;
            case SUD   : return Coordinata.NORD;
            case EST   : return Coordinata.OVEST;
            case OVEST : return Coordinata.EST;
            default: throw new IllegalStateException("Valore non valido: " + this + " Non esiste l'opposto.");
        }
    }
}