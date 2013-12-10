package lc.practicas;

public class Program {
	private static Program instance;
	private static boolean isAlive;
	private LineReader lineReader;
	private Parser parser;
	
	private Program() {
		this.isAlive = true;
		this.lineReader = new LineReader();
		this.parser = new Parser();
	}

	public static Program getInstance() {
		if (null == instance) {
			instance = new Program();
		}
		return instance;
	}
	
	public void exec(){
		
		while( isAlive ){
			readLine();
		}
		
	}
	
	public void readLine() {
		System.out.print(" ? ");
		String line = lineReader.readLine();
		parser.parse();
	}
	
	public void endProgram(){
		this.isAlive = false;
	}
	
}
