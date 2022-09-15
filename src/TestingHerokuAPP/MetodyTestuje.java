package TestingHerokuAPP;

import org.junit.jupiter.api.Test;

public class MetodyTestuje {
    @Test
    public void example(){
        double PoleTrojkataPierwszego = WzorPolaTrojkata(5,7);
        double PoleTrojkataDrugiego = WzorPolaTrojkata(10,9);
        double PoleTrojkataTrzeciego = WzorPolaTrojkata(23,17);

        String wynik = ("Pola trójkątów to: " + PoleTrojkataPierwszego + ", " + PoleTrojkataDrugiego + ", " + PoleTrojkataTrzeciego + ".");
        System.out.println(wynik);
    }
    double WzorPolaTrojkata(double Podstawa, double Wysokosc) {
        double PoleTrojkata = ((Podstawa*Wysokosc)/2);
        return PoleTrojkata;
    }
}
