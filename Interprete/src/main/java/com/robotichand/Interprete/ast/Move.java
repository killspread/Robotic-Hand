package com.robotichand.Interprete.ast;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.robotichand.Interprete.MainProgram;

public class Move implements ASTNode {
	
	private List<String> fingers;
	private ASTNode list_node;
	private ASTNode condition;	
	
	public Move(ASTNode list_node, ASTNode condition) {
		super();
		this.list_node = list_node;
		this.condition = condition;		
	}

	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		// TODO Auto-generated method stub
		fingers = (List<String>) list_node.execute(symbolTable);
		
		try {
			//finger = finger.replace("\"", "");
			if ((condition.execute(symbolTable)).getClass() != Boolean.class) {
				System.out.println("The orientation parameter must be a boolean");
				return null;
			}
			
			for (String finger : fingers) {
				if (finger.length() == 1 && finger.equals(finger.toUpperCase())) {
					switch(finger) {
						case "P":
							
							 if ((boolean)condition.execute(symbolTable) == false) {
								 try {
							            MainProgram.arduino.sendData("PS");
							            Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }else {
								 try {
									 MainProgram.arduino.sendData("PB");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }
							break;
						case "I":
							if ((boolean)condition.execute(symbolTable) == false) {
								 try {
									 MainProgram.arduino.sendData("IS");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }else {
								 try {
									 MainProgram.arduino.sendData("IB");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }
							break;
						case "M":
							if ((boolean)condition.execute(symbolTable) == false) {
								 try {
									 MainProgram.arduino.sendData("MS");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }else {
								 try {
									 MainProgram.arduino.sendData("MB");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }
							break;
						case "A":
							if ((boolean)condition.execute(symbolTable) == false) {
								 try {

									 MainProgram.arduino.sendData("AS");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }else {
								 try {
									 MainProgram.arduino.sendData("AB");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }
							break;
						case "Q":
							if ((boolean)condition.execute(symbolTable) == false) {
								 try {
									 MainProgram.arduino.sendData("QS");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }else {
								 try {
									 MainProgram.arduino.sendData("QB");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }
							break;
						case "T":
							if ((boolean)condition.execute(symbolTable) == false) {
								 try {
									 MainProgram.arduino.sendData("TS");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }else {
								 try {
									 MainProgram.arduino.sendData("TB");
									 Thread.sleep(1500);
							        } catch (Exception ex) {
							            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
							        }
							 }
							break;
						default:
							System.out.println("The finger parameter must be: P, I, M, A, Q, T");
					}
				}
				else {
					System.out.println("First parameter must be an uppercase letter.");
				}
			}
	
		} catch(NullPointerException e) {
			System.out.println("The parameters must be String and Boolean");
		}
		return null;
	}

}
