package Modello;

public class Produttore {
    private int codice;
    private String nome;
    private String nazione;

    public Produttore(int codice, String nome, String nazione) {
        this.codice = codice;
        this.nome = nome;
        this.nazione = nazione;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getNazione() {
        return nazione;
    }

	@Override
	public String toString() {
		return "Produttore [codice=" + codice + ", nome=" + nome + ", nazione=" + nazione + "]";
	}
    
    
    
}
