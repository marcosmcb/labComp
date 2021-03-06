/*

Nomes: Marcos Cavalcante Barboza    RA 408336
       Renato Angelo Poulicer       RA 380024

*/

package ast;


public class MessageSendToVariable extends MessageSend { 

    private Variable myVar;
    private MethodDec myMethod;
    private ExprList myExprList;
    
    
    
    public MessageSendToVariable(Variable myVar, MethodDec myMethod, ExprList myExprList) {
        this.myVar = myVar;
        this.myMethod = myMethod;
        this.myExprList = myExprList;
    }
    
    public Variable getMyVar() {
        return myVar;
    }

    public void setMyVar(Variable myVar) {
        this.myVar = myVar;
    }

    public MethodDec getMyMethod() {
        return myMethod;
    }

    public void setMyMethod(MethodDec myMethod) {
        this.myMethod = myMethod;
    }

    public ExprList getMyExprList() {
        return myExprList;
    }

    public void setMyExprList(ExprList myExprList) {
        this.myExprList = myExprList;
    }
    
    public int getIndexMethod(KraClass myKra, MethodDec myMeth)
    {
        
        for (int i=0; i < myKra.getPublicMethodsAllPrint().size(); i++)
            if(myKra.getPublicMethodsAllPrint().get(i).getName().equals(myMeth.getName()))
                return i;
       
        return -1;
    }
    
	

	

    @Override
    public Type getType() {
        
        if (myMethod != null) return myMethod.getType();
        
        return Type.undefinedType;
    }

    @Override
    public void genC(PW pw, boolean putParenthesis) {
        //System.out.println("jfhjkjhkfjhkdsfhkfdhjkdsfhjkdfsjhk");
        /*
         // k = a.get();
            k = ( (int (*)(_class_A *)) _a->vt[0] )(_a);
        */
       // System.out.print("Olha a pamonhaha");
        KraClass kra = (KraClass) myVar.getType();
        pw.print("( (" + myMethod.getType().getName() + " (*) (_class_" + kra.getCname() + " *");
        
        if(myExprList!=null)
        {
            for(int i=0; i < myExprList.getExprList().size(); i++)
            {
                pw.print(", ");
                pw.print(myExprList.getExprList().get(i).getType().getCname());
            }
        }
        
        pw.print(") ) _"+ myVar.getName()+"->vt[");
        
        pw.print(Integer.toString(getIndexMethod( kra, myMethod )));
        pw.print("]) (_"+myVar.getName());
        
        if(myExprList!=null)
        {
            for(int i = 0; i < myExprList.getExprList().size(); i++)
            {
                pw.print(", ");
                myExprList.getExprList().get(i).genC(pw, putParenthesis);
            }
        }
        
        pw.print(")");
    }
    
    @Override
    public void genKra(PW pw, boolean putParenthesis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}    