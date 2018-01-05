import java.util.StringTokenizer;

public class Instruction {

	public Instruction(String rawLine,int position) {
		// TODO Auto-generated constructor stub
		
	
	

		
	//	P.l("rawline====>" + rawLine);
		String[] words = rawLine.split(" ");
		Lexer lex = new Lexer();
		Itype itype=new Itype();
		Operator instruction = null;
		// Operator

		for (int i = 0; i < words.length; i++) {
			//P.l("words : " + words[i]);
			for (int ii = 0; ii < lex.Iinstruction.length; ii++) {
				// P.l("lex.Iinstruction[ii].nameoperator===>"+lex.Iinstruction[ii].nameoperator);
				if (words[i]
						.equalsIgnoreCase(lex.Iinstruction[ii].nameoperator)) {
					// P.l("now I am going to do instruction =>"+lex.Iinstruction[ii].nameoperator);
					//instruction = lex.Iinstruction[ii];
				
					itype.name=lex.Iinstruction[ii].nameoperator;
				  
					//
				  /*  P.l("itype.name   "+itype.name+"itype.r    "+itype.rs1);
					DecodeItype decodei=new DecodeItype();
					decodei.method(itype);*/
					//
					position++;
			
					break;
				}

			}
			for (int ii = 0; ii < lex.Rinstruction.length; ii++) {
				// P.l("lex.Iinstruction[ii].nameoperator===>"+lex.Iinstruction[ii].nameoperator);
				if (words[i]
						.equalsIgnoreCase(lex.Rinstruction[ii].nameoperator)) {
					// P.l("now I am going to do instruction =>"+lex.Rinstruction[ii].nameoperator);
					instruction = lex.Rinstruction[ii];
					P.l("I found rtype");
					//DecodeRtype decode=new	DecodeRtype();
					position++;
					//Line.positionnumber++;
			    	//P.l("positionnumber== "+Line.positionnumber+"linenumber== "+Line.linenumber);
					
					break;
				}}
				for (int ii = 0; ii < lex.Jinstruction.length; ii++) {
					// P.l("lex.Iinstruction[ii].nameoperator===>"+lex.Iinstruction[ii].nameoperator);
					if (words[i]
							.equalsIgnoreCase(lex.Jinstruction[ii].nameoperator)) {
						// P.l("now I am going to do j instruction =>"+lex.Jinstruction[ii].nameoperator);
						instruction = lex.Jinstruction[ii];
						position++;
						P.l("I found jtype");
						break;
					}}
		}

		// Argument
		
		Parsarguments pars = new Parsarguments(rawLine,position,itype);	
		//P.l("___________"+itype.name+"_________"+itype.nameoperator);
		DecodeItype dec=new DecodeItype(itype);
		/*pars.ParsRRR(rawLine);
		pars.ParsRIR(rawLine);
		pars.ParsRRI(rawLine);
		pars.ParsIRR(rawLine);
		pars.parsR(rawLine);
		pars.parsLabel(rawLine);
		//P.l("match"+pars.match);
*/		
		
		
	}

	

	
	
	
	

}
