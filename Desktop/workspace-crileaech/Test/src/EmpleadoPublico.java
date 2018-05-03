import java.time.LocalDate;
import java.util.List;

public  class EmpleadoPublico extends Persona implements AutoCloseable {
	private String publicOrganism;
	private Integer threeYear;
	public EmpleadoPublico(String name, String surname, String dni, Integer age, LocalDate startYear,
			Integer retiredYear, Contrato contrato, String pO, Integer tY) throws DniNoValidoException {
		super(name, surname, dni, age, startYear, retiredYear, contrato);
		// TODO Auto-generated constructor stub
		this.publicOrganism = pO;
		this.threeYear = tY;
	}
	public String getPublicOrganism() {
		return publicOrganism;
	}
	public void setPublicOrganism(String publicOrganism) {
		this.publicOrganism = publicOrganism;
	}
	public Integer getThreeYear() {
		return threeYear;
	}
	public void setThreeYear(Integer threeYear) {
		this.threeYear = threeYear;
	}
	@Override
	public String imprimeHistorial() {
		// TODO Auto-generated method stub
		return "EmpleadoPublic" +this.getPublicOrganism() + this.getThreeYear();
		
		
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Expedient close");
	
		
		
	}
	
	

	
}
