import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Persona implements Comparable<Persona>, Cotizable  {
	//Atributos
	private String name,surname,dni;
	private LocalDate startYear;
	private Integer age, retiredYear;
	private Contrato contrato;
	//Constructores
	
	public Persona(String name, String surname, String dni, Integer age, 
			LocalDate startYear,Integer retiredYear,Contrato contrato) throws DniNoValidoException {
		
		//checkDni(dni);
		
		this.name = name;
		this.surname = surname;
		this.dni=dni;
		this.age = age;
		this.startYear = startYear; 
		this.retiredYear = retiredYear;
		this.contrato = contrato;
	}
	
	 
	
//	private void checkDni(String dni) throws DniNoValidoException {
//		// TODO Auto-generated method stub
//		//Need end the checker 
//		if(dni.length() != 9   ) {
//			throw new DniNoValidoException("No tiene el formato adecuado");
//		}
//		
//	}
	//Metodos 
	
	public int compareTo(Persona p){
		// TODO Auto-generated method stub
		int res;
		res = this.getName().compareTo(p.getName());
		return res;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String getSurname() {
		// TODO Auto-generated method stub
		return surname;
	}
	
	public String getDni() throws DniNoValidoException {
		// TODO Auto-generated method stub
		return dni;
	}
	
	public Integer getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	public Integer getRetiredYear() {
		// TODO Auto-generated method stub
		return retiredYear;
	}
	
	public LocalDate getStartedYear() {
		// TODO Auto-generated method stub
		
		return startYear;
	}
	public void setEdad(Integer newAge) {
		// TODO Auto-generated method stub
		this.age = newAge;
		
	}
	public void setRetiredYear(Integer newRetiredYear ) {
		// TODO Auto-generated method stub
		this.retiredYear = newRetiredYear;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((retiredYear == null) ? 0 : retiredYear.hashCode());
		result = prime * result + ((startYear == null) ? 0 : startYear.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	
	public boolean equals (Object o) {
		boolean r = false;
		if (o instanceof Persona) {
			Persona p = (Persona) o;
			try {
				if(this.getName().equals(p.getName())
						&& this.getSurname().equals(p.getSurname())
						&& this.getDni().equals(p.getDni())
						&& this.getAge().equals(p.getAge())
						&& this.getRetiredYear().equals(p.getRetiredYear())
						&& this.getStartedYear().equals(p.getStartedYear())){
					r = true;
				}
			} catch (DniNoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return r;
	}

	public boolean isRetired() {
		boolean res = false;
		
		if(LocalDate.now().getYear() >= 30 ^ age > 65 ) {
			res = true;
		}
		switch (contrato) {
		case FULL_TIME: case SCHOOLARSHIP: res = true; break;
		case PARTIAL_TIME: if(LocalDate.now().getYear() >= 33 ^ age > 65 ) {res = true;} break;
		}
			
		return res;
	}
	@Override
	public String toString() {
		try {
			return "Persona [name=" + name + ", surname=" + surname + ", dni=" + this.getDni() + "]";
		} catch (DniNoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not correct format";
	}

}
