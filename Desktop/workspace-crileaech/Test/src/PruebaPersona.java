import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.omg.Messaging.SyncScopeHelper;

public class PruebaPersona {

	public static void main(String[] args) throws DniNoValidoException {
		// TODO Auto-generated method stub
		LocalDate date =LocalDate.of(1998, 01, 1);
		EmpleadoPublico p0 = new EmpleadoPublico("Pepa","Rodriguez","45645646Z",12,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p1 = new EmpleadoPublico("Ana","Rodriguez","45645649Z",25,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p2 = new EmpleadoPublico("Fernando","Rodriguez","45645647Z",69,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p3 =new EmpleadoPublico("Alba","Rodriguez","42345649Z",58,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p4 =new EmpleadoPublico("Pepe","Rodriguez","45895645Z",27,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p5 =new EmpleadoPublico("Eva","Rodriguez","45690648Z",26,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p6 =new EmpleadoPublico("Ana","Rodriguez","45646624Z",63,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p7 =new EmpleadoPublico("Carmen","Rodriguez","45645641Z",55,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p8 =new EmpleadoPublico("Luisa","Rodriguez","47645664Z",45,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p9 =new EmpleadoPublico("Rocio","Rodriguez","43648564Z",84,date, 2060, Contrato.FULL_TIME, null, null);
		EmpleadoPublico p10 =new EmpleadoPublico("Carlos","Rodriguez","42764564Z",62,date, 2060, Contrato.FULL_TIME, null, null);
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		listaPersona.add(p0);
		listaPersona.add(p1);
		listaPersona.add(p2);
		listaPersona.add(p3);
		listaPersona.add(p4);
		listaPersona.add(p5);
		listaPersona.add(p6);
		listaPersona.add(p7);
		listaPersona.add(p8);
		listaPersona.add(p9);
		listaPersona.add(p10);
		
		
		
		
		GestorPersonas gp = new GestorPersonas().getInstance();
		gp.setLp(listaPersona);
		
		gp.PrintSatus((Persona p) -> {return p.getAge() > 18 ;} );
		
		gp.PrintSatus((Persona p) -> {return p.getAge() > 18 && p.getAge() < 40 ;} );
		
		gp.proccessPerson((Persona p)-> p.getAge() > 65, (Persona p)-> p.imprimeHistorial());
		
		
		//ver a que metodos hace referencia cuando lo llamo 
		//cotizable mopstrará los metodos propios d este
		
		Cotizable c = new EmpleadoPublico(null, null, null, null, date, null, null, null, null);
		Persona p = new EmpleadoPublico(null, null, null, null, date, null, null, null, null);
		EmpleadoPublico ep = new EmpleadoPublico(null, null, null, null, date, null, null, null, null);
		//Call the method TreeSet
		
		TreeSet<Persona> ts = new TreeSet<Persona>();
		ts = metodoVarargs();
		
		
		for (Persona per: listaPersona){
			System.out.println(per.toString());
		}
		
		//exampleStream
		
		
		List<String> myList = Arrays.asList("a1","a2","a3","b1","b2","b3","c1","c2","c3");
		
		myList.stream()
			.filter(s->s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
		
		//Retired more than 65
		
		List<Persona> myList1 = new ArrayList<>();
		myList1.stream()
		.filter((Persona)->p.isRetired())
		.sorted()
		.forEach(System.out::println);
		
		//trying the new methods
		System.out.println(gp.AverageAge());
		
		//create the list 
	
			for(int i=0;i<10000;i++) {
				listaPersona.addAll(i, listaPersona);
				System.out.println("Show me :" +listaPersona);
			}
		//create Parallel Stream 
		listaPersona
				.parallelStream()
				.filter((Persona ) ->p.getAge()>40)
				.forEach(System.out::println);
		//create Stream 
		listaPersona.stream()
						.filter((Persona) ->p.getAge()>40)
						.forEach(System.out::println);
		//Compare performance between them
//				
//		Instant start = Instant.now();
//		Thread.sleep(63553);
//		Instant end = Instant.now();
//		System.out.println(Duration.between(start, end));
		long startTime = System.currentTimeMillis();
		long stopTime =System.currentTimeMillis();
		long elapsedTime = stopTime -startTime;
		System.out.println(elapsedTime);
				
		//Calculate number of threads
		
		//Compare adding sort
		
		//Trying StringBuilder
		StringBuilder sb = new StringBuilder("");
				
			
		
		
	}
	
	
	//Metodos estaticos 
	public static TreeSet<Persona> metodoVarargs(Persona... listaParametros){
		TreeSet<Persona> ts = new TreeSet<Persona> ();
		for (Persona per: listaParametros) {
			ts.add(per);
			System.out.println(per);
		}
		//Sorted the list in ascendent way 
		Iterator<Persona> itr = ts.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		return ts;
		
	}
	public static List<Persona> convertArrayToList(Persona[] p){
		Persona[] p1 = new Persona[]{};
		return Arrays.stream(p1).collect(Collectors.toList()); // Java 8 
		// return Arrays.asList(p1);//Java 7 
				
	}
	
	public void expedientProcess() throws ExpedientNotProccessException, Exception {
		LocalDate date =LocalDate.of(1998, 01, 1);
		try (EmpleadoPublico ep = new EmpleadoPublico("Juan","Rodriguez","456564Z",12,date, 2060, Contrato.FULL_TIME, null, null)){
			System.out.println("Show me the public employee " +ep);
		}catch(ExpedientNotProccessException e) {
			e.printStackTrace();
		}
	}
	
}


