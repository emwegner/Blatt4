package Ab04;

import Ab04.util.Interaktionsbrett;

public class PongSpiel {
    private Ball ball;
    private KollisionsDetektion detektor;
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
        ball = new Ball(4,1,(new Rechteck(spielerLinks.schlaeger.rechts()+250,spielfeld.getHoehe()/2+25,13,13)));
        ball.darstellen(ib);
        detektor = new KollisionsDetektion(spielfeld,spielerLinks,spielerRechts);
    }

    public void spielen() throws InterruptedException {
        while (true) {
            ib.abwischen();
            ib.neuerText(spielfeld.getSpielflaeche().mitteInX()-25,spielfeld.getSpielflaeche().oben()+25,(Integer.toString(spielerLinks.punkte)));
            ib.neuerText(spielfeld.getSpielflaeche().mitteInX()+15,spielfeld.getSpielflaeche().oben()+25,(Integer.toString(spielerRechts.punkte)));
            spielfeld.darstellen(ib);
            spielerLinks.schlaeger.darstellenFuellung(ib);
            spielerRechts.schlaeger.darstellenFuellung(ib);
            ball.darstellen(ib);
            ib.willTasteninfo(spielerRechts);
            ib.willTasteninfo(spielerLinks);
            ball.bewegen(1);
            detektor.checkBeruehrung(ball);
            detektor.checkBeruehrungMitSchlaeger(ball);
            Ballposition pos = detektor.checkAusserhalbDesSpielfeldes(ball);
            if(pos == Ballposition.DRAUSSEN_LINKS) {
                spielerRechts.erhöhePunkte();
                ball = new Ball(4,1,(new Rechteck(spielerLinks.schlaeger.rechts()+250,spielfeld.getHoehe()/2+25,13,13)));
            }
            if(pos == Ballposition.DRAUSSEN_RECHTS) {
                spielerLinks.erhöhePunkte();
                ball = new Ball(4,1,(new Rechteck(spielerLinks.schlaeger.rechts()+250,spielfeld.getHoehe()/2+25,13,13)));
            }

            Thread.sleep(5);
        }
    }

    public void tasteGedrueckt(String s) throws InterruptedException {
        if(s == "a") spielerLinks.aufwaerts();
        if(s == "y") spielerLinks.abwaerts();
        if( s == "Oben") spielerRechts.aufwaerts();
        if(s == "Unten") spielerRechts.abwaerts();
        if(s =="s") spielen();
        if(s== "e"){} //spiel beenden
    }
}
