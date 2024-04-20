package pl.edu.pg.eti.ksg.po.lab1;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.*;

public class Javalab1 {
    public static void main(String[] args) {
        /*
         * Konstrukcja językowa try {} catch (...){} służy do
         * obsługi wyjątków. Kod w bloku try jest monitorowany
         * pod kątem wystąpienia wyjątku bądź wyjątków
         * wspomnianych na początku bloku/bloków catch.
         * Jeżeli gdzieś w bloku try wystąpi wyjątek, to sterowanie
         * zostanie natychmiast przeniesione do bloku catch.
         * Tam powinien znajdować się kod obsługujący wyjątek.
         * Może to być np. wypisanie stosu wywołań na wyjście błędów
         * lub zapisanie wyjątku w logach, lub wyrzucenie (zgłoszenie)
         * innego wyjątku lepiej opisującego sytuacje (można załączyć
         * wyjątek który zainicjował to zdarzenie patrz. Konstruktor
         * klasy java.lang.Exception)
         */
        try {
            Punkt p1 = Punkt.E_X;
            System.out.println(p1);
            Transformacja tr = new Translacja(5, 6);
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();

        try {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr2 = new Skalowanie(5, 4);
            System.out.println(tr2);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();
        try {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tr2 = new Skalowanie(5, 0);
            System.out.println(tr2);
            System.out.println(p1);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();

        try {
            Punkt p1 = new Punkt(3, 8);
            System.out.println(p1);
            Transformacja tr3 = new Obrot(0.5);
            System.out.println(tr3);
            Punkt p2 = tr3.transformuj(p1);
            System.out.println(p2);
            Transformacja trr3 = tr3.getTransformacjaOdwrotna();
            System.out.println(trr3);
            Punkt p3 = trr3.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }

        try {
            Punkt p1 = new Punkt(3, 8);
            //System.out.println(p1);
            Transformacja[] TransList = {new Obrot(0),
                    new Skalowanie(4.0,7.0), new Translacja(3.0,4.0),
                    new TransO(),new TransOY(),new TransOX()};

            ZlozenieTransformacji tr4 = new ZlozenieTransformacji(TransList);
            System.out.println(p1.equals((tr4.getTransformacjaOdwrotna()).transformuj(tr4.transformuj(p1))));
            /*System.out.println(tr4);
            Punkt p2 = tr4.transformuj(p1);
            System.out.println(p2);
            Transformacja trr4 = tr4.getTransformacjaOdwrotna();
            System.out.println(trr4);
            Punkt p3 = trr4.transformuj(p2);
            System.out.println(p3);
            System.out.println(p3.equals(p1));*/
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
    }
}