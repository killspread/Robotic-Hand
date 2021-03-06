package com.robotichand.Interprete.ast;

import java.util.List;
import java.util.Map;

public class IfCond implements ASTNode {
	private ASTNode condition;
	private List<ASTNode> body;
	private List<ASTNode> elseIfConds;
	private List<List<ASTNode>> elseIfBodies;
	private List<ASTNode> elseBody;
	
	public IfCond(ASTNode condition, List<ASTNode> body, List<ASTNode> elseIfConds, List<List<ASTNode>> elseIfBodies, List<ASTNode> elseBody) {
		super();
		this.condition = condition;
		this.body = body;
		this.elseIfConds = elseIfConds;
		this.elseIfBodies = elseIfBodies;
		this.elseBody = elseBody;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		// TODO Auto-generated method stub
		try {
			if ((condition.execute(symbolTable)).getClass() != Boolean.class) {
			System.out.println("The if condition must be a boolean");
			return null;
			}
			if ((boolean)condition.execute(symbolTable)) {
				for (ASTNode n : body) {
					n.execute(symbolTable);
				}
			}
			else {
				int cont = 0;
				boolean cumple = false;
				for (ASTNode c : elseIfConds) {
					if ((c.execute(symbolTable)).getClass() != Boolean.class) {
						System.out.println("The else if condition must be a boolean");
						return null;
					}
					if ((boolean)c.execute(symbolTable)) {
						cumple = true;
						break;
					}
					cont++;
				}
				if (cumple) {
					List<ASTNode> elseIfBodyCumple = elseIfBodies.get(cont);
					for (ASTNode n : elseIfBodyCumple) {
						n.execute(symbolTable);
					}
				}
				else {
					for(ASTNode n : elseBody) {
						n.execute(symbolTable);
					}
				}
				
				}
			}catch(NullPointerException e) {
				System.out.println("The if or else if condition must be a boolean");
			}
		
		return null;
	}

}
