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
        xsend.size(0,0);
        createGui();
    }

    public void createGui (){
        Box Gui = Box.createVerticalBox();
        Box Settings = Box.createVerticalBox();

        Gui.add(comboBoxSelection);
        Gui.add(Box.createVerticalStrut(10));

        //textAreaTextInput.setMaximumSize( new Dimension(250,0) );
        Gui.add(textAreaTextInput);
        Gui.add(Box.createVerticalStrut(10));
        //Zeilenumbrüche aktviert + Nur nach ganzen Wörtern
        textAreaTextInput.setLineWrap(true);
        textAreaTextInput.setWrapStyleWord(true);

        textFieldKeyInput.setMaximumSize( new Dimension(250, 50));
        Gui.add(textFieldKeyInput);
        Gui.add(Box.createVerticalStrut(10));

        //textAreaTextOutput.setMaximumSize( new Dimension(250, 0));
        Gui.add(textAreaTextOutput);
        Gui.add(Box.createVerticalStrut(10));
        //Zeilenumbrüche aktviert + Nur nach ganzen Wörtern
        textAreaTextOutput.setLineWrap(true);
        textAreaTextOutput.setWrapStyleWord(true);

        Gui.add(buttonEncode);
        Gui.add(buttonDecode);

        Settings.add(Gui);
        graphic.addEastComponent(Settings);


    }

    private void buttonActionListener() {
        buttonEncode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cipherType = comboBoxSelection.getSelectedItem().toString();
                if (cipherType == "Caesar cipher"){
                    xsend.size(27,2);
                } else {
                    xsend.size(27,27);
                }
                System.out.println("Encode Button Funktioniert!");
            }
        });

        buttonDecode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cipherType = comboBoxSelection.getSelectedItem().toString();
                if (cipherType == "Caesar cipher"){
                    xsend.size(27,2);
                } else {
                    xsend.size(27,27);
                }
                System.out.println("Decode Button Funktioniert!");
            }
        });
    }



}
