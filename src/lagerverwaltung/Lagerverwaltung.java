/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lagerverwaltung;
/**
 * <b>Diese Klasse initialisiert und startet die Lagerverwaltung wie folgt:</b><br>
 * <br>
 * - Erstellung der Testdaten zu Mitarbeiter, Material, Lieferant und
 *   Warenbewegung. Hierzu werden Arrays mit gegebenem Inhalt gefüllt.<br>
 * - Generierung einiger Testfälle, bestehend aus Mitarbeiter, Material, Menge<br>
 * <br>
 * Testfälle werden in Schleife durchlaufen:<br>
 *  - Prüfung ob Mitarbeiter vorhanden<br>
 *  - Wenn Material/Lieferant nicht vorhanden -> Anlegen<br>
 *  - Warenbewegung erzeugen und ablaufen lassen -> Warenbewegung.Entnahme oder Bestellung<br>
 *       1. Material wird durch Mitarbeiter entnommen<br>
 *       2. Optional: Wenn Entnahme ergibt, dass Meterial bestellt werden muss (vBestellMenge!=0)
 *                    dann wird Bestellung aufgerufen, also beim Lieferanten Metarial nachbestellt.<br>
 * <br>
 * Jeder Arbeitsschritt wird in der Konsole protokolliert mittels System.Out... *
 * <br>
 * <br>
 * <b>Attribute:</b><br>
 * Testfallarray[][] wie folgt aufgebaut:<br>
 * ........................Testfall[0]  Testfall[1] Testfall[2] ....<br>
 * Mitarbeiter[0].....   z.b. 3.......z.b. 2........z.b.5 <br>
 * Material[1].........   z.b. 1.......z.b. 1........z.b.3 <br>
 * Menge[2]...........   z.b. 10......z.b. 50.......z.b.2 <br>
 * <br>
 * Die Objekte für die Klassen Mitarbeiter, Material, Lieferant und Warenbewegung werden als
 * Array angelegt, um dynamisch angesprochen werden zu können.<br>
 * <br>
 * WarenBewegung[][] wie folgt aufgebaut:<br>
 * ........................................MitarbeiterAnforderung[0].....LieferantenBestellung[1] <br>
 * MitarbeiterNr./LieferantenNr.[1].....   z.b. Mitarbeiter 3.......z.b. Lieferant 7<br>
 * MitarbeiterNr./LieferantenNr.[2].....   z.b. Mitarbeiter 1.......z.b. Lieferant 3<br>
 * MitarbeiterNr./LieferantenNr.[3].....   z.b. Mitarbeiter 2.......z.b. Lieferant 5<br>
 * MitarbeiterNr./LieferantenNr.[X]<br>
 * <br>
 * <b>Methoden:</b><br>
 * mInitTestDaten():<br>
 *   - Beispieldaten für die Klassen Mitarbeiter, Material, Lieferant und Warenbewegung anlegen.<br> *   
 *
 * main():<br>
 *   - Testfälle werden in Schleife durchlaufen (siehe oben)<br>
 *   - Falls Neues Material: Mit Zufallswerten belegen ->  mRandomNum()<br>
 *   - Warenbewegung auslösen (siehe oben)
 * @author Gruppe3
 */
public class Lagerverwaltung 
{
    //Arrays/Variable für die Testfälle!
    static int aTestArray[][]      = new int[5][5];
    
