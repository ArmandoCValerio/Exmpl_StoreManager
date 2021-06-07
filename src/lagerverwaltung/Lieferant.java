package lagerverwaltung;                                                        // Klasse ist Teil des packages "lagerverwaltung"

/**
 * <b>Lieferanten-Klasse</b><br>
 * @author Gruppe3
 */
public class Lieferant                                                          // öffentliche Klasse Lieferant
{
    int     vLieferantID;                                                       // Attribut integer vLieferantID
    String  vLieferantenName;                                                   // Attribut String vLieferantenName
    
    /**
     * Konstruktor um Werte zu initialisieren und Testwerte zu setzen
     * @param kvLieferantenName
     * @param kvLieferantID
     */
    public Lieferant(String kvLieferantenName, int kvLieferantID)               // Konstruktor (gleicher Name wie Klasse)
    {
        vLieferantID        = kvLieferantID;                                    // Übergabe der Attributparameter vLieferantID an die Instanzvariable kvLieferantID
        vLieferantenName    = kvLieferantenName;                                // Übergabe der Attributparameter vLieferantenName an die Instanzvariable kvLieferantenName
        
        DisplayLieferant();                                                     // Methode DisplayLieferant() aufrufen
        }
    
    /**
     * <b>Ausgabe der Werte</b><br>
     */
    private void DisplayLieferant()                                             // Methode DisplayLieferant() ist privat und liefert keinen Rückgabewert; sie deint zur Anzeige der Werte
    {
        System.out.println("LieferantID: " + vLieferantID + "\t" + "LieferantenName: " 
                           + vLieferantenName);                                 // Ausgabe der Attributwerte über System.out.println()
        }
    
    /**
     * <b>Setzen der Attribute</b><br>
     * wobei leere Übergabe und gleiche Werte abgefangen werden
     * @param kvLieferantenName
     * @param kvLieferantID
     */
    public void SetAttribute(String kvLieferantenName, int kvLieferantID)       // Methode SetAttribute() ist öffentlich und liefert keinen Rückgabewert; sie soll Attribute des Lieferanten (ID und Name setzen)
    {
        if  ((kvLieferantenName != vLieferantenName) & (kvLieferantenName != null)) // WENN Instanzvariable kvLieferantenName UNGLEICH dem Attribut vLieferantenName UND kvLieferantenName UNGLEICH "leeres Feld"
             {
             vLieferantenName        = kvLieferantenName;                       // DANN gilt weise Attributparameter vLieferantenName Instanzvariable kvLieferantenName zu
             }           
          
        if  ((kvLieferantID != vLieferantID) & (kvLieferantID != 0))            // WENN Instanzvariable kvLieferantID UNGLEICH dem Attribut vLieferantID UND kvLieferantID UNGLEICH 0
             {
             vLieferantID     = kvLieferantID;                                  // DANN gilt weise Attributparameter vLieferantID Instanzvariable kvLieferantID zu
             }
        
        DisplayLieferant();                                                     // Methode DisplayLieferant() aufrufen
        }
    }
