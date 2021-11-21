package Ab04;

import Ab04.util.Interaktionsbrett;

public class PongSpiel {
    private Spielfeld spielfeld;
    private Interaktionsbrett ib;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    private final int FPMS = 17;

    public PongSpiel(Interaktionsbrett ib) {
        this.ib = ib;
        ib.willTasteninfo(this);
        startAufstellung();
    }

    private void startAufstellung() {
        spielfeld = new Spielfeld();
        spielfeld.darstellen(ib);
        spielerLinks = new Spieler(spielfeld, 100, 300);
        spielerLinks.schlaeger.darstellenFuellung(ib);
        spielerRechts = new Spieler(spielfeld, 900, 300);
        spielerRechts.schlaeger.darstellenFuellung(ib);
    }

    public void spielen() {
        while (true) {
            ib.abwischen();
            spielfeld.darstellen(ib);
            spielerLinks.schlaeger.darstellenFuellung(ib);
            spielerRechts.schlaeger.darstellenFuellung(ib);
            System.currentTimeMillis();
        }
    }

    public void tasteGedrueckt(String s) {
        if(s == "a") spielerLinks.aufwaerts();
        if(s == "y") spielerLinks.abwaerts();
        if( s == "UP") spielerRechts.aufwaerts();
        if(s == "DOWN") spielerRechts.abwaerts();
        if(s =="s") spielen();
        if(s== "e"){} //spiel beenden
    }
}
