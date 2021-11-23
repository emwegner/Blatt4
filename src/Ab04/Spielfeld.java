package Ab04;

import Ab04.util.Interaktionsbrett;

import java.awt.*;

public class Spielfeld {
    private final Dimension Spielfeldgroesse = new Dimension(900,
            600);
    private int margin = 50;
    private int breite = 900;
    private int hoehe = 600;
    private Rechteck spielflaeche;

    public Spielfeld() {
        spielflaeche = new Rechteck(margin,margin,900,600);
        }

    public void darstellen(Interaktionsbrett ib) {
    spielflaeche.darstellenRahmen(ib);
    ib.neueLinie(spielflaeche.mitteInX()-1,spielflaeche.unten(), spielflaeche.mitteInX()+1, spielflaeche.oben());
    }
    public int getHoehe() {
        return hoehe;
    }
    public int rand() {return margin;}
    public int getBreite() {
        return breite;
    }
    public Rechteck getSpielflaeche() {
        return spielflaeche;
    }
}