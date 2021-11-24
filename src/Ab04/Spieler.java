package Ab04;


public class Spieler {
    Spielfeld spielfeld;
    Rechteck schlaeger;
    int punkte;

    public Spieler(Spielfeld spielfeld, int x, int y) {
        this.spielfeld = spielfeld;
        schlaeger = new Rechteck(x, y, spielfeld.getHoehe() / 10, spielfeld.getBreite() / 100);
    }

    public void aufwaerts() {
        if(schlaeger.oben() > spielfeld.getSpielflaeche().oben()) {
            schlaeger.verschiebeNach(schlaeger.links(), schlaeger.oben()-5);
        }

    }
    public void abwaerts() {
        if(schlaeger.unten() < spielfeld.getSpielflaeche().unten()- spielfeld.rand()) {
            schlaeger.verschiebeNach(schlaeger.links(), schlaeger.oben()+5);
        }
    }

    public void erhöhePunkte() {
        punkte += 1;
    }

    public void setzePunkteZurueck() {
        punkte = 0;
    }
}