    //Anlegen der MitarbeiterObjekte als Array für die Testläufe
    static Mitarbeiter[] oMitarbeiter = new Mitarbeiter[10];
    //Instanzieren der MaterialObjekte für die Testläufe
    static Material[]    oMaterial = new Material[20];
    //Instanzieren der LieferatenObjekte für die Testläufe
    static Lieferant[]   oLieferant = new Lieferant[10];
    //Instanzieren der AnforderungsObjekte für die Testläufe
    //1. Array WarenbewegungsArt 0=Anforderung 1=Bestellung
    //2. Array ist bei 0 -> Mitarbeiterbezogen bei 1->Lieferantenbezogen
    static Warenbewegung[][]  oWarenbewegung = new Warenbewegung[2][10];
    
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) 
    {
        int i,aktTest = 0;   //Testfallindex
        int testMitarbeiter, testMaterial, testAnfMenge, testLieferant;
        int vMinMenge;
        int vLagMenge = 0;
        int vBestellMenge;
        
        System.out.println("Testdaten generieren!" + "\n" + 
                           "*********************"); 
        //Aufruf der Initialisierung
        mInitTestDaten();
        
        System.out.println("\n" + "*********************************" + "\n"
                           + "Programm Lagerverwaltung beginn!" + "\n" + 
                           "*********************************");       
        
        //**********************************************************************
        //            Schleife für Testlauf
        //**********************************************************************
        for (i = 0; i < aTestArray[0].length; i++)
        {         
            System.out.println(++aktTest + ". Test");
            //hier werden die TestWerte aus dem Array in zwichenfeldern gespeichert
            //die Felder testMitarbeiter und testMaterial dienen als Index!
            testMitarbeiter = aTestArray[i][0];
            testMaterial    = aTestArray[i][1];
            testAnfMenge    = aTestArray[i][2];
            
            //Mitarbeiter vorhanden wenn nicht Programmende!
            if  (oMitarbeiter[testMitarbeiter] != null)
            {
                //Existiert Material? wenn nicht neuanlegen!
                if  (oMaterial[testMaterial] == null)
                {
                    //Zufahlszahlen generieren!
                    vMinMenge       = mRandomNum(100,1000);
                    testLieferant   = mRandomNum(1,9);

                    System.out.println("Materialanlegen" + "\n" + "---------------");
                    System.out.println("durch: " + oMitarbeiter[testMitarbeiter].vVorName 
                                       + " " + oMitarbeiter[testMitarbeiter].vNachName);

                    //neues Material anlegen! mit testMaterial=MaterialId, Lagermenge=0 da neu,
                    //MinMenge=Zufahlszahl,Lieferant=Zufahlszahl,25=Prozent aufschlag
                    oMaterial[testMaterial] = new Material("Material_" + testMaterial,testMaterial,
                                                         vLagMenge,vMinMenge,testLieferant,25);
                    System.out.println("\n");
                    }    
                
                //die LieferantenId aus dem Materialsatz --> ist der Index/LieferantenId des
                //Lieferantarrays
                testLieferant =  oMaterial[testMaterial].vLieferantId; 
                 //Lieferant vorhanden? wenn nicht wird hier neu angelegt!
                 if  (oLieferant[testLieferant] == null)
                 {
                     System.out.println("Lieferantanlegen" + "\n" + "---------------");
                     System.out.println("durch: " + oMitarbeiter[testMitarbeiter].vVorName 
                                       + " " + oMitarbeiter[testMitarbeiter].vNachName);
                     
                     //neuen Lieferanten anlegen
                     oLieferant[testLieferant] = new Lieferant("Lieferant_" + testLieferant,testLieferant);
                     System.out.println("\n");
                     }
                System.out.println("Anforderung:");
                System.out.println("PersNr: " + oMitarbeiter[testMitarbeiter].vPersonalNr 
                              + "\t" + "Name: " + oMitarbeiter[testMitarbeiter].vVorName 
                              + " " + oMitarbeiter[testMitarbeiter].vNachName 
                              + "\t" + "Material: " + oMaterial[testMaterial].vMaterialId 
                              + "/" + oMaterial[testMaterial].vBezeichung + " \t" + 
                                "AnforderungsMenge: " + testAnfMenge + "\n");
                
                //**************************************************************
                //                A N F O R D E R U N G
                //**************************************************************
                //Prüfen ob es eine Anforderung für den Mitarbeiter gibt
                //dies ermöglicht das sammeln von Anforderungen!
                if  (oWarenbewegung[0][testMitarbeiter] == null)
                {
                    oWarenbewegung[0][testMitarbeiter] = new Warenbewegung("Anforderung");
                    }
            
                //Materialbestellen
                //Für jeden Mitarbeiter wird ein Warenbewegungsobjekt angelegt
                //Aufruf der AnforderungsMethode
                vBestellMenge = oWarenbewegung[0][testMitarbeiter].MaterialEntnehmen(oMitarbeiter[testMitarbeiter],
                                                                  oMaterial[testMaterial],
                                                                  testAnfMenge);            
                
                //**************************************************************
                //                   B E S T E L L U N G 
                //**************************************************************
                //Bestellmenge vorhanden dann wird eine Bestellung vorbereitet
                if (vBestellMenge != 0)
                {
                    //Prüfen ob es eine Bestellung für den Lieferanten gibt
                    //dies ermöglicht das sammeln von Bestellungen!
                    if  (oWarenbewegung[1][testLieferant] == null)
                    {
                        oWarenbewegung[1][testLieferant] = new Warenbewegung("Bestellung");
                        }
                    //Bestellung aufrufen
                    oWarenbewegung[1][testLieferant].mMaterialBestellen(oLieferant[testLieferant],
                                                                        oMitarbeiter[testMitarbeiter],
                                                                        oMaterial[testMaterial],
                                                                        vBestellMenge);
                    }
       }else
            {
                System.out.println("PersNr: " + testMitarbeiter + " nicht vorhanden" + "\n"); 
                }
        
       System.out.println("*******************");
       
       //nach den kompletten Anforderuns- und Bestellvorgängen sollte hier dann
       //die Anforderung und Bestellung --> ausgeführt werden
       //normalerweise (Datenbankanwendung) wird der Status aktualisiert, in diesem Fall 
       //werden beim nächsten Programmstart die Objekte sowieso neu instanziert!
              
       }
    System.out.println("\n" + "Programm Lagerverwaltung ende!"); 
    }
    
    //Zufahlszahlen für Test generieren
    private static int mRandomNum(int vLow, int vHigh) 
    {
	vHigh++;
	return (int) (Math.random() * (vHigh - vLow) + vLow);
	}  
    
    //**************************************************************************
    //             TestDaten bzw. Objekte instanzieren
    //**************************************************************************
    private static void mInitTestDaten()  
    {
        // 10 MaterialObjekte anlegen 
        //Bezeichnung,MaterialID,LagerMenge,MindestMenge,LieferantID,Aufschlag
        //MaterialId entspricht dem Index vom Array!!!! deswegen mit 1 begonnen
        System.out.println("Materialanlegen" + "\n" + "---------------");
        oMaterial[1]    = new Material("Material_01",1,200,100,1,25);
        oMaterial[2]    = new Material("Material_02",2,300,200,2,25);
        oMaterial[3]    = new Material("Material_03",3,500,300,2,25);
        oMaterial[4]    = new Material("Material_04",4,11,10,5,25);
        oMaterial[5]    = new Material("Material_05",5,20,10,3,25);
        oMaterial[6]    = new Material("Material_06",6,137,100,5,25);
        oMaterial[7]    = new Material("Material_07",7,97,50,1,25);
        oMaterial[8]    = new Material("Material_08",8,300,120,2,25);
        oMaterial[9]    = new Material("Material_09",9,70,60,4,25);
        oMaterial[10]   = new Material("Material_10",10,100,80,4,25);
              
        //2 MitarbeiterObjekte anlegen
        //Mitarbeietr anlegen mit VorName,NachName,PersNr
        System.out.println("\n" + "Mitarbeiteranlegen" + "\n" + "------------------");
        oMitarbeiter[1] = new Mitarbeiter("Peter","Silie",815);
        oMitarbeiter[2] = new Mitarbeiter("Klara","Korn",817);
        
        //Lieferanten anlegen mit Name und Id
        //LiefertantenId entspricht dem Index vom Array!!! deswegen mit 1 begonnen
        System.out.println("\n" + "Lieferantenanlegen" + "\n" + "------------------");
        oLieferant[1]   = new Lieferant("Lieferant_1",1);
        oLieferant[2]   = new Lieferant("Lieferant_2",2);
        oLieferant[3]   = new Lieferant("Lieferant_3",3);
        oLieferant[4]   = new Lieferant("Lieferant_4",4);
        oLieferant[5]   = new Lieferant("Lieferant_5",5);
        
        //Array-Indizes für die x Testfälle!!!!
        //Das sind die verschiedenen Testfälle die durchlaufen werden
        //jederzeit Änderbar!
        //1.Test
        aTestArray[0][0] = 1;    //TestMitarbeiter     
        aTestArray[0][1] = 1;    //TestMaterial     
        aTestArray[0][2] = 50;   //TestAnforderungsMenge
        //2.Test
        aTestArray[1][0] = 1;    //TestMitarbeiter     
        aTestArray[1][1] = 2;    //TestMaterial     
        aTestArray[1][2] = 150;  //TestAnforderungsMenge
        //3.Test
        aTestArray[2][0] = 2;    //TestMitarbeiter     
        aTestArray[2][1] = 11;    //TestMaterial     
        aTestArray[2][2] = 200;  //TestAnforderungsMenge
        //4.Test
        aTestArray[3][0] = 2;    //TestMitarbeiter     
        aTestArray[3][1] = 11;    //TestMaterial     
        aTestArray[3][2] = 300;  //TestAnforderungsMenge
        //5.Test
        aTestArray[4][0] = 1;    //TestMitarbeiter     
        aTestArray[4][1] = 5;    //TestMaterial     
        aTestArray[4][2] = 30;   //TestAnforderungsMenge       
        }        
    }
