package lc.practicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LineReader {

	private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	
	public String readLine(){
		String toret = "";
		try {
			toret = bufferedReader.readLine();
		} catch (IOException exception) {
			System.out.print( exception.getStackTrace() );
		}
		return toret;
	}
	
}
