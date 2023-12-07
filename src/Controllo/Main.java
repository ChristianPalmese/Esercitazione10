package Controllo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Modello.Farmaco;
import Modello.Gestione;
import Modello.Produttore;



public class Main {
    public static void main(String[] args) {
        Gestione gestione = new Gestione();

   
        gestione.getProduttori().add(new Produttore(1, "produttore 1", "Italia"));
        gestione.getProduttori().add(new Produttore(2, "produttore 2", "Francia"));
        gestione.getProduttori().add(new Produttore(3, "produttore 3", "Inghilterra"));
        gestione.getProduttori().add(new Produttore(4, "produttore 4", "Italia"));

      
        gestione.getPrincipiAttivi().add("principioA");
        gestione.getPrincipiAttivi().add("principioB");
        gestione.getPrincipiAttivi().add("principioC");
        gestione.getPrincipiAttivi().add("principioD");
        gestione.getPrincipiAttivi().add("principioE");
        gestione.getPrincipiAttivi().add("principioF");

        
        Set<String> principiFarmaco1 = new HashSet<>(Arrays.asList("principioA", "principioB", "principioC"));
        gestione.getFarmaci().add(new Farmaco(1, "farmaco 1", 1, 1.5, principiFarmaco1));

        Set<String> principiFarmaco2 = new HashSet<>(Arrays.asList("principioC", "principioD"));
        gestione.getFarmaci().add(new Farmaco(2, "farmaco 2", 1, 1, principiFarmaco2));

        Set<String> principiFarmaco3 = new HashSet<>(Arrays.asList("principioC", "principioD"));
        gestione.getFarmaci().add(new Farmaco(3, "farmaco 3", 2, 2, principiFarmaco3));

        Set<String> principiFarmaco4 = new HashSet<>(Arrays.asList("principioC", "principioE"));
        gestione.getFarmaci().add(new Farmaco(4, "farmaco 4", 3, 3, principiFarmaco4));

        Set<String> principiFarmaco5 = new HashSet<>(Arrays.asList("principioA", "principioF"));
        gestione.getFarmaci().add(new Farmaco(5, "farmaco 5", 3, 2.5, principiFarmaco5));

        Set<String> principiFarmaco6 = new HashSet<>(Arrays.asList("principioA", "principioF"));
        gestione.getFarmaci().add(new Farmaco(6, "farmaco 6", 4, 0.5, principiFarmaco6));

     
        String farmacoPiuCaroPrincipioC = gestione.farmacoCaro("principioC");
        System.out.println("Farmaco più costoso con principio attivo C: " + farmacoPiuCaroPrincipioC);

        ArrayList<Produttore> produttoriEsclusivisti = gestione.esclusivisti();
        System.out.println("Produttori con farmaci non equivalenti: " + produttoriEsclusivisti);

        ArrayList<String> principiAttiviUniversali = gestione.universali();
        System.out.println("Principi attivi usati da produttori di ogni nazione: " + principiAttiviUniversali);
    }
}

