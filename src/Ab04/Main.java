package Ab04;

import Ab04.util.Interaktionsbrett;

public class Main {

    public static void main(String[] args) {
        Interaktionsbrett ib = new Interaktionsbrett();
        PongSpiel p = new PongSpiel(ib);
    }
}
