package Question;

// A player for the quiz
// version 
//1.0    21.04.19  SE first version
//1.0a   21.04.19  SE set fields private

import plotter.Graphic;

import javax.swing.*;

public class Player {
	private final String firstname;
	private final String lastname;
	private int right;
	private int wrong;
	
	public Player(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void incRight() {
		++right;
	}
	
	public void incWrong() {
		++wrong;
	}

	double getCorrectPercent() {
		return (double) right / (right + wrong ) * 100.;
	}

	public Object getName() {
		return firstname + " "  + lastname;
	}

	public int getRight() {
		return right;
	}

	public int getWrong() {
		return wrong;
	}

}
