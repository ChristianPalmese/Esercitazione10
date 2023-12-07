package Modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Gestione {
    private ArrayList<Farmaco> farmaci;
    private ArrayList<Produttore> produttori;
    private ArrayList<String> principiAttivi;

    public Gestione() {
        farmaci = new ArrayList<>();
        produttori = new ArrayList<>();
        principiAttivi = new ArrayList<>();
    }


	public ArrayList<Farmaco> getFarmaci() {
		return farmaci;
	}



	public void setFarmaci(ArrayList<Farmaco> farmaci) {
		this.farmaci = farmaci;
	}



	public ArrayList<Produttore> getProduttori() {
		return produttori;
	}



	public void setProduttori(ArrayList<Produttore> produttori) {
		this.produttori = produttori;
	}



	public ArrayList<String> getPrincipiAttivi() {
		return principiAttivi;
	}



	public void setPrincipiAttivi(ArrayList<String> principiAttivi) {
		this.principiAttivi = principiAttivi;
	}

	
	private Set<String> getEquivalentPrincipiAttivi(Produttore produttore) {
	    Set<String> equivalentPrincipiAttivi = new HashSet<>();

	    for (Farmaco farmaco : farmaci) {
	        if (farmaco.getCodiceProduttore() != produttore.getCodice()) {
	            equivalentPrincipiAttivi.addAll(farmaco.getPrincipiAttivi());
	        }
	    }

	    return equivalentPrincipiAttivi;
	}
	
	
	
	private List<Farmaco> getFarmaciOf(Produttore p){
		List<Farmaco> listaFarmaci= new ArrayList<>();
		for(Farmaco f:farmaci) {
			if(f.getCodiceProduttore()==p.getCodice()) {
				listaFarmaci.add(f);
			}
		}
		return listaFarmaci;
	}
	
	
	

	public String farmacoCaro(String p) {
	    double maxCost = Double.MIN_VALUE;
	    String nomeFarmaco = "";

	    for (Farmaco farmaco : farmaci) {
	        if (farmaco.getPrincipiAttivi().contains(p) && farmaco.getPrezzo() > maxCost) {
	            maxCost = farmaco.getPrezzo();
	            nomeFarmaco = farmaco.getNome();
	        }
	    }

	    return nomeFarmaco;
	}

	public ArrayList<Produttore> esclusivisti(){
		
		ArrayList<Produttore> listaProduttori = new ArrayList<>();
		
		for(Produttore produttore:produttori) {
			boolean isEsclusivista = true;
			List<Farmaco> listaFarmaciDiProduttore=getFarmaciOf(produttore);
			for(Farmaco farmacoProduttore :listaFarmaciDiProduttore) {
				for(Farmaco farmacoGestione:farmaci) {
					if(farmacoProduttore.isEquivalente(farmacoGestione)) {
						isEsclusivista=false;
					}
				}
				if(isEsclusivista==true) {
					listaProduttori.add(produttore);
				}
			}
		}
		return listaProduttori;
	}

	public ArrayList<String> universali(){
		HashMap<String,Set<String>> principiAttiviPerNazione= new HashMap<>();
		for(Farmaco f:farmaci) {
			String nazione=findNazione(f.getCodiceProduttore());
			if(!principiAttiviPerNazione.containsKey(nazione)) {
				principiAttiviPerNazione.put(nazione, new HashSet<>());
			}
			Set<String> principiAttiviDellaNazione=principiAttiviPerNazione.get(nazione);
			principiAttiviDellaNazione.addAll(f.getPrincipiAttivi());
			
		}
		Farmaco farmaco = farmaci.get(0);
		String nazione = findNazione(farmaco.getCodiceProduttore());
		Set<String> primaNazione = new HashSet<>( principiAttiviPerNazione.get(nazione));
		for(Set<String> principiPerNazione :principiAttiviPerNazione.values()) {
			primaNazione.retainAll(principiPerNazione);
		}
		return new ArrayList<>(primaNazione);
	}
	
	private String findNazione(int codiceProduttore) {
		for(Produttore produttore :produttori) {
			if( produttore.getCodice()==codiceProduttore) {
				return produttore.getNazione();
			}
		}
		return null;
	}
	


	@Override
	public String toString() {
		return "Gestione [farmaci=" + farmaci + ", produttori=" + produttori + ", principiAttivi=" + principiAttivi
				+ "]";
	}
    
    
    
}