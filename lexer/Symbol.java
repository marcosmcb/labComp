/*

Nomes: Marcos Cavalcante Barboza    RA 408336
       Renato Angelo Poulicer       RA 380024



*/

package lexer;

public enum Symbol {

    AND("&&"),
    ASSIGN("="),
    BOOLEAN("boolean"),
    BREAK("break"),
    CLASS("class"),
    COLON(":"),
    COMMA(","),
    DIV("/"),
    DOT("."),
    ELSE("else"),
    EOF("~eof"),
    EQ("=="),
    EXTENDS("extends"),
    FALSE("false"),
    FINAL("final"),
    GE(">="),
    GT(">"),
    IDENT("~ident"),
    IF("if"),
    INT("int"),
    LE("<="),
    LEFTCURBRACKET("{"),
    LEFTPAR("("),
    LITERALINT("~number"),
    LITERALSTRING("~literalString"),
    LT("<"),
    MINUS("-"),
    MOCall("~metaobjectCall"),
    MULT("*"),
    NEQ("!="),
    NEW("new"),
    NOT("!"),
    NULL("null"),
    OR("||"),
    PLUS("+"),
    PRIVATE("private"),
    PUBLIC("public"),
    READ("read"),
    RETURN("return"),
    RIGHTCURBRACKET("}"),
    RIGHTPAR(")"),
    SEMICOLON(";"),
    STATIC("static"),
    STRING("String"),
    SUPER("super"),
    THIS("this"),
    TRUE("true"),
    VOID("void"),
    WHILE("while"),
    WRITE("write"),
    WRITELN("writeln");

	Symbol(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return name;
	}
	private String name;
}