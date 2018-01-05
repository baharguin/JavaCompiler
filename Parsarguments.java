import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parsarguments {

	public int match;


	public Parsarguments(String rawLine,int lineposition, Itype itype){
		
	//	P.l("%%%%%%%%%%%%%%%%%%%%%"+Line.positionnumber);
	//	P.l("RAWLINE---->"+rawLine+"  POSITION---> "+lineposition+"----");
		String[] words=rawLine.split(" ");
		int positionOfreg=0;
		for(int i=lineposition;i<words.length;i++){
		//	P.l("words++++ "+words[i]);
			//handle register number
				 String register="(r)";	// Any Single Character 1
				 String number="(\\d+)";	// Integer Number 1
				// String comma="(,)";

				    Pattern registerregex = Pattern.compile(register+number,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				    Matcher m = registerregex.matcher(words[i]);
				    if (m.find())
				    {
				        String c1=m.group(1);
				        String registernumber=m.group(2);
				      if(positionOfreg==0)
				        {
				        //	P.l(c1+registernumber+"----"+positionOfreg);
				        	itype.rs1=registernumber;
				        	positionOfreg++;
				        
				        }
				        else if(positionOfreg==1){
				        //	P.l(c1+registernumber+"----"+positionOfreg);
				        	itype.rs2=registernumber;
				        	positionOfreg++;
				        }
				      
				      //  P.l("register");
				    //  System.out.print("("+c1.toString()+")"+"("+registernumber.toString()+")"+"\n");
				      
				       
				    }
				  //handle labels
				    String txt="label33";
				    String label="";

				    String re1="((?:[a-z][a-z]+))";	// Word 1
				    String re2="(\\d+)";	// Integer Number 1

				    Pattern pl = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				    Matcher ml = pl.matcher(words[i]);
				    if (ml.find())
				    {
				        String word1=ml.group(1);
				        String int1=ml.group(2);
				        label=word1.concat(int1);
				        //Assembler.labels.put(label, 90);
				        //System.out.print("("+word1.toString()+")"+"("+int1.toString()+")"+"\n");
				        itype.rd=label;
				      
				    }
				    
				    //handle numbers	    
				    else{ 
					   Pattern integeroperand = Pattern.compile(number,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					    Matcher m2 = integeroperand.matcher(words[i]);
					     if (m2.find())
					    {
					        String integOp=m2.group(1);
					      // P.l("integer operand=="+integOp+"---"+words[i]);
					      //  System.out.print("("+integOp.toString()+")"+""+"\n");
					     
					        itype.rd=integOp;
					    }   
					 
					     
					     
				    
			
				    
		
			
			else if(words[i]=="."){}//handle directives
			else {}//handle refrences put label  its linenumber into hash table
		
		
		}}
	}
	/*public int ParsRRR(String rawLine){	

		
	    String re1=".*?";	// Non-greedy match on filler
	    String re2="(r)";	// Any Single Character 1
	    String re3="(\\d+)";	// Integer Number 1
	    String re4=", ";	// Non-greedy match on filler
	    String re5="(r)";	// Any Single Character 2
	    String re6="(\\d+)";	// Integer Number 2
	    String re7=", ";	// Non-greedy match on filler
	    String re9="(r)";	// Any Single Character 3
	    String re10="(\\d+)";	// Integer Number 3   
	    String re33="(\\n)";
	    Pattern rrr = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re9+re10+re33,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher mrrr = rrr.matcher(rawLine);
	    if (mrrr.find())
	    {
	    	match=1;
	        String c1=mrrr.group(1);
	        String int1=mrrr.group(2);
	        String c2=mrrr.group(3);
	        String int2=mrrr.group(4);
	        String c3=mrrr.group(5);
	        String int3=mrrr.group(6);
	        P.l("("+c1.toString()+")"+"("+int1.toString()+")"+"("+c2.toString()+")"+"("+int2.toString()+")"+"("+c3.toString()+")"+"("+int3.toString()+")"+"\n");
	    }	  
	return match;
	}
	
	public int ParsRIR(String rawLine)	 {
		//int match =0;
		String txt="addi r1, 2, r3";

	    String rir1=".*?";	// Non-greedy match on filler
	    String rir2="(r)";	// Any Single Character 1
	    String rir3="(\\d+)";	// Integer Number 1
	    String rir4=", ";	// Non-greedy match on filler
	    String rir5="(\\d+)";	// Integer Number 2
	    String rir6=", ";	// Non-greedy match on filler
	    String rir7="(r)";	// Any Single Character 2
	    String rir8="(\\d+)";	// Integer Number 3
	    String re33="(\\n)";
	    Pattern p = Pattern.compile(rir1+rir2+rir3+rir4+rir5+rir6+rir7+rir8+re33,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(rawLine);
	    if (m.find())
	    {
	    	match=2;
	        String c1=m.group(1);
	        String int1=m.group(2);
	        String int2=m.group(3);
	        String c2=m.group(4);
	        String int3=m.group(5);
	        System.out.print("("+c1.toString()+")"+"("+int1.toString()+")"+"("+int2.toString()+")"+"("+c2.toString()+")"+"("+int3.toString()+")"+"\n");
	    }
		
		
		
		return match;
	}
    
	public int ParsRRI(String rawLine){
	//	int match =0;
		 String txt="addi r1, r2, 8";

		    String re1=".*?";	// Non-greedy match on filler
		    String re2="(r)";	// Any Single Character 1
		    String re3="(\\d+)";	// Integer Number 1
		    String re4=", ";	// Non-greedy match on filler
		    String re5="(r)";	// Any Single Character 2
		    String re6="(\\d+)";	// Integer Number 2
		    String re7=", ";	// Non-greedy match on filler
		    String re8="(\\d+)";	// Integer Number 3
		    String re33="(\\n)";
		    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re33,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(rawLine);
		    if (m.find())
		    {
		    	match=3;
		        String c1=m.group(1);
		        String int1=m.group(2);
		        String c2=m.group(3);
		        String int2=m.group(4);
		        String int3=m.group(5);
		        System.out.print("("+c1.toString()+")"+"("+int1.toString()+")"+"("+c2.toString()+")"+"("+int2.toString()+")"+"("+int3.toString()+")"+"\n");
		    }
		
		return match;
	}

	public int ParsIRR(String rawLine){
		//int match=0;
		String txt="addi 1, r2 ,r8";

	    String re1=".*?";	// Non-greedy match on filler
	    String re11="(\\s+)";	// White Space 1
	    String re2="(\\d+)";	// Integer Number 1
	    String re3=", ";	// Non-greedy match on filler
	    String re4="(r)";	// Any Single Character 1
	    String re5="(\\d+)";	// Integer Number 2
	    String re6=", ";	// Non-greedy match on filler
	    String re7="(r)";	// Any Single Character 2
	    String re8="(\\d+)";	// Integer Number 3
	    String re33="(\\n)";

	    Pattern p = Pattern.compile(re1+re11+re2+re3+re4+re5+re6+re7+re8+re33,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(rawLine);
	    if (m.find())
	    {
	    	match=4;
	        String int1=m.group(1);
	        String c1=m.group(2);
	        String int2=m.group(3);
	        String c2=m.group(4);
	        String int3=m.group(5);
	        System.out.print("("+int1.toString()+")"+"("+c1.toString()+")"+"("+int2.toString()+")"+"("+c2.toString()+")"+"("+int3.toString()+")"+"\n");
	    }
	  
		
		return match;
	}

	public int parsR(String rawline){
		int match=0;
		String txt="jr r1";

	    String re1=".*?";	// Non-greedy match on filler
	    String re2="(\\s+)";	// White Space 1
	    String re3="(r)";	// Any Single Character 1
	    String re4="(\\d+)";	// Integer Number 1
	    String re33="(\\n)";
	    Pattern p = Pattern.compile(re1+re2+re3+re4+re33,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(txt);
	    if (m.find())
	    {
	    	match=5;
	        String ws1=m.group(1);
	        String c1=m.group(2);
	        String int1=m.group(3);
	    //    System.out.print("("+ws1.toString()+")"+"("+c1.toString()+")"+"("+int1.toString()+")"+"\n");
	    }
		
		return match;
	}
	
	
	public int parsLabel(String rawline){
		int match=0;
		String txt="jj label3";

	    String re1=".*?";	// Non-greedy match on filler
	    String re22="(\\s+)";
	    String re2="((?:[a-z][a-z]*[0-9]+[a-z0-9]*))";	// Alphanum 1
	    String re3="(\\n)";
	    Pattern p = Pattern.compile(re1+re22+re2+re3,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(rawline);
	    if (m.find())
	    {
	    	match=6;
	        String alphanum1=m.group(1);
	        System.out.print("("+alphanum1.toString()+")"+"\n");
	    }
		
		return match;
	}*/


}