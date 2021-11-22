package Ab04;

import Ab04.util.Interaktionsbrett;

import java.awt.*;

public class Spielfeld {
    private final Dimension Spielfeldgroesse = new Dimension(900,
            600);
    private int breite = 900;
    private int hoehe = 600;
    private Rechteck spielflaeche;

    public Spielfeld() {
        spielflaeche = new Rechteck(50,50,900,600);
        }

    public void darstellen(Interaktionsbrett ib) {
    spielflaeche.darstellenRahmen(ib);
    ib.neueLinie(spielflaeche.mitteInX()-1,spielflaeche.oben()+600, spielflaeche.mitteInX()+1, spielflaeche.oben());
    }
    public int getHoehe() {
        return hoehe;
    }
    public int getBreite() {
        return breite;
    }
    public Rechteck getSpielflaeche() {
        return spielflaeche;
    }
}