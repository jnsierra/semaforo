/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package co.com.ud.semaforo;

import co.com.ud.semaforo.controlador.SemaforoControlador;

/**
 *
 * @author Usuario
 */
public class Semaforo {

    public Semaforo() {
        SemaforoControlador semaforoControlador = new SemaforoControlador();
        semaforoControlador.iniciar();
    }

    public static void main(String[] args) {
        System.out.println("Llego al main");
        Semaforo semaforo = new Semaforo();
    }
}
