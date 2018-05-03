import java.util.List;

public interface Cotizable {
	 String imprimeHistorial();
	 public default boolean canWork(List<Boolean> lista) {
		boolean r = false;
		for(boolean b: lista) {
			if(b==true) {
				r=true;
			}else {
				r=false;
			}
		}
		return r;
		 
	 }

}
