
package zadatak6;

import java.io.Serializable;

public class Regija implements Serializable {

	private String naziv;
	private int natalitet;
	private int mortalitet;
	private int migracioniSaldo;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.length() < 2) {
			throw new DemografijaException("Naziv ne moze biti null ili kraci od dva znaka.");
		}
		this.naziv = naziv;
	}

	public int getNatalitet() {
		return natalitet;
	}

	public void setNatalitet(int natalitet) {
		if (natalitet <= 0) {
			throw new DemografijaException("Natalitet mora biti veci od nule.");
		}
		this.natalitet = natalitet;
	}

	public int getMortalitet() {
		return mortalitet;
	}

	public void setMortalitet(int mortalitet) {
		if (mortalitet <= 0) {
			throw new DemografijaException("Mortalitet mora biti veci od nule.");
		}
		this.mortalitet = mortalitet;
	}

	public int getMigracioniSaldo() {
		return migracioniSaldo;
	}

	public void setMigracioniSaldo(int migracioniSaldo) {
		this.migracioniSaldo = migracioniSaldo;
	}

	@Override
	public String toString() {
		int promena = natalitet - mortalitet + migracioniSaldo;
		return "Naziv opštine: "+naziv+", natalitet: "+natalitet+", mortalitet: "+mortalitet+", migracioni saldo: "+migracioniSaldo+", promena: "+promena + "\n";
                
	}
	
}
