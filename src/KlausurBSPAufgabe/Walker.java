package KlausurBSPAufgabe;

import jserver.XSendAdapter;

abstract public class Walker {

    int x=5;
    int y=5;


    abstract public void geheSchritt();


    void zeige(XSendAdapter xsend) {

        xsend.farbe2( x, y, XSendAdapter.RED);

    }


    void loesche(XSendAdapter xsend) {

        xsend.farbe2( x, y, XSendAdapter.WHITE);

    }

}

