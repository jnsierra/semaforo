/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.logica;

import co.com.ud.semaforo.presentacion.Vista;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 *
 * @author sierraj
 */
public class EscucharServerLogica extends Thread{
    
    private Socket socket;
    private Logger log = Logger.getLogger(EscucharServerLogica.class);
    private Vista vista;

    public EscucharServerLogica(Socket socket, Vista vista) {
        this.socket = socket;
        this.vista = vista;
    }
    
    @Override
    public void run() {
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                vista.getMsnServer().setText(mensaje);
                vista.getSemaforoModel().ejecutarAccion(mensaje);
            } catch (IOException ex) {
                log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
        
    }
    
}
