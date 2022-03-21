package auto_radnja.gume;

/**
 * Predstavlja automobilsku gumu.
 * 
 * @author nikolinatomasevic
 * @version 0.1.0
 *
 */
public class AutoGuma {

	/**
	 * Marka i model gume.
	 * 
	 * Ima pocetnu vrednost null.
	 */
    private String markaModel = null;
    
    /**
     * Precnik gume.
     * 
     * Ima pocetnu vrednost -1.
     */
    private int precnik = -1;
    
    /**
     * Sirina gume.
     * 
     * Ima pocetnu vrednost -1.
     */
    private int sirina = -1;
    
    /**
     * Visina gume.
     * 
     * Ima pocetnu vrednost -1.
     */
    private int visina = -1;

    public AutoGuma() {
    }

    /**
     * Postavlja sve atribute gume (markaModel, precnik, sirina, visina) na unete vrednosti.
     * 
     * @param markaModel nova marka i model gume
     * @param precnik novi precnik gume
     * @param sirina nova sirina gume
     * @param visina nova visina gume
     */
    public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
        super();
        setMarkaModel(markaModel);
        setPrecnik(precnik);
        setSirina(sirina);
        setVisina(visina);
    }

    /**
     * Vraca marku i model gume.
     * 
     * @return marka i model gume kao String
     */
    public String getMarkaModel() {
        return markaModel;
    }

    /**
     * Postavlja novu vrednost za atribut marka i model gume.
     * 
     * Postalja se vrednost atributa ako uneti naziv marke i modela nije null i sadrzi vise od 2 znaka.
     * 
     * @param markaModel nova marka gume
     * @throws java.lang.NullPointerException u slucaju da je uneti naziv marke i modela null
     * @throws java.lang.IllegalArgumentException u slucaju da uneti naziv marke i modela sadrzi manje od 3 znaka
     */
    public void setMarkaModel(String markaModel) {
        if (markaModel == null) {
            throw new NullPointerException("Morate uneti marku i model");
        }
        if (markaModel.length() < 3) {
            throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
        }
        this.markaModel = markaModel;
    }

    /**
     * Vraca precnik gume.
     * 
     * @return precnik gume kao integer
     */
    public int getPrecnik() {
        return precnik;
    }

    /**
     * Postavlja novu vrednost za atribut precnik gume.
     * 
     * Postavlja se vrednost atributa ako je uneta vrednost za precnik veca od 12 i manja od 23.
     * 
     * @param precnik novi precnik gume
     * @throws java.lang.IllegalArgumentException u slucaju da je uneta vrednost za precnik manja od 13 i veca od 22
     */
    public void setPrecnik(int precnik) {
        if (precnik < 13 || precnik > 22) {
            throw new IllegalArgumentException("Precnik van opsega");
        }
        this.precnik = precnik;
    }

    /**
     * Vraca sirinu gume.
     * 
     * @return sirina gume kao integer
     */
    public int getSirina() {
        return sirina;
    }

    /**
     * Postavlja novu vrednost za atribut sirina gume.
     * 
     * Postavlja se vrednost atributa ako je uneta vrednost za sirinu veca od 134 i manja od 356.
     * 
     * @param sirina nova sirina gume
     * @throws java.lang.IllegalArgumentException u slucaju da je uneta vrednost za sirinu manja od 135 i veca od 355
     */
    public void setSirina(int sirina) {
        if (sirina < 135 || sirina > 355) {
            throw new IllegalArgumentException("Sirina van opsega");
        }
        this.sirina = sirina;
    }

    /**
     * Vraca visinu gume.
     * 
     * @return visina gume kao integer
     */
    public int getVisina() {
        return visina;
    }

    /**
     * Postavlja novu vrednost za atribut visina gume.
     * 
     * Postavlja se vrednost atributa ako je uneta vrednost za visinu veca od 24 i manja od 96.
     * 
     * @param visina nova visina gume
     * @throws java.lang.IllegalArgumentException u slucaju da je uneta vrednost za visinu manja od 25 ili veca od 95
     */
    public void setVisina(int visina) {
        if (visina < 25 || visina > 95) {
            throw new IllegalArgumentException("Visina van opsega");
        }
        this.visina = visina;
    }

    /**
     * Vraca String sa svim podacima o automobilskoj gumi.
     * 
     * @return String sa svim podacima o automobilskoj gumi
     */
    @Override
    public String toString() {
        return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik
                + ", sirina=" + sirina + ", visina=" + visina + "]";
    }

    /**
	 * Poredi dve gume po svim atributima (markaModel, precnik, sirina, visina).
	 * 
	 * @return
	 * <ul>
	 * <li>true - u slucaju da svi atributi obe gume imaju iste vrednosti</li>
	 * <li>false - u slucaju da nemaju</li>
	 * </ul>
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AutoGuma other = (AutoGuma) obj;
        if (markaModel == null) {
            if (other.markaModel != null) {
                return false;
            }
        } else if (!markaModel.equals(other.markaModel)) {
            return false;
        }
        if (precnik != other.precnik) {
            return false;
        }
        if (sirina != other.sirina) {
            return false;
        }
        if (visina != other.visina) {
            return false;
        }
        return true;
    }
}

