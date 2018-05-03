import java.time.LocalDateTime;

public class LineInput {
	private LocalDateTime dateTime;
	private String method,site;
	private Boolean isError;
	
	
	public LineInput(String s) {
		
//		this.dateTime = ;
//		this.method = method;
//		this.site = site;
//		this.isError = isError;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Boolean getIsError() {
		return isError;
	}
	public void setIsError(Boolean isError) {
		this.isError = isError;
	}
	
	

}
