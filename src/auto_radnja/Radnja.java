package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju sa automobilskim gumama.
 * 
 * Ima osnovne operacije dodavanja, pretrage i vracanja svih automobilskih guma u radnji.
 * 
 * @author nikolinatomasevic
 * @version 0.1.0
 *
 */
public interface Radnja {

	/**
	 * Dodaje gumu u radnju.
	 * 
	 * Dodavanje se vrsi u slucaju da guma nije null i u slucaju da vec ne postoji u radnji.
	 * 
	 * @param a automobilska guma koju treba dodati u radnju
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji
	 * @see auto_radnja.gume.AutoGuma
	 */
    void dodajGumu(AutoGuma a);

    /**
     * Pronalazi i vraca listu sa svim gumama u radnji koje zadovoljavaju ulov pretrage.
     * 
     * Bitno je uneti pun naziv marke i modela gume i voditi racuna o velikim i malim slovima.
     * 
     * @param markaModel marka i model gume
     * @return 
     * <ul>
	 * <li>null - u slucaju da je uneti naziv marke i modela null</li>
	 * <li>Lista koja sadrzi sve gume koje odgovaraju uslovu pretrage - u slucaju da nije null</li>
	 * </ul>
	 * @see auto_radnja.gume.AutoGuma
	 * @see java.util.List
     */
    List<AutoGuma> pronadjiGumu(String markaModel);

    /**
     * Vraca sve gume iz radnje.
     * 
     * @return Lista koja sadrzi sve gume u radnji
     * @see auto_radnja.gume.AutoGuma
     * @see java.util.List
     */
    List<AutoGuma> vratiSveGume();
}
