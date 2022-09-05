/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.vista;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.modelo.SemaforoVehicularModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
public class Lienzo extends JPanel {

    private Graphics graphics;
    @Getter
    @Setter
    private SemaforoVehicularModel semaforoVehicularModel;

    private int puntoX;
    private int puntoY;

    public void paintComponent(Graphics graphics) {
        this.graphics = graphics;
        if (Objects.nonNull(this.semaforoVehicularModel)) {
            this.puntoX = this.semaforoVehicularModel.getX();
            this.puntoY = this.semaforoVehicularModel.getY();
            pintarSemaforoVehicular();
        }
    }

    public void pintarSemaforoVehicular() {
        for (int i = 0; i < semaforoVehicularModel.getNumCopias(); i++) {
            int adicion = 200 * i;
            
            int semaforoX = puntoX + 35 + adicion;
            int semaforoY = puntoY + 20;
            pintarFondoBlanco(semaforoX, semaforoY);
            pintarTitulo(semaforoX-30, puntoY, i +1);
            graphics.setColor(Color.BLACK);
            //Cuadro principal semaforo
            graphics.fillRect(semaforoX, semaforoY, 5, 140);
            graphics.fillRect(semaforoX + 80, semaforoY, 5, 140);
            graphics.fillRect(semaforoX, semaforoY, 80, 5);
            graphics.fillRect(semaforoX, semaforoY + 140, 85, 5);
            //Circulos de las luces
            graphics.drawOval(semaforoX + 25, semaforoY + 10, 30, 30);

            graphics.drawOval(semaforoX + 25, semaforoY + 54, 30, 30);

            graphics.drawOval(semaforoX + 25, semaforoY + 99, 30, 30);
            pintarLucesEncendidas(semaforoX, semaforoY);
            pintarLucesRotas(semaforoX, semaforoY);
        }

    }

    public void pintarFondoBlanco(int x, int y) {
        graphics.setColor(Color.white);
        graphics.fillRect(x - 35, y - 20, 150, 200);

    }

    public void pintarTitulo(int x, int y, int iterator) {
        graphics.setColor(Color.BLACK);
        int fontSize = 10;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        graphics.setFont(f);
        graphics.drawString(semaforoVehicularModel.getTitulo()+ " (" + iterator + ")" , x, y + 12);
    }

    public void pintarLucesEncendidas(int x, int y) {
        if (Objects.nonNull(semaforoVehicularModel)) {
            if (ColorEnum.RED.equals(semaforoVehicularModel.getRojo().getColor()) && EstadoEnum.ENCENDIDO.equals(semaforoVehicularModel.getRojo().getEstado())) {
                graphics.setColor(Color.red);
                graphics.fillOval(x + 24, y + 9, 32, 32);
            }
            if (ColorEnum.ORANGE.equals(semaforoVehicularModel.getAmarillo().getColor()) && EstadoEnum.ENCENDIDO.equals(semaforoVehicularModel.getAmarillo().getEstado())) {
                graphics.setColor(Color.ORANGE);
                graphics.fillOval(x + 24, y + 53, 32, 32);
            }
            if (ColorEnum.GREEN.equals(semaforoVehicularModel.getVerde().getColor()) && EstadoEnum.ENCENDIDO.equals(semaforoVehicularModel.getVerde().getEstado())) {
                graphics.setColor(Color.GREEN);
                graphics.fillOval(x + 24, y + 98, 32, 32);
            }
        }
    }

    public void pintarLucesRotas(int x, int y) {
        if (Objects.nonNull(semaforoVehicularModel)) {
            if (ColorEnum.RED.equals(semaforoVehicularModel.getRojo().getColor()) && EstadoEnum.ROTO.equals(semaforoVehicularModel.getRojo().getEstado())) {
                graphics.setColor(Color.red);
                graphics.fillOval(x + 24, y + 9, 32, 32);
                graphics.setColor(Color.black);
                graphics.drawLine(x + 24, y + 9, x + 24 + 32, y + 9 + 32);
            }
            if (ColorEnum.ORANGE.equals(semaforoVehicularModel.getAmarillo().getColor()) && EstadoEnum.ROTO.equals(semaforoVehicularModel.getAmarillo().getEstado())) {
                graphics.setColor(Color.ORANGE);
                graphics.fillOval(x + 24, y + 53, 32, 32);
                graphics.setColor(Color.black);
                graphics.drawLine(x + 24, y + 53, x + 56, y + 85);
            }
            if (ColorEnum.GREEN.equals(semaforoVehicularModel.getVerde().getColor()) && EstadoEnum.ROTO.equals(semaforoVehicularModel.getVerde().getEstado())) {
                graphics.setColor(Color.GREEN);
                graphics.fillOval(x + 24, y + 98, 32, 32);
                graphics.setColor(Color.black);
                graphics.drawLine(x + 24, y + 98, x + 56, y + 130);
            }
        }
    }

}
