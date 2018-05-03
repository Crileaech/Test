
public enum Contrato {
	FULL_TIME("Jorge", 2.5), PARTIAL_TIME("Cris", 7.9), SCHOOLARSHIP("Ana", 9.2);

	private final String NAME;
	private final Double MULTIPLY;

	Contrato(String NAME, Double MULTIPLY) {
		this.NAME = NAME;
		this.MULTIPLY = MULTIPLY;
	}

	@SuppressWarnings ("unused")
	private String NAME() {
		return NAME;
	}
	@SuppressWarnings ("unused")
	private Double MULTIPLY() {
		return MULTIPLY;
	}
	//Metodo multiplicador
	public static Double calculateYearByMultiply(Integer year) {
		Double cym = 0.;
		cym = year * Contrato.PARTIAL_TIME.MULTIPLY();
		return cym;
	}

}
