package Ab04;

import Ab04.util.Interaktionsbrett;

public class Rechteck {
    private int x;
    private int y;
    private int hoehe;
    private int breite;

    public Rechteck(int x, int y, int hoehe,int breite) {
        this.x = x;
        this.y = y;
        this.hoehe = hoehe;
        this.breite = breite;

    }


    public void darstellenRahmen(Interaktionsbrett ib) {
        ib.neuesRechteck(x, y, breite, hoehe);
    }


    public void darstellenFuellung(Interaktionsbrett ib) {
        for (int i = 0; i < hoehe; i++) {
            ib.neueLinie(x,y+i,x+breite,y+i);
        }
    }

    public int oben() {
        return y;
    }
    public int unten() {
        return oben()+hoehe;
    }
    public int links() {
        return x;
    }
    public int rechts() {
        return x+breite;
    }
    public int mitteInY() {
    return (hoehe / 2);
    }
    public int mitteInX() {
        return (breite / 2);
    }

    public void verschiebe(int dx, int dy) {
        x = x+dx;
        y= y+dy;
    }
    public void verschiebeNach(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean ueberschneidet(Rechteck o) {
        return x < o.x + o.breite && x + breite > o.x && y < o.y + o.hoehe && y + hoehe > o.y;
    }


}
