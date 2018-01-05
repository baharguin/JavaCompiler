
public class Lexer {
	private  Jtype[] Jinstruction = {
		
		new Jtype("j", 2),
		new Jtype("jal", 3),
		
		
	};
public  Itype[] Iinstruction = {
		
	new Itype("beqz",4),
	new Itype("bnez",5),
    new Itype("addi",8),
	new Itype("addui",9),
	new Itype("subi",10),
	new Itype("subui",11),
	new Itype("andi",12),
	new Itype("ori"	,13),
	new Itype("xori",14),
	new Itype("lhi",15),
	new Itype("trap",	17),
    new Itype("jr",	18),
	new Itype("jalr",19),
	new Itype("slli",	20),
	new Itype("srli",	22),
    new Itype("srai",	23),
	new Itype("seqi",	24),
	new Itype("snei",	25),
	new Itype("slti",	26),
	new Itype("sgti",	27),
	new Itype("slei",	28),
	new Itype("sgei",	29),
	new Itype("lb",	32),
	new Itype("lh",	33),
	new Itype("lw",	35),
	new Itype("lbu",36),
	new Itype("lhu",37),
	new Itype("lf",	38),
	new Itype("ld",	39),
	new Itype("sb",	40),
	new Itype("sh",	41),
	new Itype("sw",	43),
	new Itype("sf",	46),
	new Itype("sd",	47),
		
	};
public  Rtype[] Rinstruction = {
	
	new Rtype("nop",0,0),
	new Rtype("sll",	0,	4),
	new Rtype("srl",	0,	6),
	new Rtype("sra",	0,	7),
	new Rtype("add",	0,	32),
	new Rtype("addu",	0,	33),
	new Rtype("sub",	0,	34),
	new Rtype("subu",	0,	35),
	new Rtype("and"	,0,	36),
	new Rtype("or",	0,	37),
	new Rtype("xor",	0,	38),
	new Rtype("seq",	0,	40),
	new Rtype("sne"	,0,	41),
	new Rtype("slt",	0,	42),
	new Rtype("sgt",	0,	43),
	new Rtype("sle",	0,	44),
	new Rtype("sge",	0,	45),
	new Rtype("	movf",	0,	50),
	new Rtype("movd",	0,	51),
	new Rtype("movfp2i",0,52),
	new Rtype("movi2fp",	0,	53),
	new Rtype("addf",	1,	0),
	new Rtype("subf",	1,	1),
	new Rtype("multf",	1,	2),
	new Rtype("divf",	1,	3),
	new Rtype("addd",	1,	4),
	new Rtype("subd",	1,	5),
	new Rtype("multd",	1,	6),
	new Rtype("divd",	1,	7),
	new Rtype("cvtf2d",	1,	8),
	new Rtype("cvtf2i",	1,	9),
	new Rtype("cvtd2f",	1,	10),
	new Rtype("cvtd2i",	1,	11),
	new Rtype("cvti2f",	1,	12),
	new Rtype("cvti2d",	1,	13),
	new Rtype("mult",	1,	14),
	new Rtype("div",	1,	15),
	new Rtype("multu",	1,	22),
	new Rtype("divu",	1,	23),


	
};

}
