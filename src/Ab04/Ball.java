package Ab04;

import Ab04.util.Interaktionsbrett;

public class Ball {
    private Rechteck form;
    private int bewegungInXProFrame;
    private int bewegungInYProFrame;


    public Ball(int bewegungInXProFrame, int bewegungInYProFrame, Rechteck form) {
        this.bewegungInXProFrame = bewegungInXProFrame;
        this.bewegungInYProFrame = bewegungInYProFrame;
        this.form = form;
    }

    public void bewegen(int AnzahlFrames) {
        form.verschiebeNach((form.oben()+bewegungInXProFrame)*AnzahlFrames,(form.oben()+bewegungInYProFrame)*AnzahlFrames);
    }

    public void umkehrenDerBewegungInX() {
        bewegungInXProFrame = bewegungInXProFrame * (-1);
    }
    public void umkehrenDerBewegungInY() {
        bewegungInYProFrame = bewegungInYProFrame * (-1);
    }

    public Rechteck getForm() {
        return form;
    }
    public void erhoeheGeschwindigkeit() {
        bewegungInXProFrame += 1;
        bewegungInYProFrame += 1;
    }

    public void darstellen(Interaktionsbrett ib) {
        this.form.darstellenFuellung(ib);
    }
}