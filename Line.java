import java.awt.Label;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.IOP.Codec;


public class Line {
	
	public static String rawlineorig;
	public String rawLine;
	public int linenumber;
	public int Memoryposition;
	public String code;
	public String refrence=null;
	public int refrencebit=0;
	public static int positionnumber=0;
	//public static int position=0;
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
		int position=0;
		int currentbyte=0;
		
	            
		rawLine = rawLine.replaceAll("\\t+","");
	//	rawLine = rawLine.replaceAll("\\s+","");
		
		
		 rawlineorig=rawLine.valueOf(rawLine);
		//P.l("rawline-orig--->"+rawlineorig);
		
		
		String[] words=rawLine.split(" ");
		
		
		for(int i=0;i<rawLine.length();i++){
			if(i < rawLine.length() && rawLine.charAt(i) == ':') {
				String label = rawLine.substring(0, i);
				
				Assembler.labels.put(label, new Integer(Assembler.curentbyte));
				//P.l("#####"+Assembler.labels.toString());
			
				rawLine=rawLine.substring(i, rawLine.length());				
				rawLine=rawLine.replace(":","");
				rawLine = rawLine.trim();
				//position++;
				
				//P.l("rawline after taking label: "+rawLine);
				break;
		
			}	}
		
		
		if(words[0].isEmpty())
			{//P.l("-------------------------------------------------------------Empty case");
			Assembler.curentbyte += 4;
			return;}
		//P.l("##########"+words[0]+"\n");
		if (words[0].charAt(0) == '.'){
			position++;
			Directive directive = new Directive(rawLine,position);
			switch(directive.opcode){
			case 0:{
				Assembler.curentbyte=alignment(Assembler.curentbyte, directive.alignment);
				
				break;
			}
			case 1:{
				Assembler.curentbyte=alignment(Assembler.curentbyte, directive.alignment);
				
				//Assembler.curentbyte+=directive.data.length;
				break;
			}
			case 2:{
				Assembler.curentbyte=alignment(Assembler.curentbyte, directive.alignment);
				Assembler.curentbyte+=directive.data;
				
				break;
			}
			}
		}
		
		//	P.l("rawLine==> "+rawLine+"Assembler.curentbyte==>"+Assembler.curentbyte+"\n");
			Assembler.curentbyte += 4;
				//	P.l("---="+rawLine);
					Instruction ins = new Instruction(rawLine,position);	
			//	break;
				
				
			
			
			 
			  
			
		//	Instruction ins = new Instruction(rawLine,position);
			
			
		}
		
		
		
	//	P.l(" "+Showlabel()+"\n");
	//	P.l("current byte"+Assembler.curentbyte);

	
 
		
	
	public String Showlabel() {
		String result="";
		Enumeration<String> e = Assembler.labels.keys();	
		while(e.hasMoreElements()){
			String key=e.nextElement();
			result =result+ "LABEL: "+key+"\n";
		}	
		return result;
	}
	
	private static int alignment(int number, int alignment) {
		int mask = (1 << alignment) - 1;
		if ((number & mask)==0)
			return number;
			else return ((number & ~mask) + (1 << alignment));
	}
}
		
		
		
	

