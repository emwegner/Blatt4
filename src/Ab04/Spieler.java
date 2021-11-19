package Ab04;


public class Spieler {
    Spielfeld spielfeld;
    Rechteck schlaeger;
    int punkte;

    public Spieler(Spielfeld spielfeld,int x, int y) {
        this.spielfeld = spielfeld;
        schlaeger = new Rechteck(x,y, spielfeld.getHoehe()/10,spielfeld.getBreite()/100 );
    }

    public void aufwaerts() {

    }
    public void abwaerts() {

    }

    public void erhöhePunkte() {
        punkte += 1;
    }
    public void setzePunkteZurueck() {
        punkte = 0;
    }
}
