
public class ExpedientNotProccessException extends Exception{
	public ExpedientNotProccessException() {
		super();
	}
	public ExpedientNotProccessException(String msg) {
		super(msg);
	}
	public ExpedientNotProccessException(String s, String publicOrganism) {
		super(s+"Trying close exception" +publicOrganism);
	}

}
