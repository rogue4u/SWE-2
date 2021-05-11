package BoardPainter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import jserver.Board;
import jserver.BoardClickEvent;
import jserver.BoardClickListener;
import jserver.ColorNames;
import jserver.XSendAdapter;
import plotter.Graphic;

// Demo GUI mit BoSym
// 1.0  03.05.2021    Erste Version mit Kommentar
// 1.1  04.05.2021    Mit Menues

class BoardPainter implements BoardClickListener {
    private Board board;
    private Graphic graphic;
    private XSendAdapter xsend;
    private int farben[] = { XSendAdapter.GREEN, XSendAdapter.YELLOW, XSendAdapter.RED, XSendAdapter.BLACK,
            XSendAdapter.BLUE };
    private int groesse = 12;
    private int zeichenFarbe = XSendAdapter.BLUE;
    private int startFarbe = XSendAdapter.ORANGE;
    private JButton faerbeButton = new JButton("F�rben");
    private JButton loescheButton = new JButton("Reset");
    private JButton zufallButton = new JButton("Zufall");
    private JTextField indexField = new JTextField(12);

    public static void main(String[] args) {
        BoardPainter e = new BoardPainter();
        e.starten();
    }

    void starten() {
        setUpBoard();
        zeichneFaerbeButton();
        zeichneFarbAuswahl();
        setzeActionListener();

        graphic.pack();
        graphic.repaint();
    }

    private void setUpBoard() {
        board = new Board();
        board.addClickListener(this);
        board.setSize(600, 600);
        graphic = board.getGraphic();
        graphic.setTitle("Board painter SoSe 2021");
        xsend = new XSendAdapter(board);
        xsend.groesse(groesse, groesse);

        xsend.farben(startFarbe);
        xsend.flaeche(XSendAdapter.BISQUE);
    }

    private void zeichneFaerbeButton() {
        Box zeile1 = Box.createHorizontalBox();
        Box zeile2 = Box.createHorizontalBox();
        Box alles = Box.createVerticalBox();
        Dimension d = new Dimension(120, 30);
        indexField.setMaximumSize(d);

        zeile1.add(new JLabel("Pos:"));
        zeile1.add(indexField);
        zeile1.add(faerbeButton);
        zeile1.add(Box.createHorizontalStrut(16));
        zeile1.add(loescheButton);
        zeile1.add(Box.createHorizontalGlue());

        zeile2.add(zufallButton);
        zeile2.add(Box.createHorizontalGlue());

        alles.add(zeile1);
        alles.add(zeile2);
        graphic.addSouthComponent(alles);

        addMenues();
    }

    private void addMenues() {
        graphic.removeMenu("Hilfe");

        JMenu hilfeMenu = new JMenu("BP-Hilfe");
        graphic.addExternMenu(hilfeMenu);

        JMenuItem ueber = new JMenuItem("Über");
        ueber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(graphic, "Testanwendung Version 0.0", "�ber",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        hilfeMenu.add(ueber);

        JMenuItem hilfe = new JMenuItem("Hilfe");
        hilfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(graphic, "Noch keine Hilfe", "Hilfe",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        hilfeMenu.add(hilfe);

        // noch ein Test ohne Funktionalit�t
        JMenu test = new JMenu( "Test");
        hilfeMenu.add( test  );
        test.add( new JMenuItem( "test 2"));
        test.add( new JMenuItem( "test 3"));
        test.add( new JMenu( "test 4"));

    }

    private void zeichneFarbAuswahl() {
        graphic.addEastComponent(new JLabel("Click-Farben"));
        ButtonGroup group = new ButtonGroup();
        for (int f = 0; f < farben.length; f++) {
            JRadioButton farbWaehler = new JRadioButton(ColorNames.getName(farben[f]));
            farbWaehler.setActionCommand("" + farben[f]);
            group.add(farbWaehler);
            farbWaehler.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zeichenFarbe = Integer.parseInt(e.getActionCommand());
                    xsend.statusText("Farbe gewechselt: " + Integer.toHexString(zeichenFarbe));
                }
            });
            graphic.addEastComponent(farbWaehler);
        }
    }

    private void setzeActionListener() {
        loescheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xsend.farben(startFarbe);
            }
        });

        zufallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < groesse * groesse; i++) {
                    xsend.farbe(i, (int) (Math.random() * 256 * 256 * 256));
                }
            }
        });

        faerbeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
                String text = indexField.getText();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(graphic, "Bitte Wert eintragen", "Leeres Feld",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int index = Integer.parseInt(text);
                xsend.farbe(index, zeichenFarbe);
            }
        });
    }

    @Override
    public void boardClick(BoardClickEvent info) {
        System.out.println(info);
        xsend.farbe2(info.getX(), info.getY(), zeichenFarbe);
    }
}