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
        if(ball.getForm().oben() >= spielfeld.getSpielflaeche().oben()) ball.umkehrenDerBewegungInY();
        if(ball.getForm().unten() >= spielfeld.getSpielflaeche().unten()) ball.umkehrenDerBewegungInY();
    }

    public void checkBeruehrungMitSchlaeger(Ball ball) {
        Random rand = new Random();
        int random = rand.nextInt(10 + 1)+1;
        if(ball.getForm().ueberschneidet(spielerLinks.schlaeger) || ball.getForm().ueberschneidet(spielerRechts.schlaeger)) {
            if(random > 5) ball.umkehrenDerBewegungInY();
            if(random < 5) {
                ball.umkehrenDerBewegungInY();
                ball.umkehrenDerBewegungInX();
            }
        }

    }

    public Ballposition checkAusserhalbDesSpielfeldes(Ball ball) {
        if (ball.getForm().links() < spielfeld.getSpielflaeche().links())
            return Ballposition.DRAUSSEN_LINKS;
        else if (ball.getForm().rechts() > spielfeld.getSpielflaeche().rechts()) {
            return Ballposition.DRAUSSEN_RECHTS; }
        return Ballposition.Drinnen;
    }

}