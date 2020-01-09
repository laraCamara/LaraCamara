/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dam
 */
public class Parking {
    int nplaza=0;
        String[]plazas;
    public Parking()
        {
            plazas= new String[5];

        }
    
    public Parking(int numeroPlazas)
        {
             plazas=new String[numeroPlazas];
        }
    
    public void incializarPlazas()
        {
        for(nplaza=0; nplaza<plazas.length;nplaza++)
        {
        plazas[nplaza]="libre";
        }
        }
    private void estado()             
        {
            System.out.println("NºPLAZA - ESTADO");
        for(int nplaza=0; nplaza<plazas.length;nplaza++)
        {
            
            System.out.println( "   "+nplaza + "      " + plazas[nplaza]);
            
        }
        }
    public void comienzaDia()
    {
        
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int numero=0;
        boolean seguimos=true;
        while(seguimos==true)
        {
            
            numero=0;
            while(numero<1||numero>4)
            {   
                try
                {
                System.out.println("Pulse 1 para ingresar vehículo, 2 para retirarlo, 3 para ver las plazas libres o pulse 4 para cerrar.");
                numero=Integer.parseInt(teclado.readLine());
                }
                    catch (IOException ex)
                    {
                        System.out.println("Hubo un problema técnico.");
                    }
                    catch (NumberFormatException ex)
                    {
                        System.out.println("El dato introducido no es un número.");
                    }
            }//while
                switch(numero)
                {
                    case 1: {insertarAuto();break;}
                    case 2: {sacarAuto();break;}
                    case 3: {estado();break;}
                    case 4: {seguimos=false;break;}
                }
        }
    }
    private void insertarAuto()
    {               
        boolean encontrado;
        encontrado=buscaPlaza();
       if(encontrado=true&&nplaza!=plazas.length)
       {
       plazas[nplaza]="ocupado";
                    System.out.println("Ha ocupado la plaza" + nplaza);       
       }
       else
       {
           System.out.println("El parking está lleno.");
       }   
     }
    
    /**
     * busqueda secuencial de plazas ocupadas
     * @return 
     */
    private boolean buscaAutos()
    {
        boolean puedoRetirar=false;
        nplaza=0;
        while(nplaza<plazas.length&&puedoRetirar==false)       
        {            
           if(plazas[nplaza].equalsIgnoreCase("ocupado"))
           {
           puedoRetirar=true;
           }
           else
           {
            nplaza++;
           }
        }
        return puedoRetirar;
    }
     private boolean buscaPlaza()
    {
        boolean puedoEntrar=false;
        nplaza=0;
        while(nplaza<plazas.length&&puedoEntrar==false)       
        {            
           if(plazas[nplaza].equalsIgnoreCase("libre"))
           {
           puedoEntrar=true;
           }
           else
           {
            nplaza++;
           }
            if(nplaza==plazas.length)
                {                    
                    puedoEntrar=true;
                }

        }
        return puedoEntrar;
    }
    private void sacarAuto()
    {        
     boolean puedoRetirar=buscaAutos();
     if(puedoRetirar==true)
     {
        System.out.println("Introduzca el número de plaza del coche que desea retirar.");  
        puedoRetirar=false;
    
            while(puedoRetirar==false)
            {
                try
                {
                    InputStreamReader flujo=new InputStreamReader(System.in);
                    BufferedReader teclado=new BufferedReader(flujo);
                    
                    nplaza=Integer.parseInt(teclado.readLine());
                }
                    catch (IOException ex)
                    {
                        System.out.println("Hubo un problema técnico.");
                    }
                    catch (NumberFormatException ex)
                    {
                        System.out.println("El dato introducido no es un número.");
                    }
                        if(plazas[nplaza].equalsIgnoreCase("ocupado"))
                        {
                            plazas[nplaza]="libre";
                            puedoRetirar=true;
                        }
                        else
                        {
                            System.out.println("No hay un vehículo estacionado en esa plaza.");
                            puedoRetirar=true;
                        }
            }//while
     }//if
     else
     {
         System.out.println("No hay ningún vehículo para retirar.");
     }
    }
}
