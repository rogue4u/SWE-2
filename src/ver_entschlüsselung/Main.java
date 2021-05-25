package ver_entschlüsselung;

import jserver.Board;
import jserver.XSendAdapterEN;
import javax.swing.*;
import plotter.Graphic;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private XSendAdapterEN xsend = new XSendAdapterEN();
    private Graphic graphic;

    //GUI
    String[] methodSelection = {"Caesar cipher", "Vigenère cipher"};
    JComboBox comboBoxSelection = new JComboBox(methodSelection);
    JTextArea textAreaTextInput = new JTextArea("Text Input");
    JTextField textFieldKeyInput = new JTextField("Key");
    JTextArea textAreaTextOutput = new JTextArea("Text Output");
    JButton buttonEncode = new JButton("Encode");
    JButton buttonDecode = new JButton("Decode");


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start(){
        createBoard();
        buttonActionListener();
    }

    private void createBoard() {
        Board board = xsend.getBoard();
        graphic = board.getGraphic();

        board.setSize(800,800);
        xsend.size(27,2);
        createGui();
    }

    public void createGui (){
        Box settings = Box.createVerticalBox();
        Box gui = Box.createVerticalBox();

        settings.add(comboBoxSelection);
        settings.add(Box.createVerticalStrut(10));

        //textAreaTextInput.setMaximumSize( new Dimension(250,0) );
        settings.add(textAreaTextInput);
        settings.add(Box.createVerticalStrut(10));

        //Zeilenumbrüche aktviert + Nur nach ganzen Wörtern
        textAreaTextInput.setLineWrap(true);
        textAreaTextInput.setWrapStyleWord(true);

        textFieldKeyInput.setMaximumSize( new Dimension(250, 50));
        settings.add(textFieldKeyInput);
        settings.add(Box.createVerticalStrut(10));

        //textAreaTextOutput.setMaximumSize( new Dimension(250, 0));
        settings.add(textAreaTextOutput);
        settings.add(Box.createVerticalStrut(10));
        //Zeilenumbrüche aktviert + Nur nach ganzen Wörtern
        textAreaTextOutput.setLineWrap(true);
        textAreaTextOutput.setWrapStyleWord(true);

        //Buttons an die GUI hinzufügen
        settings.add(buttonEncode);
        settings.add(buttonDecode);

        gui.add(settings);
        graphic.addEastComponent(gui);
    }

    private void buttonActionListener() {
        buttonEncode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxSelection.getSelectedItem().toString() == "Caesar cipher"){
                    CaesarCipher caesar = new CaesarCipher(textAreaTextInput.getText(), "", textFieldKeyInput.getText());
                    textAreaTextOutput.setText(caesar.Encode(textAreaTextInput.getText(), textFieldKeyInput.getText()));

                } else {
                    VigenereCipher vigenere = new VigenereCipher(textAreaTextInput.getText(), "", textFieldKeyInput.getText());
                    textAreaTextOutput.setText(vigenere.Encode(textAreaTextInput.getText(), textFieldKeyInput.getText()));
                }
            }
        });

        buttonDecode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxSelection.getSelectedItem().toString() == "Caesar cipher"){
                    CaesarCipher caesar = new CaesarCipher(textAreaTextInput.getText(), "", textFieldKeyInput.getText());
                    textAreaTextOutput.setText(caesar.Decode(textAreaTextInput.getText(), textFieldKeyInput.getText()));
                } else {
                    VigenereCipher vigenere = new VigenereCipher(textAreaTextInput.getText(), "", textFieldKeyInput.getText());
                    textAreaTextOutput.setText(vigenere.Decode(textAreaTextInput.getText(), textFieldKeyInput.getText()));
                }
            }
        });

        //BOS nach BoxSelection anpassen
        comboBoxSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxSelection.getSelectedItem().toString() == "Caesar cipher"){
                    xsend.size(27,2);
                } else {
                    xsend.size(27,27);
                }
            }
        });
    }
}
