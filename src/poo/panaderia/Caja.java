/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Caja {
    private Date fecha;
    private Date horaApertura;
    private Date horaCierre;
    private List<Cobro> cobros;
    private List<MovimientoCaja> movimientos;
    private List<ComposicionCaja> composiciones;

    /**
    * Constructor por Defecto.
    */
    public Caja() {
        cobros= new ArrayList<>();
        movimientos = new ArrayList<>();
        composiciones = new ArrayList<>();
    }
    
    /**
    * Constructor con parámetros, con los atributos referenciales.    
     * @param fecha
     * @param horaApertura
     * @param horaCierre
    */
    public Caja(Date fecha, Date horaApertura, Date horaCierre) {
        this.fecha = fecha;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Caja.
     * @param fecha
     * @param horaApertura
     * @param horaCierre
     * @param cobros
     * @param movimientos
     * @param composiciones
    */
    public Caja(Date fecha, Date horaApertura, Date horaCierre, List<Cobro> cobros, List<MovimientoCaja> movimientos, List<ComposicionCaja> composiciones) {
        this.fecha = fecha;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.cobros = cobros;
        this.movimientos = movimientos;
        this.composiciones = composiciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<Cobro> getCobros() {
        return cobros;
    }

    public void setCobros(List<Cobro> cobros) {
        this.cobros = cobros;
    }

    public List<MovimientoCaja> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoCaja> movimientos) {
        this.movimientos = movimientos;
    }

    public List<ComposicionCaja> getComposiciones() {
        return composiciones;
    }

    public void setComposiciones(List<ComposicionCaja> composiciones) {
        this.composiciones = composiciones;
    }
    
    /**
     * Devuelve un arraylist con size 0 si el vuelto es cero.
     * 
     * @param dineroRecibido
     * @param montoVuelto
     * @return 
     */
    public List<MovimientoDinero> ingresarDineroYDarVuelto (List<MovimientoDinero> dineroRecibido, float montoVuelto)
    {
        ArrayList<MovimientoDinero> billetesVuelto= new ArrayList();
               
        this.ingresarDineroACaja(dineroRecibido);
        
        if (montoVuelto > 0) {
            billetesVuelto= this.calcularBilletesVuelto(montoVuelto);
        }
        
        return billetesVuelto;
        
    }
    
    public void ingresarDineroACaja (List<MovimientoDinero> dineroRecibido) {
        // Sumar dinero a la caja
        Iterator<MovimientoDinero> iterDinero = dineroRecibido.iterator();  
        Iterator<ComposicionCaja> iterCaja = this.getComposiciones().iterator();
        
        // incializamos las nuevas composiciones a agregar en caso de no existir
        List<ComposicionCaja> nuevasComposiciones = new ArrayList<>();
        
        while (iterDinero.hasNext()) {
            // Para cada dinero recibido, recorre la caja hasta encontrar el objeto de composicionCaja del Dinero,
            // correspondiente al dinero recibido y actualiza la cantidad del mismo.
            MovimientoDinero movimientoDinero = iterDinero.next();
            boolean encontrado = false;
            
            while (iterCaja.hasNext()) {
                ComposicionCaja composicionCaja = iterCaja.next();
                
                if (movimientoDinero.getDinero().equals(composicionCaja.getDinero())) {
                    composicionCaja.setCantidad(composicionCaja.getCantidad() + movimientoDinero.getCantidad());
                    encontrado = true;
                    break;
                }
            }
            
            // Si termina de recorrer la caja y no encuentra un objeto composicionCaja creado para ese dinero debe crearlo y
            // agregarlo a la caja
            if (!encontrado) {
                ComposicionCaja composicionCaja = new ComposicionCaja();
                composicionCaja.setCantidad(movimientoDinero.getCantidad());
                composicionCaja.setDinero(movimientoDinero.getDinero());
                
                nuevasComposiciones.add(composicionCaja);
            }
        }
        
        // agregamos las nuevas composiciones a la caja si hubieran
        this.composiciones.addAll(nuevasComposiciones);
    }
    
    public void sacarDineroDeCaja(List<MovimientoDinero> dineroRecibido)
    {
        //Sumar dinero a la caja
        Iterator i = dineroRecibido.iterator();  
        Iterator iCaja = this.getComposiciones().iterator();
        while (i.hasNext()){
            //Para cada dinero recibido, recorre la caja hasta encontrar el objeto de composicionCaja del Dinero,
            //correspondiente al dinero recibido y actualiza la cantidad del mismo.
            MovimientoDinero movimientoDinero =(MovimientoDinero) i.next();
            while(iCaja.hasNext())
            {
                ComposicionCaja composicionCaja = (ComposicionCaja) iCaja.next();
                if(movimientoDinero.getDinero().equals(composicionCaja.getDinero()))
                    composicionCaja.setCantidad(composicionCaja.getCantidad() + movimientoDinero.getCantidad());
            }      
       
        }
    }
    
    public ArrayList<MovimientoDinero> calcularBilletesVuelto(float montoVuelto)
    {
    
        ArrayList<MovimientoDinero> movDineroVuelto = new ArrayList<>();
        Iterator iCaja = this.getComposiciones().iterator();
            float montoTotalCaja=0;
            while(iCaja.hasNext())
            {
                ComposicionCaja composicionCaja = (ComposicionCaja) iCaja.next();
                montoTotalCaja += composicionCaja.getCantidad() * composicionCaja.getDinero().getValor();}
            if(montoTotalCaja<montoVuelto)
            {
                //NO HAY DINERO DISPONIBLE PARA EL VUELTO 
                //Falta ver como lo manejamos....excepción?
            }
            else
            {
                //Ordenamos de mayor a menor los billetes de la Caja (objetos ComposicionCaja)                
                this.composiciones.sort(null);
                boolean flag=false;
                while(flag==false) 
                {
                    for (ComposicionCaja composicionCaja : this.getComposiciones()) {
                        //Preguntamos si el valor del dinero de dicho objeto es menor o igual al monto del vuelto.
                        
                        if(composicionCaja.getDinero().getValor()<= montoVuelto)
                        {
                            //En caso de que sí sea menor o igual entonces ese valor de dinero nos sirve para el vuelto.
                            //Debemos seleccionarlo para extraerlo de la caja:
                            //Restamos la cantiadd de dinero disponible en caja en 1.
                            //Restamos del vuelto el valor del dinero que ya hemos seleccionado.
                            composicionCaja.setCantidad(composicionCaja.getCantidad() -1);
                            montoVuelto= montoVuelto - composicionCaja.getDinero().getValor();
                            if(montoVuelto==0)
                                flag=true;
                            //Agregamos a la lista de Objetos dinero, el dinero que seleccionamos para formar el valor
                            //del vuelto
                            if(movDineroVuelto.isEmpty())
                            {
                                MovimientoDinero mov = new MovimientoDinero(1,composicionCaja.getDinero());
                                movDineroVuelto.add(mov);
                            }
                            else {
                                boolean encontrado = false;
                                for (MovimientoDinero movDinero: movDineroVuelto) {
                                    if(movDinero.getDinero().equals(composicionCaja.getDinero())) {
                                        movDinero.setCantidad(movDinero.getCantidad()+1);
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    MovimientoDinero mov = new MovimientoDinero(1,composicionCaja.getDinero());
                                    movDineroVuelto.add(mov);
                                }
                            }
                        }
                    }
                }
            }
            
            return movDineroVuelto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ComposicionCaja c : composiciones) {
            sb.append("\n");
            sb.append(c.toString());
            
        }
        return sb.toString();
    }
    
    
    
}
