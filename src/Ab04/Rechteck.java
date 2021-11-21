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
        ib.neuesRechteck(x, y, hoehe, breite);
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
        return y+hoehe;
    }
    public int links() {
        return x;
    }
    public int rechts() {
        return x+breite;
    }
    public int getBreite() {
        return breite;
    }
    public int getHoehe() {
        return hoehe;
    }
    public int mitteInY() {
    return (y+(y+breite) / 2);
    }
    public int mitteInX() {
        return (x+(x+hoehe) / 2);
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
        //Muss evtl noch
        return false;
    }
}
