import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestorPersonas {

	private static GestorPersonas gp = null;
	private static List<Persona> lp;
	public GestorPersonas() {
		
	}
	public GestorPersonas getInstance() {
		if(gp == null) {
			gp = new GestorPersonas();
		}
		return gp;
	}
	
	//average age Java 7 
//	public static Integer AverageAge() {
//		
//		Integer p = 0,suma = 0,cont = 0;
//		for(Persona p1 : lp) {
//			suma += p1.getAge();
//			cont++;
//		}
//		p = suma/cont;
//		return p;
//	}
	//java 8
	//1 - Calculate average age
	
	public static Double AverageAge() {
		return  lp.stream().mapToInt(p->p.getAge()).average().getAsDouble();
	}
	//2- Change average age to lambda
	public static Double AverageAgeLambda() {
		return  lp.stream().mapToInt(p->
		{System.out.println("Map: " +p);
		return p.getAge();}).average().getAsDouble();
	}
	//Filtrar edad media de personas jubiladas
	public static Double AverageAgeRetired() {
		return lp.stream().filter((Persona p)->p.isRetired()).mapToInt(p->p.getAge()).average().getAsDouble();
	}
	

	//Mostrar Lista persona cuya edad esta por debajo de la media
	public static List<Persona> AboveAverageAge() {
		return lp.stream().filter(p->p.getAge() > AverageAge()).collect(Collectors.toList());
	}
	//Mostrar Lista persona cuya edad esta por encima de la media
	public static List<Persona> BelowAverageAge(){
		return lp.stream().filter(p->p.getAge() < AverageAge()).collect(Collectors.toList());
	}
	//Stream supplier people can retired
//	public static List<Persona> canRetired(){
//		Supplier<Stream<Persona>> streamSupplier = ()  -> ;
//		return streamSupplier;
//	}
	//creamos un collect transform to set 
	public static Set<Persona> transformToSet(){
		return lp.stream().collect(Collectors.toSet());
	}
	//Agrupar primera letra del apellido
	public Map<Object, List<Persona>> FirstLetter(){
		Map<Object, List<String>> firstLetter = lp.stream().map(Persona::getSurname).collect(Collectors.groupingBy(p->p.charAt(0)));
		return FirstLetter();
	}
	// Order alphabetic  do it latter
//	public List<Persona> alphabeticsOrder(){
//		
//	}
	//Merge all employee who start for the first letter of surname
	
//	public Collector<Persona,StringJoiner,String> (){
//		Collector<Persona,StringJoiner,String> personaDniCollector = Collector.of(()->new StringJoiner);
//	}
//	
	//look for the oldest person not retired
	public List<Persona> oldestNotRetired(){
		List<Persona> per =new ArrayList<>();
		per.add(lp.get(0));
		per.stream()
				.filter(p->p.isRetired())
				.reduce((p1,p2) -> p1.getAge() > p2.getAge() ? p1:p2);
				
		 return null;
	}

	// look for all people not retired and flat map 
	//Create list 1000 
	
	
	
	
	public static void addWorker(Persona p) throws DniDuplicadoException{
		for(Persona per: lp) {
			try {
				if(per.getDni().equals(p.getDni())) {
					throw new DniDuplicadoException("El DNI de la persona esta duplicado");
				}
			} catch (DniNoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lp.add(p);
	}
	public void PrintSatus(Predicate<Persona> checker){
		for(Persona per: lp) {
			if(checker.test(per)) {
				System.out.println(per + "");
			}
		}
		System.out.println();
	}
	public static GestorPersonas getGp() {
		return gp;
	}
	public void setGp(GestorPersonas gp) {
		GestorPersonas.gp = gp;
	}
	public static List<Persona> getLp() {
		return lp;
	}
	public static void setLp(List<Persona> lp) {
		GestorPersonas.lp = lp;
	}
	public  void proccessPerson(Predicate<Persona> p, Consumer<Persona> c) {
		//admite predicado
		//admite consumer
		for (Persona per: lp) {
			if(p.test(per)) {
				c.accept(per);
			}
		}
	}

}
