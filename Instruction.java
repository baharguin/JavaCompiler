
public class Instruction {

	public Instruction(String rawLine) {
		// TODO Auto-generated constructor stub
		
		P.l("rawline====>"+rawLine);
		String[] words=rawLine.split(" ");
    	Lexer lex=new Lexer();
		Operator instruction = null;
		for(int i = 0; i < words.length; i++) {
			if(words[0].equalsIgnoreCase(lex.Iinstruction[0].nameoperator )){
				P.l("now I am going to do instruction bullshit");
			//	instr = instr_ops[i];
				//break;
			}
		}
		
		
		
	}

}
