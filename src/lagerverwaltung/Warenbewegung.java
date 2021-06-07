/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lagerverwaltung;

import java.util.Date;

/**
 * <b>Diese Klasse führt abhängig von der übergebenen Bewegungsart eine<br>
 *    MitarbeiterAnforderung oder eine LieferantenBestellung aus.</b><br>
 * <br>
 *    <b>Ablauf:</b><br>
 *    - Das anzufordernde/zu bestellende Material wird aus der Klasse Lagerverwaltung übergeben.<br>
 *    - Anschließend wird eine BewegungsPosition für das Material erstellt, falls noch nicht vorhanden.<br>
 *    - Wenn es schon eine BewegungsPosition gibt, wird die Menge des Materials aufaddiert.<br>
 *    - Über die Bewegungsposition können mehrere Mitarbeiter das gleiche Material bestellen.<br>
 *    - Nur bei MitarbeiterAnforderung:<br>
 *    - Methode GetMaterial() der Klasse Material wird aufgerufen, um das Material zu entnehmen.<br>
 *   
 * <br>
 *
 * @author Gruppe3
 */
public class Warenbewegung
{
   
   BewegungsPosition[] oBewegungsPosition;
   String Datum;
   String vBewegungsart;
   //
    /**
     * Konstruktor um Werte zu initialisieren und Testwerte zu setzen
     * @param kvBewegungsart
     */
    public Warenbewegung(String kvBewegungsart)
   {
        //Für jede Warenbewegung wird ein Array mit 20 Positionen angelegt
        oBewegungsPosition = new BewegungsPosition[20];
        vBewegungsart = kvBewegungsart;
        Date now = new Date();
        Datum = now.toString();
        }
       
    /**
     * <b>Unterfunktion Material-Anforderung</b><br> 
     * prüfen ob Anforderungs-Position vorhanden<br> 
     * falls ja Menge addieren ansonsten neue Position<br> 
     * @param oMitarbeiter
     * @param oMaterial
     * @param kvAnforderungsMenge
     * @return
     */
    public int MaterialEntnehmen(Mitarbeiter oMitarbeiter,Material oMaterial,
                                 int kvAnforderungsMenge)
    {
        //Hilfsvariablen
        int vBestellMenge = 0;
        int vMenge = 0;
        int vMaterialId;
        
        vMaterialId = oMaterial.vMaterialId;
        //BewegungsPosition[vMaterialId] vorhanden?
        //wenn nein anlegen!
        //wenn ja Menge zu bestehender Position addieren da gleiches Material!
        //somit werden die Positionen zur Anforderung gesammelt
        //später sollte dies dann ausgefürhrt werden siehe -> Lagerverwaltung-Ende!
        if  (oBewegungsPosition[vMaterialId] == null)
        {
            oBewegungsPosition[vMaterialId] = new BewegungsPosition(kvAnforderungsMenge);
            }else
            {
              vMenge = kvAnforderungsMenge;
              vMenge += oBewegungsPosition[vMaterialId].GetAttribute();
              oBewegungsPosition[vMaterialId].SetAttribute(vMenge);
              }
        
        //******** GetMaterialMethode aufrufen ********
        vBestellMenge = oMaterial.mGetMaterial(kvAnforderungsMenge);
        return vBestellMenge;
        }
    
    /**
     * <b>Unterfunktion Bestellung</b><br>
     * prüfen ob Bestell-Position vorhanden<br> 
     * falls ja Menge addieren ansonsten neue Position<br> 
     * @param oLieferant
     * @param oMitarbeiter
     * @param oMaterial
     * @param kvBestellMenge
     */
    public void mMaterialBestellen(Lieferant oLieferant,Mitarbeiter oMitarbeiter,
                                   Material oMaterial,int kvBestellMenge)
    {
        //Hilfsvariablen
        int vMaterialId;
        int vMenge = 0;
        vMaterialId = oMaterial.vMaterialId;

        //BewegungsPosition[vMaterialId] vorhanden?
        //wenn nein anlegen!
        //wenn ja Menge zu bestehender Position addieren da gleiches Material!
        if  (oBewegungsPosition[vMaterialId] == null)
        {
            oBewegungsPosition[vMaterialId] = new BewegungsPosition(kvBestellMenge);
            }else
            {
              vMenge = kvBestellMenge;
              vMenge += oBewegungsPosition[vMaterialId].GetAttribute();         //Menge aus Position auf ZwischenMenge addieren
              oBewegungsPosition[vMaterialId].SetAttribute(vMenge);             //Menge der Position setzen
              }
        
        System.out.println("Bestellung" + "\n" + "----------");
        System.out.println("durch: " + oMitarbeiter.vVorName 
                           + " " + oMitarbeiter.vNachName);
        System.out.println("Lieferant: " + oLieferant.vLieferantenName
                           + "\t" + "MaterialID: " + oMaterial.vMaterialId 
                           + "\t" + "BestellMenge: " + kvBestellMenge + "\n");    
        }
    }
