/*
  * To change this template, choose Tools | Templates
  * and open the template in the editor.
  */
 package lagerverwaltung;
 
 /**
  * <b>Mitarbeiter-Klasse</b><br>
  * @author Gruppe3
  */
 public class Mitarbeiter                                                        //Erstellung der Klasse Mitarbeiter
 {
     String vVorName;                                                            //Eigenschaft - Vorname (string)
     String vNachName;                                                           //Eigenschaft - Nachname (string)
     int    vPersonalNr;                                                         //Eigenschaft - Personalnummer (integer)  
     
     /**
      * Konstruktor um Werte zu initialisieren und Testwerte zu setzen
      * @param kvVorName
      * @param kvNachName
      * @param kvPersNr
      */
     public Mitarbeiter(String kvVorName, String kvNachName, int kvPersonalNr)  //Konstruktor zur Erstellung eines Mitarbeiter-Objekts
     {
         vVorName        = kvVorName;                                            //Uebergabe - Vorname
         vNachName       = kvNachName;                                           //Uebergabe - Nachname
         vPersonalNr     = kvPersonalNr;                                             //Uebergabe - Personalnummer
         
         DisplayMitarbeiter();                                                   //Aufruf der Methode DisplayMitarbeiter
         }
     
     /**
      * <b>Ausgabe der Werte</b><br>
      */
     private void DisplayMitarbeiter()                                           //Methode - DisplayMitarbeiter - Ausgabe der Mitarbeitereigenschaften
     {
         System.out.println("VorName:" + vVorName + "\t" + "NachName: "          //Ausgabe von Vorname, Nachname, Personalnummer
                            + vNachName + "\t" + "PersNr: " + vPersonalNr);        
         }
     
     /**
      * <b>Unterfunktion SetAttribute</b><br>
      * einzelne Werte setzen<br>
      * wobei leere Übergabe und gleiche Werte abgefangen werden
      * @param kvVorName
      * @param kvNachName
      * @param kvPersNr
      */
     public void SetAttribute(String kvVorName, String kvNachName, int kvPersNr) //Methode - SetAttribute - Setzen der Mitarbeitereigenschaften
     {
         if  ((kvVorName != vVorName) & (kvVorName != null))                     //Bedingung: neuer Vorname ungleich alter Vorname und neuer Vorname ungleich Null 
              {
              vVorName        = kvVorName;                                       //Aenderung: Vorname = neuer Vorname
              }           
         if  ((kvNachName != vNachName) & (kvNachName != null))                  //Bedingung: neuer Nachname ungleich alter Nachname und neuer Nachname ungleich Null
              {
              vNachName       = kvNachName;                                      //Aenderung: Nachname = neuer Vorname
              }           
         if  ((kvPersNr != vPersonalNr) & (kvPersNr != 0))                       //Bedingung: neuer Personalnummer ungleich alter Personalnummer und neuer Personalnummer ungleich Null
              {
              vPersonalNr     = kvPersNr;                                        //Aenderung: Personalnummer = neue Personalnumer
              }
 
         DisplayMitarbeiter();                                                   //Aufruf der Methode DisplayMitarbeiter
         }
     }
 
