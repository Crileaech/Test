
public class DniNoValidoException extends Exception{
	public DniNoValidoException() {
		super();
	}
	public DniNoValidoException(String msg) {
		super(msg);
	}
	public DniNoValidoException(String s, String  dni) {
		super(s+"El DNI:"+dni);
	}
	
}
