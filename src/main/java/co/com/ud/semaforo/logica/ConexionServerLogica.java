package co.com.ud.semaforo.logica;


import java.io.IOException;
import java.net.Socket;
import lombok.Data;
import org.apache.log4j.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sierraj
 */
@Data
public class ConexionServerLogica {
    
    private String ip;
    private int puerto;
    private Socket socket;
    private Logger log = Logger.getLogger(ConexionServerLogica.class);
    
    public ConexionServerLogica(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }
    
    public Boolean conectarServer(){
        try {
            this.socket = new Socket(this.ip, this.puerto);
        } catch (IOException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    
    
}
