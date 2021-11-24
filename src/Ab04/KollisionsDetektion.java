package Ab04;

import java.util.Random;

public class KollisionsDetektion {
    Spielfeld spielfeld;
    Spieler spielerLinks;
    Spieler spielerRechts;

    public KollisionsDetektion(Spielfeld spielfeld, Spieler spielerLinks, Spieler spielerRechts) {
        this.spielerLinks = spielerLinks;
        this.spielerRechts = spielerRechts;
        this.spielfeld = spielfeld;
    }

    public void checkBeruehrung(Ball ball) {
       if(ball.getForm().oben() < spielfeld.getSpielflaeche().oben()
       || ball.getForm().unten() > spielfeld.getSpielflaeche().unten()){
            ball.umkehrenDerBewegungInY();
        }
    }

    public void checkBeruehrungMitSchlaeger(Ball ball) {
        if(ball.getForm().ueberschneidet(spielerLinks.schlaeger) || ball.getForm().ueberschneidet(spielerRechts.schlaeger)) {
            Random rand = new Random();
            int random = rand.nextInt(10 + 1)+1;
            if(random > 5) {
                ball.umkehrenDerBewegungInX();
            }
            if(random < 5) {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }

    }
    public int checkAusserhalb(Ball ball) {
        if (ball.getForm().links() < spielfeld.getSpielflaeche().links()) return 1;
        if (ball.getForm().rechts() > spielfeld.getSpielflaeche().rechts()) return 2;
        return 0;
    }


}