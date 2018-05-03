
public class Puesto<T> {
	private String ubicacion;
	private T elemeto;

	public T getElemento() {
		return elemeto;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Object getElemeto() {
		return elemeto;
	}
	public void setElemeto(T elemeto) {
		this.elemeto = elemeto;
	}
	
	
}
