
public class Directive {

	public Directive(String[] words) {
		// TODO Auto-generated constructor stub
		
		if( words[0].equals(".align") ) {
			P.l("now im going to do the fucking align shit");
			
		} else if ( words[0].equals(".word") ){
			P.l("now im going to do the fucking word shit");
			
		} else if( words[0].equals(".double") ){
			P.l("now im going to do the fucking double shit");
			
		} else if( words[0].equals(".asciiz") ){
			P.l("now im going to do the fucking asciiz shit");
			
		} else if( words[0].equals(".space") ){
			P.l("now im going to do the fucking word shit");
			
		}
//		int position=0;
//		
//		
//		
//		
//		for(int i=0;i<words.length;i++)
//			if(words[i].charAt(0)=='.'){
//			//	System.out.print(words[i]+"\n");
//				if(position==0)
//			//	words[i] = words[i].replace(".", "");
//				
//				firsttoken=words[i];
//				firsttoken=firsttoken.replace(".", "");
//				System.out.println("FirstToken= "+firsttoken);
//				position++;
//		
//	}
//			else if(position==1){
//				if(words[i].charAt(0)=='"'){
//					//if(rawLine.matches(".*\".*\""))
//						//System.out.println("------------"+rawLine+"----");
//					Pattern p = Pattern.compile("\"([^\"]*)\"");
//					Matcher m = p.matcher(rawLine);
//					while (m.find()) {
//					 // System.out.println(m.group(1));
//					  secondtoken=m.group(1);
//					}
//
//				}
//				else{
//				secondtoken=words[i];
//				}
//				System.out.println("secondtoken= "+secondtoken);
//				position++;
//				
//			}
//				
//			else if(position==2){
//				if(words[i].contains("\n"))
//					System.out.print("**********");
//				thirdtoken=words[i];
//				System.out.println("third token= "+thirdtoken);
//				position++;
//			}
		
		
		
	}

}
