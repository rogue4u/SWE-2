package Question;


import javax.swing.*;

import jserver.Board;
import jserver.BoardClickEvent;
import jserver.BoardClickListener;
import jserver.XSendAdapter;
import jserver.XSendAdapterEN;

import plotter.Graphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//  The main class for the quiz simulation
//  version 
//- 0.2    21.03.15  SE first version
//- 0.3    21.04.19  SE include Player
//- 0.4    Nicolas David Benner Übung - Vererbung
//- 0.5    Nicolas David Benner Übung - GUI

public class Quiz implements BoardClickListener {

    private XSendAdapterEN xsend = new XSendAdapterEN();
    private int size = 30;
    private int pos = 0;
    private Questioner questioner = new Questioner();
    private Player player;

    //GUI erweitern
    private Graphic graphic;
    JLabel fragenLabel = new JLabel();
    JLabel richtigLabel = new JLabel();
    JTextField vornameLabel = new JTextField("");
    JTextField nachnameLabel = new JTextField("");
    JButton okButton = new JButton("Ok");

    public static void main(String[] args) {
        Quiz simu = new Quiz();
        simu.start();
    }

    private void start() {
        createPlayer("joy", "mama");
        System.out.println("Quiz-Simulator V0.3 April 2021");
        setUpBoard();
        createBoardPlayer();
        createBoardPlayerStats();
        buttonActionListener();
    }

    private void createPlayer(String playerVorname, String playerNachname){
        player = new Player (playerVorname, playerNachname);
    }

    private void setUpBoard() {
        Board board = xsend.getBoard();
        graphic = board.getGraphic();

        board.addClickListener(this);
        board.setSize(800, 150);
        xsend.size(size, 1);
        xsend.colors(XSendAdapter.RED);
        xsend.color2(0, 0, XSendAdapter.YELLOW);
    }

    //Ester Board Player Input (Vorname + Nachname + OK-Button)
    public void createBoardPlayer() {
        Box playerZeile = Box.createHorizontalBox();
        Box all = Box.createVerticalBox();

        playerZeile.add(new JLabel("Vorname: "));
        playerZeile.add(vornameLabel);
        playerZeile.add(Box.createHorizontalStrut(16));
        playerZeile.add(new JLabel("Nachname: "));
        playerZeile.add(nachnameLabel);
        playerZeile.add(Box.createHorizontalGlue());
        all.add(playerZeile);
        playerZeile.add(okButton);

        graphic.addSouthComponent(all);
    }

	private void buttonActionListener() {
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			    player = new Player(vornameLabel.getText(),nachnameLabel.getText());
				System.out.println(player.toString());
				System.out.println("Ok-button Funktioniert!");
			}
		});
	}

    //Erstelle Player Statistiken (Anzahl der Fragen + richtige)
    public void createBoardPlayerStats() {
        Box playerStats = Box.createVerticalBox();
        Box allStats = Box.createVerticalBox();

        playerStats.add(fragenLabel);
        playerStats.add(Box.createVerticalStrut(10));
        playerStats.add(richtigLabel);

        playerStats.add(Box.createHorizontalGlue());
        allStats.add(playerStats);

        graphic.addEastComponent(allStats);

        updateBoardPlayerStats();
    }

    //Player Statistiken Aktualisieren
    public void updateBoardPlayerStats(){
        fragenLabel.setText("Fragen: " + (player.getRight() + player.getWrong()));
        richtigLabel.setText("Richtig: " + player.getRight());
    }


    @Override
    public void boardClick(BoardClickEvent info) {
        if (info.getX() == pos) {
            if (questioner.askQuestion()) {
                xsend.statusText("Prima, richtig geantwortet");
                JOptionPane.showMessageDialog(null, "Richtig", "Bewertung", JOptionPane.INFORMATION_MESSAGE);
                xsend.color2(pos, 0, XSendAdapter.GREEN);
                ++pos;
                xsend.color2(pos, 0, XSendAdapter.YELLOW);
                player.incRight();
            } else {
                xsend.statusText("Leider falsch");
                JOptionPane.showMessageDialog(null, "Leider Falsch", "Bewertung", JOptionPane.ERROR_MESSAGE);
                player.incWrong();
            }
        } else {
            //System.out.println("Falsch gedrückt");
            xsend.statusText("Bitte Klicken sie auf die aktuelle Frage");
        }

            // Alte Status anzeige.
            //String message = String.format("%s %.1f%% richtige Antworten", player.getName(), player.getCorrectPercent());
            //xsend.statusText(message);

        updateBoardPlayerStats();
    }

}
