package Question;

import javax.swing.JOptionPane;

public class YesNoQuestion extends Question {
    boolean answer;

    public YesNoQuestion(String question, boolean answer) {
        super(question);
        this.answer = answer;
    }

    public boolean ask() {
        int ret = JOptionPane.showConfirmDialog(null, question);
        if (answer & ret == JOptionPane.OK_OPTION) {
            return true;
        } else return !answer & ret == JOptionPane.NO_OPTION;
    }

}
