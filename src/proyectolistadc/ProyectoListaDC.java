
package proyectolistadc;
//Universidad Laica "Eloy Alfaro" de Manabí
//Proyecto Lista Doblemente Enlazada Circular
//FLORES ALDO
//Tercer Nivel "A"
//Estructura de datos


import java.io.IOException;
import java.util.Scanner;







class CNodoDC
{
	int dato;
	CNodoDC siguienteDC;
	CNodoDC anteriorDC;

	public CNodoDC()
	{
		anteriorDC = null;
                siguienteDC = null;
	}
}

class CLista
{
	CNodoDC cabezaDC;
        CNodoDC actualDC;
	public CLista()
	{
		cabezaDC = null;
                actualDC = null;
	}
  
      public void Menu() throws IOException  {
          
       Scanner entrada = new Scanner(System.in);
          System.out.println("aldo flores ");
        System.out.println("\n\n\t\t\tLista Doblemente Enlazada Circular");
        System.out.println("\n\n\t\t\t---------Menú Principal ---------");
        System.out.println("\t\t\t+                                  +");
        System.out.println("\t\t\t+ 1 Ingresar                       +");
        System.out.println("\t\t\t+ 2 Eliminar                       +");
        System.out.println("\t\t\t+ 3 Buscar                         +");
        System.out.println("\t\t\t+ 4 Recorrido                      +");
        System.out.println("\t\t\t+ 5 Salir                          +");
        System.out.println("\t\t\t------------------------------------");
        System.out.println("\t\t\tDigite una opción:");
        int op = entrada.nextInt(); 
        Opciones(op);
    }
      public void Opciones(int op) throws IOException   {
        switch (op) {

            case 1:   
               InsertarDatoDobleC();
               Menu();
                break;
            case 2:
               EliminarDatoDC();
               Menu();
               break;
            case 3:
               BuscarDatoDobleC();
               Menu();
               break; 
            case 4: 
               RecorridoDC();
                Menu();
                break;
            case 5:
                System.exit(1);
                Menu();
            default:
                Menu();
                break;
        }
     }

        public void InsertarDatoDobleC()throws IOException
	{
                System.out.println("Digite el dato para la Lista");
                Scanner entrada =new Scanner(System.in);    
                int dat=entrada.nextInt(); 
        	CNodoDC CNodo;
                CNodoDC ant=null,sig=null;
		CNodo = new CNodoDC();
		CNodo.dato=dat;
                int ban=0;
               
		if (cabezaDC == null)
                {   CNodo.siguienteDC=CNodo;
                    CNodo.anteriorDC=CNodo;
                    cabezaDC = CNodo;
                    actualDC= CNodo;
                }
                else { 
                    if (dat<cabezaDC.dato)
                        {  
                            ant=cabezaDC.anteriorDC;
                            CNodo.anteriorDC=ant;
                            CNodo.siguienteDC=cabezaDC;
                            cabezaDC.anteriorDC=CNodo;
                            ant.siguienteDC=CNodo;
                            cabezaDC = CNodo;
                            actualDC=CNodo;
                        }
                    else {  ant=actualDC;
                            sig=actualDC;
                            while (ban==0)
                            {   
                                if (dat>=sig.dato)
                                {
                                    ant=sig;
                                    sig=sig.siguienteDC;
                                    
                                    if(sig==cabezaDC) {ban=1;}
                                }
                                else { 
                                if (dat<sig.dato) {
                                            sig=ant;
                                            ant=ant.anteriorDC;
                                            if(ant==cabezaDC){ban=1;}
                                        }
                                    }
                                if ((ant==null)||(sig==null)) {ban=1;}
                                else {
                                        if ((dat<sig.dato)&&(ant.dato<dat))
                                        {ban=1;}
                                    }
                            }
                            if (ant!=null) ant.siguienteDC=CNodo;
                            CNodo.anteriorDC=ant;
                            CNodo.siguienteDC=sig;
                            actualDC=CNodo;
                            if (sig!=null) sig.anteriorDC=CNodo;
                        }
                }
    }
        public void EliminarDatoDC()throws IOException{
          System.out.println("Ingrese  el dato a Eliminar:");
          Scanner entrada =new Scanner(System.in);    
          int dat=entrada.nextInt(); 	          
            CNodoDC ant=null,sig=null;
           int ban=0;
           if (VaciaDC()) 
           {
               System.out.print("Lista vacía: ");
           }
           else{
               if (dat<cabezaDC.dato) 
                   
                   System.out.print("Dato no existe ");
               else 
                   if (dat==cabezaDC.dato)
                   {
                   if(cabezaDC.siguienteDC!=cabezaDC){
                       ant=cabezaDC.anteriorDC;
                       cabezaDC=cabezaDC.siguienteDC;
                       ant.siguienteDC=cabezaDC;
                       cabezaDC.anteriorDC=ant;
                       actualDC=cabezaDC;
                   }else
                   {
                   cabezaDC=null;
                   actualDC=null;
                   }
               }else
               {
               ant=actualDC;
               sig=actualDC;
               while(ban==0)
               {
               
                   if((ant.dato<dat)&&(dat<sig.dato)){ban=1;}
               else{
                   if(dat>sig.dato)
                   {
                      ant=sig;
                      sig=sig.siguienteDC;
                      if(sig==cabezaDC){ban=1;}
                   }
                   else
                       if(dat<sig.dato)
                       {
                            sig=ant;
                            ant=ant.anteriorDC;
                        if(ant==cabezaDC)
                            {ban=1;}
                       }
                if((sig.dato==dat)||(ant.dato==dat))
                    {ban=1;}
            }
        } 
        if(dat==sig.dato)
        {
            ant=sig.anteriorDC;
            ant.siguienteDC=sig.siguienteDC;
            sig=sig.siguienteDC;
            sig.anteriorDC=ant;
            actualDC=sig;
            
        }else 
            if(dat==ant.dato)
            {
                 ant=ant.anteriorDC;
                 ant.siguienteDC=sig;
                 sig.anteriorDC=ant;
                 actualDC=sig;
             }  
        else System.out.println("Dato no existe");
        }
    }
}

         public boolean VaciaDC()
        {    
            return(cabezaDC==null);
        }

	public void RecorridoDC(){
            CNodoDC Nodo;
            Nodo=cabezaDC;
            if (!VaciaDC()) 
            {
                System.out.println("Los datos en lista son: ");
                do{
                    System.out.print(" " + Nodo.dato +" ");
                    Nodo = Nodo.siguienteDC;
                  }while (Nodo!=cabezaDC);
            }
            else System.out.print("Lista vacía");
            }

        
        public void BuscarDatoDobleC () throws IOException { 
                
                System.out.println("Ingrese el dato a Buscar :");
                Scanner entrada =new Scanner(System.in);    
                int dat=entrada.nextInt();          
                int ban=0;
                int cont=0;
		 CNodoDC NodoDC;
                NodoDC=cabezaDC;
                if (!VaciaDC()) 
                {
                do
                   {	
                       if(NodoDC.dato==dat)
                       {
                           ban=1;
                       }
                       
                       NodoDC = NodoDC.siguienteDC;
                       
                }while (NodoDC!=cabezaDC);
                
                    if(ban==1)
                {
                       System.out.print("El " + dat +" encontrado");
                }
                       else{
                           System.out.println("El " +dat+" no existe");
                       }
                }
                
                else System.out.print("Lista Vacía");
	}
}
public class ProyectoListaDC {

    public static void main(String[] args) throws IOException {
                CLista Lista = new CLista();
                Lista.Menu();
    }
    
}
