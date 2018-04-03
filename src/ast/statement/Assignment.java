package ast.statement;
import ast.context.Context;
import ast.expression.Expression;
import ast.expression.Literal;

public class Assignment extends Statement {
	Identifier identifier;
	Expression expression;
	
	public Assignment(Identifier identifier, Expression expression)
	{
		this.identifier = identifier;
		this.expression = expression;
	}
	
	public void execute(Context c) {
		Expression e = expression.evaluate(c);
		if (e instanceof Literal && c.contains(identifier))
		{
			c.assign(identifier, (Literal)e );
		} else
		{
			//error
		}
		
		if (next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a =  identifier + ":=" + expression + ";\n";
		
		if (next != null)
			a += next;
		return a;
	}
}
