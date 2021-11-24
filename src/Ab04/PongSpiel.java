package Ab04;

import Ab04.util.Interaktionsbrett;

public class PongSpiel {
    private Ball ball;
    private KollisionsDetektion detektor;
    private Spielfeld spielfeld;
    private Interaktionsbrett ib;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    private Spieler user;
    private boolean spielen = false;
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
        user = new Spieler(spielfeld,1000,1000);
        spielerLinks.schlaeger.darstellenFuellung(ib);
        spielerRechts = new Spieler(spielfeld, 900, 300);
        spielerRechts.schlaeger.darstellenFuellung(ib);
        ball = new Ball(4, 2, (new Rechteck(spielerLinks.schlaeger.rechts() + 230, spielfeld.getHoehe() / 2 + 25, 13, 13)));
        ball.darstellen(ib);
        detektor = new KollisionsDetektion(spielfeld, spielerLinks, spielerRechts);
    }

    public void spielen() throws InterruptedException {
        while (true) {
            ib.willTasteninfo(user);
            if (spielen) {
                ib.abwischen();
                ib.neuerText(spielfeld.getSpielflaeche().mitteInX()+25, spielfeld.getSpielflaeche().oben() + 25, (Integer.toString(spielerLinks.punkte)));
                ib.neuerText(spielfeld.getSpielflaeche().mitteInX() + 70, spielfeld.getSpielflaeche().oben() + 25, (Integer.toString(spielerRechts.punkte)));
                spielfeld.darstellen(ib);
                spielerLinks.schlaeger.darstellenFuellung(ib);
                spielerRechts.schlaeger.darstellenFuellung(ib);
                ball.darstellen(ib);
                ib.willTasteninfo(spielerRechts);
                ib.willTasteninfo(spielerLinks);
                ball.bewegen(1);
                detektor.checkBeruehrung(ball);
                detektor.checkBeruehrungMitSchlaeger(ball);
                int pos = detektor.checkAusserhalb(ball);
                if (pos == 1) {
                    spielerRechts.erhöhePunkte();
                    ball = new Ball(4, 2, (new Rechteck(spielerLinks.schlaeger.rechts() + 230, spielfeld.getHoehe() / 2 + 25, 13, 13)));
                    Thread.sleep(1000);
                }
                if (pos == 2) {
                    spielerLinks.erhöhePunkte();
                    ball = new Ball(-4, 2, (new Rechteck(spielerLinks.schlaeger.rechts() + 230, spielfeld.getHoehe() / 2 + 25, 13, 13)));
                    Thread.sleep(1000);
                }

                if (spielerRechts.punkte == 15) {
                    ib.neuerText(spielfeld.getSpielflaeche().mitteInX() + 300, spielfeld.getSpielflaeche().oben() + 300, "Rechts hat gewonnen!");
                    break;
                }
                if (spielerLinks.punkte == 15) {
                    ib.neuerText(spielfeld.getSpielflaeche().mitteInX() - 300, spielfeld.getSpielflaeche().oben() + 300, "Links hat gewonnen!");
                    break;

                }
                Thread.sleep(FPMS);
            }
        }
    }


    public void tasteGedrueckt(String s) {
        switch (s) {
            case "a":
                spielerLinks.aufwaerts();
                break;
            case "y":
                spielerLinks.abwaerts();
                break;
            case "k":
                spielerRechts.aufwaerts();
                break;
            case "m":
                spielerRechts.abwaerts();
                break;
            case "s":
                spielen = true;
                break;
            case "e":
                spielen = false;
                break;
        }
    }

}
