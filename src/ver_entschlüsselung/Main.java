package ver_entschlüsselung;

import jserver.Board;
import jserver.XSendAdapterEN;
import javax.swing.*;
import plotter.Graphic;
import java.awt.*;

public class Main {

    private final XSendAdapterEN xsend = new XSendAdapterEN();
    private Graphic graphic;

    //GUI Elemente erstellen
    String[] methodSelection = {"Caesar cipher", "Vigenère cipher"};
    JComboBox comboBoxSelection = new JComboBox(methodSelection);
    JTextArea textAreaTextInput = new JTextArea("Text Input");
    JTextField textFieldKeyInput = new JTextField("Key");
    JTextArea textAreaTextOutput = new JTextArea("Text Output");
    JButton buttonEncode = new JButton("Encode");
    JButton buttonDecode = new JButton("Decode");

    //Main Methode - start des Programmes
    public static void main(String[] args) {
        //TODO: OnExit event
        Main main = new Main();
        Logger.INIT();
        main.start();
        for (Exception item : Logger.errors) {
            Logger.Log("Main/Error", item.toString());
        }
    }

    //Startet das Board + Actionlistener
    private void start(){
        createBoard();
        buttonActionListener();
    }

    //Erstellt das BOS - Board + Initial Größe
    private void createBoard() {
        Board board = xsend.getBoard();
        graphic = board.getGraphic();

        board.setSize(800,800);
        xsend.size(27,2);
        createGui();
    }

    //Erstellt das GUI Element neben dem BOS - Board
    public void createGui (){

        //Erstellt Vertikale Box
        Box settings = Box.createVerticalBox();
        Box gui = Box.createVerticalBox();

        //Erstellt Auswahlbox mit Wahl der Verchlüsslung
        settings.add(comboBoxSelection);
        settings.add(Box.createVerticalStrut(10));

        //textAreaTextInput.setMaximumSize( new Dimension(250,0) );
        settings.add(textAreaTextInput);
        settings.add(Box.createVerticalStrut(10));

        //Zeilenumbrüche aktviert + Nur nach ganzen Wörtern
        textAreaTextInput.setLineWrap(true);
        textAreaTextInput.setWrapStyleWord(true);

        //Textfeld zum Eingeben von einem Text
        textFieldKeyInput.setMaximumSize( new Dimension(250, 50));
        settings.add(textFieldKeyInput);
        settings.add(Box.createVerticalStrut(10));

        //Textfeld als Ausgabe für einen Text
        settings.add(textAreaTextOutput);
        settings.add(Box.createVerticalStrut(10));

        //Zeilenumbrüche aktviert + Nur nach ganzen Wörtern
        textAreaTextOutput.setLineWrap(true);
        textAreaTextOutput.setWrapStyleWord(true);

        //Buttons an die GUI hinzufügen
        settings.add(buttonEncode);
        settings.add(buttonDecode);

        //GUI an Graphic anhängen
        gui.add(settings);
        graphic.addEastComponent(gui);
    }

    private void buttonActionListener() {
        buttonEncode.addActionListener(e -> {
            if (comboBoxSelection.getSelectedItem().toString() == "Caesar cipher"){
                CaesarCipher caesar = new CaesarCipher();
                textAreaTextOutput.setText(caesar.Encode(textAreaTextInput.getText(), textFieldKeyInput.getText(), xsend));

            } else if(comboBoxSelection.getSelectedItem().toString() == "Vigenère cipher") {
                VigenereCipher vigenere = new VigenereCipher();
                textAreaTextOutput.setText(vigenere.Encode(textAreaTextInput.getText(), textFieldKeyInput.getText(), xsend));
            }
        });

        buttonDecode.addActionListener(e -> {
            if (comboBoxSelection.getSelectedItem().toString() == "Caesar cipher") {
                CaesarCipher caesar = new CaesarCipher();
                textAreaTextOutput.setText(caesar.Decode(textAreaTextInput.getText(), textFieldKeyInput.getText(), xsend));
            } else if(comboBoxSelection.getSelectedItem().toString() == "Vigenère cipher") {
                VigenereCipher vigenere = new VigenereCipher();
                textAreaTextOutput.setText(vigenere.Decode(textAreaTextInput.getText(), textFieldKeyInput.getText(), xsend));
            }
        });

        //BOS nach BoxSelection anpassen
        comboBoxSelection.addActionListener(e -> {
            Logger.Log("Main/comboBoxSelection/actionPerformed", "Changed to " + comboBoxSelection.getSelectedItem().toString());
            if (comboBoxSelection.getSelectedItem().toString() == "Caesar cipher"){
                xsend.size(27,2);
            } else if(comboBoxSelection.getSelectedItem().toString() == "Vigenère cipher") {
                xsend.size(27,27);
            }
        });
    }
}
