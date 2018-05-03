import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.ws.Response;


public class OpenFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Path path = Paths.get("timelog.log");

		boolean pathExists = Files.exists(path.toAbsolutePath(), new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
		System.out.println(pathExists);
		try {
			Files.lines(path).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Files.exists(path) && Files.isReadable(path) && Files.isWritable(path) && Files.isExecutable(path)){
			System.out.println("The file check the permisson read, write and execute");
		}else {
			System.out.println("The file cannot be read, write and execute");
		}
		//Read entrance
		try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) 
		{
			  long numOfLines = lines.count();
			  System.out.println(numOfLines);
			  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//Check family error
		try  
		{
			  System.out.println(Files.lines(path).filter(l->l.contains("(4")
					  || l.contains("(5")).count());
			  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		//Check the date more visited  
		FileTime fileTime;
		try {
		    fileTime = Files.getLastModifiedTime(path);
		    System.out.println(fileTime);
		} catch (IOException e) {
		    System.err.println("Cannot get the last modified time - " + e);
		}	
		//Checked date +
	}

}
