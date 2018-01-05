import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Directive {
	
	public int opcode = 0;
	public int alignment = 1;
	public int data = 0;
	

	public Directive(String rawLine,int position) {
		// TODO Auto-generated constructor stub
		String[] words=rawLine.split(" ");
		if( words[0].equals(".align") ) {
			Line.positionnumber++;
			//P.l("now im going to do   align ");
			opcode=0;
			String p1="(\\.align\\s)";
			String allignNumber="(\\d+)";
			//alignment=words[1;
			 Pattern p = Pattern.compile(p1+allignNumber,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			    Matcher m = p.matcher(rawLine);
			    if (m.find()){
			    	//alignment=allignNumber;
			    	alignment=Tointeger(allignNumber);
			    	position++;
			    	Line.positionnumber++;
			    	//P.l("positionnumber== "+Line.positionnumber+"linenumber== "+Line.linenumber);
			    	}
			
			
		} else if ( words[0].equals(".word") ){
			//P.l("now im going to do   word "+rawLine);
			Line.positionnumber++;
	    	//P.l("positionnumber== "+Line.positionnumber+"linenumber== "+Line.linenumber);
			position++;
			opcode = 1;
			alignment = 2;
			String p1="(\\.word\\s)";
			String int1="(\\d+)";	// Integer Number 1
			 String re5="(,)";	// Any Single Character 2
			    String re6="(\\s+)";	// White Space 2
			    String int2="(\\d+)";	// Integer Number 2
			    String re8="(,)";	// Any Single Character 3
			    String re9="(\\s+)";	// White Space 3
			    String int3="(\\d+)";	// Integer Number 3
			    String re11="(,)";	// Any Single Character 4
			    String re12="( )";	// Any Single Character 5
			    String int4="([-+]\\d+)";	// Integer Number 1
			 Pattern p = Pattern.compile(p1+int1+re5+re6+int2+re8+re9+int3+re11+re12+int4,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			    Matcher m = p.matcher(rawLine);
			    if (m.find()){
			    //	P.l(".word found******************");
			    	}
			
		} else if( words[0].equals(".double") ){
			position++;
			//P.l("now im going to do   double ");
			
		// I am not sure about this part ask	
		} else if( words[0].equals(".asciiz") ){
			//P.l("------------------posituon before"+position);
			position++;
			Line.positionnumber++;
	    	//P.l("positionnumber== "+Line.positionnumber+"linenumber== "+Line.linenumber);
			//P.l("-------------------posituon after"+position);
			opcode = 3;
		//	P.l("now im going to do   asciiz ");
			String txt=".asciiz \"hello there\"";

		    String re1="(\\.)";	// Any Single Character 1
		    String re2="((?:[a-z][a-z]+))";	// Word 1
		    String re3="( )";	// Any Single Character 2
		    String re4="(\".*?\")";	// Double Quote String 1

		    Pattern p = Pattern.compile(re1+re2+re3+re4,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(txt);
		    if (m.find())
		    {
		    	position++;
		    	Line.positionnumber++;
		    	//P.l("positionnumber== "+Line.positionnumber+"linenumber== "+Line.linenumber);
		        String c1=m.group(1);
		        String word1=m.group(2);
		        String c2=m.group(3);
		        String string1=m.group(4);
		   //     System.out.print("("+c1.toString()+")"+"("+word1.toString()+")"+"("+c2.toString()+")"+"("+string1.toString()+")"+"\n");
		    	data=string1.length();
		    }
		  
		
		} else if( words[0].equals(".space") ){
			position++;
			Line.positionnumber++;
	    //	P.l("positionnumber== "+Line.positionnumber+"linenumber== "+Line.linenumber);
		//	P.l("now im going to do   space ");
			
		}

		
		
		
	}

		public static int Tointeger(String s)
		{
			//P.l("-------------");
			int position = 0;
			int flag=0;

			// handle negation
			if(s.charAt(0) == '-') {
				position += 1;
				flag=1;;
				
			}
			int base = 10; 
		   if (s.charAt(position) == '0' && position < s.length() - 1) {
				if (s.charAt(position + 1) == 'X') {
					base = 16; 
					position += 2;
				} 
			}

			int integerNumber = 0;
			for (; position < s.length(); position++) {
				int convert = Character.digit(s.charAt(position), base);
				integerNumber = base * integerNumber + convert;
			}
			if(flag==0)
			return  integerNumber;
			else
				return -integerNumber;
		}
		
	}


