import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ListaSpesa l=new ListaSpesa();
        l.add(new Alimentare("acqua",1,10, LocalDate.of(2023,5,18), true, "Italia"));
        l.add(new Alimentare("acqua",1,10, LocalDate.of(2023,5,18), true, "Italia"));
        l.add(new Alimentare("acqua",1,10, LocalDate.of(2023,5,18), false, "Marocco"));
        l.add(new Alimentare("polpette",1,10, LocalDate.of(2023,5,18), true, "Italia"));
        l.add(new NonAlimentare("botte", 10, 1, "legno"));
        l.add(new NonAlimentare("forbici", 10, 1, "metallo"));
        l.add(new NonAlimentare("quaderno", 100, 1, "carta"));
        l.add(new NonAlimentare("coso di carta", 100, 1, "carta"));
        l.add(new NonAlimentare("uranio", 100, 1, "uranio"));
        //System.out.println(l);
        System.out.println("Scontrino");
        System.out.println(l.getScontrino(true));
        System.out.println("In scadenza");
        System.out.println(l.getInScadenza());
        System.out.println("Non riciclabili");
        System.out.println(l.getNonRiciclabili());
        System.out.println("Prodotti italiani");
        System.out.println(l.getProdottiItaliani());
        /*System.out.println("\n\n\n\n In scadenza");
        System.out.println(l.getInScadenzaV2()[0].size());
        System.out.println(l.getInScadenzaV2()[1].size());
        */
    }    
}