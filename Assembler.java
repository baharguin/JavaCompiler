import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;


public class Assembler {
	
	ArrayList<Line> lines = new ArrayList<Line>();
	static int curentbyte = 0;
	static Hashtable labels = new Hashtable();
	Vector refs = new Vector();
	
	public Assembler(String address) throws IOException {
		
		loadLines(address);
		parseLines();
		
		
	/*	Iterator<Line> it = lines.iterator();
		while(it.hasNext())
		{
		    Object obj = it.next();
	//	    P.l(" "+obj.toString());
		}*/
		
	}
	
	//load Lines
	public void loadLines( String address) throws IOException {
		
		String text = null;
		FileReader fr = new FileReader(address);
		BufferedReader br = new BufferedReader(fr);
		
		int num =0;
		
		while ((text = br.readLine()) != null) {
			P.l(text);
			Line thisLine = new Line(text, num++);
			lines.add(thisLine);
		}
	}
	
	public void parseLines(){
		Main.print(lines.size()+"");
		for ( int i = 0; i < lines.size(); i++){
			//Main.print(lines.get(i).toString());
			lines.get(i).parseLine();
			
			
		}
		
	}
	
}
