package Modello;

import java.util.Set;

public class Farmaco {
    private int codice;
    private String nome;
    private int codiceProduttore;
    private double prezzo;
    private Set<String> principiAttivi;

    public Farmaco(int codice, String nome, int codiceProduttore, double prezzo, Set<String> principiAttivi) {
        this.codice = codice;
        this.nome = nome;
        this.codiceProduttore = codiceProduttore;
        this.prezzo = prezzo;
        this.principiAttivi = principiAttivi;
    }
    
    public boolean isEquivalente(Farmaco farmaco) {
    	return farmaco.getPrincipiAttivi().equals(this.principiAttivi) && farmaco.getCodice()!=this.codice;
    }
    
    

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public int getCodiceProduttore() {
        return codiceProduttore;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Set<String> getPrincipiAttivi() {
        return principiAttivi;
    }



	@Override
	public String toString() {
		return "Farmaco [codice=" + codice + ", nome=" + nome + ", codiceProduttore=" + codiceProduttore + ", prezzo="
				+ prezzo + ", principiAttivi=" + principiAttivi + "]";
	}
    
}