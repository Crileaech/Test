
public class DniDuplicadoException extends DniNoValidoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DniDuplicadoException() {
		super();
	}
	public DniDuplicadoException(String msg) {
		super(msg);
	}
	public DniDuplicadoException(String s, String dni) {
		super(s+"Dni Duplicado "+dni);
	}

}
