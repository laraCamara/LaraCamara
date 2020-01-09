/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays1;

/**
 *
 * @author dam
 */
public class Arrays1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
       Parking artesano;
       artesano=new Parking();
       artesano.incializarPlazas();
       artesano.comienzaDia();      
        System.out.println("Se ha terminado la jornada.");
    }
    
}
