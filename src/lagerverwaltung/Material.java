package lagerverwaltung;                                                        // Klasse ist Teil des packages "lagerverwaltung"
/**
 * <b>Material-Klasse</b><br>
 * @author Gruppe3
 */
public class Material                                                           // öffentliche Klasse Material
{
    int    vMaterialId;                                                         // Attribut integer vMaterialID
    int    vLieferantId;                                                        // Attribut integer vLieferantID
    String vBezeichung;                                                         // Attribut String vBezeichung
    int    vMindestMenge;                                                       // Attribut integer vMindestMenge
    int    vMengenAufschlag;                                                    // Attribut integer vMengenaufschlag
    int    vLagerMenge;                                                         // Attribut integer vLagerMenge
    int    vBestellteMenge;

    /**
     * Konstruktor um Werte zu initialisieren Testwerte zu setzen
     * @param kvBezeichung
     * @param kvMaterialId
     * @param kvLagerMenge
     * @param kvMindestMenge
     * @param kvLieferantenID
     * @param kvMengenAufschlag
     */
    public Material(String kvBezeichung, int kvMaterialId, int kvLagerMenge, 
                    int kvMindestMenge, int kvLieferantenId,int kvMengenAufschlag)  // Konstruktor (gleicher Name wie Klasse)
    {                                                                       
        vBezeichung     = kvBezeichung;                                         // Übergabe der Attributparameter vBezeichung an die Instanzvariable kvBezeichung
        vMaterialId     = kvMaterialId;                                         // Übergabe der Attributparameter vMaterialID an die Instanzvariable kvMaterialID
        vLagerMenge     = kvLagerMenge;                                         // Übergabe der Attributparameter vLagerMenge an die Instanzvariable kvLagerMenge
        vMindestMenge   = kvMindestMenge;                                       // Übergabe der Attributparameter vMindestMenge an die Instanzvariable kvMindestMenge
        vLieferantId    = kvLieferantenId;                                      // Übergabe der Attributparameter vLieferantID an die Instanzvariable kvLieferantenID
        vMengenAufschlag= kvMengenAufschlag;                                    // Übergabe der Attributparameter vMengenAufschlag an die Instanzvariable kvMengenAufschlag
        vBestellteMenge = 0;
        DisplayMaterial();                                                      // Methode DisplayMaterial() aufrufen
        }
    
    /**
     * <b>Ausgabe der Werte</b><br>
     */
    private void DisplayMaterial()                                              // Methode DisplayMaterial() ist privat und liefert keinen Rückgabewert; sie deint zur Anzeige der Werte
    {
        System.out.println("MaterialID:" + vMaterialId + "\t" + "Bezeichnung: " 
                           + vBezeichung + "\t" + "LagerMenge: " + vLagerMenge + 
                           "\t" + "MindestMenge: " + vMindestMenge + "\t" + 
                           "Lieferant: " + vLieferantId);                       // Ausgabe der Attributwerte über System.out.println()
    
        }

    /**
     * <b>MaterialAnfordern und Mengenberechnen</b><br> 
     * (PruefeLagerMenge)(PruefeMinMenge)
     * @param vAnforderungsMenge
     * @return
     */
    public int mGetMaterial(int vAnforderungsMenge)                             //Methode mGetMaterial ist öffentlich und hat einen integer Rückgabewert vMenge; vAnforderungsMenge ist als formaler Parameter nur dieser Methode bekannt
    {
        int vBestellMenge = 0;                                                  // Attribut integer vBestellMenge; der Wert 0 wird zugewiesen
        
        if  (vAnforderungsMenge <= vLagerMenge)                                 // WENN vAnforderungsMenge KLEINER/GLEICH dem Attribut vLagerMenge
            {
                //komplette AnforderungsMenge bedient! und
                //Neue LagerMenge berechnen
                vLagerMenge = vLagerMenge -  vAnforderungsMenge;                // Bedingung: DANN weise vLagerMenge neu zu aus vLagerMenge minus vAnforderungsMenge
                vAnforderungsMenge = 0;                                         // und setze vAnforderungsMenge auf 0
                } 
        else                                                                    // ODER
            {
                //Teilweise oder keine AnforderungsMenge bedient!
                vAnforderungsMenge = vAnforderungsMenge - vLagerMenge;          // DANN weise vAnforderungsMenge neu zu aus vAnforderungsMenge minus vLagerMenge; die komplette LagerMenge wird augegeben
                
                vLagerMenge = 0;                                                // und setze vLagerMenge auf 0
                }
        
        System.out.println("Neue Materialmenge" + "\n" + "------------------");
        DisplayMaterial();                                                      // Ausgabe der Attributwerte über System.out.println()
        System.out.println("\n");

        if  (vLagerMenge < vMindestMenge)                                       //Bedingung, Prüfung: ist vLagerMenge kleiner als vMindestMenge (ist die Mindestmenge unterschritten?)
            {
             if  (vBestellteMenge != 0)
             {
              vBestellMenge   = vAnforderungsMenge; 
              vBestellteMenge = vBestellteMenge + vBestellMenge;
             }else
             { 
             //Bestellung vorbereiten
             //MindestMenge + 25% und die AnforderungsMenge addieren
             vBestellMenge = (vMindestMenge * vMengenAufschlag) / 100;          // DANN setze vMenge auf (vMindestMenge * vMengenAufschlag) / 100
             vBestellMenge = vBestellMenge + vMindestMenge + vAnforderungsMenge;// und setze vBestellMenge aus vBestellMenge + vMindestMenge + vAnforderungsMenge zusammen
             vBestellteMenge = vBestellMenge; 
             }
            }
        return vBestellMenge;                                                          //Rückgabewert vBestellMenge
        }
    
    }
