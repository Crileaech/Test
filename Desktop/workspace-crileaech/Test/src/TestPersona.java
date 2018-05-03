import java.time.LocalDate;

public class TestPersona {

	public static void main(String[] args) throws DniNoValidoException {
		// TODO Auto-generated method stub
		LocalDate date =LocalDate.of(1998, 01, 1);
		Persona p1 = new EmpleadoPublico("Ana","Rodriguez","4564564Z",12,date, 2060, Contrato.FULL_TIME, null, null);
		
		System.out.println("Show me : " +p1);
	}

}
