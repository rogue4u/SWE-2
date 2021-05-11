package Question;

public class Questioner {

    Question[] questions;

    public Questioner() {
        //Question (Parent) Array, bestend aus Fragen YesNoQuestion & Questioner & Questiongenerator
        questions = new Question[]{
                new OpenQuestion("Studienort für Medieninformatik", "Friedberg"),
                new OpenQuestion("Referenz auf das Objekt, in dem wir uns befinden", "this"),
                new OpenQuestion("Referenz auf das Eltern-Objekt, in dem wir uns befinden", "super"),
                new OpenQuestion("Wie viele Module hat man im ersten Semester ?", "5"),
                new OpenQuestion("Wie viele Semester ist die RegelStudienzeit ?", "6"),
                new OpenQuestion("Die Quadratwurzel von 1257862341867023478", "42"),
                QuestionGenerator.getAdd(),
                QuestionGenerator.getAdd(),
                QuestionGenerator.getAdd(),
                new YesNoQuestion("Java ist OOP", true),
                new YesNoQuestion("Eine Klasse kann nur eine Elternklasse erweitern", true),
                new YesNoQuestion("Java ist älter als C", false),
                new YesNoQuestion("Audiovisuelle Medien 1 gibt 9 CrP", true),
                new YesNoQuestion("Mediengestaltung 1: Bewegtbild und Ton gibt 6 CrP", false),
        };
    }

    public boolean askQuestion() {
        boolean result;
        // if Statement gelöscht (überflüssig?)
        Question q = questions[(int) (Math.random() * questions.length)];
        result = q.ask();
        return result;
    }
}
