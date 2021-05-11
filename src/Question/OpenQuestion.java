package Question;

import javax.swing.JOptionPane;

public class OpenQuestion extends Question {
    String answer;

    public OpenQuestion(String question, String answer) {
        super(question);
        this.answer = answer;
    }

    public static void main(String[] args) {
        OpenQuestion q = new OpenQuestion("Studienort fÜr Medieninformatik", "Friedberg");
        System.out.println(q.ask());
    }

    public boolean ask() {
        String answer = JOptionPane.showInputDialog(null, "Frage: " + question);
        if (answer == null) {
            return false;
        }
        return this.answer.equalsIgnoreCase(answer.trim());
    }

}
