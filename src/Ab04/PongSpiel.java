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

        }
    }
}
