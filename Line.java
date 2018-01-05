import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.IOP.Codec;


public class Line {
	
	public String rawLine;
	public int linenumber;
	public int Memoryposition;
	public String code;
	public String refrence=null;
	public int refrencebit=0;
	
	//public String firsttoken;
	//public String secondtoken;
	//public String thirdtoken;
	//public String Lexer; 
	
	public Line( String line, int num ) throws IOException{
		
		rawLine = line;
		linenumber = num;
	}
	
	@Override
	public String toString() {
		return "Line [rawLine=" + rawLine + ", linenumber=" + linenumber + "]";
	}

	public void parseLine (){
		rawLine = rawLine.replace("\t", "");
		String[] words=rawLine.split(" ");
		
		P.l(words[0]);
		if (words[0].charAt(0) == '.'){
			
			Directive dir = new Directive(words);
			
		} else {
			
			for(int i=0;i<rawLine.length();i++){
				if(i < rawLine.length() && rawLine.charAt(i) == ':') {
					String label_name = rawLine.substring(0, i).trim().toUpperCase();
					Assembler.labels.put(label_name, new Integer(Assembler.curentbyte));
					
					rawLine=rawLine.substring(i, rawLine.length());
					rawLine=rawLine.replace(":", "");
				//	P.l(rawLine);
					
				}
			}
			Instruction ins = new Instruction(rawLine);
			
			
		}
		
		
		
		

		
	}
}
		
		
		
	

