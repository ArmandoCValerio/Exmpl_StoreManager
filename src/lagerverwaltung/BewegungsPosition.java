/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lagerverwaltung;

/**
 * <b>BewegungsPositonen</b><br>
 * Positionen werden über die jeweilige Warenbewegung (Anforderung,Bestellung)
 * instanziert<br>
 * Die Positonen sind Materialbezogen [MaterialID]=[BewegungsPosition]
 * @author Gruppe3
 */
public class BewegungsPosition                                                  //Deklaration der Klasse BewegungsPosition
{
    int vBewegungsMenge;                                                        //Eigenschaft Bewegungsmenge (integer)
    
    /**
     * @param kvBewegungsMenge
     */
    public BewegungsPosition(int kvBewegungsMenge)                              //Methode - BewegungsPosition - Setzt die Bewegungsmenge
    {
        vBewegungsMenge = kvBewegungsMenge;                                     //Setzen der Bewegungsmenge
        }
    
    
    /**
     * <b>Setzen der Attribute</b><br>
     * @param kvBewegungsMenge
     */
    public void SetAttribute(int kvBewegungsMenge)                              //Methode - SetAttribute
    {
        vBewegungsMenge     = kvBewegungsMenge;                                 //Setzen der neuen Bewegungsmenge
        }
    
    
    /**
     * <b>Rueckgabe der Attribute</b><br>
     * @return
     */
    public int GetAttribute()                                                   //Methode - GetAttribute
    {
        return vBewegungsMenge;                                                 //Rueckgabe der Bewegungsmenge
        }     
    }
