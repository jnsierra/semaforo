package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.enumeration.TipoSemaforo;
import co.com.ud.semaforo.dto.LuzSemaforoDto;
import co.com.ud.semaforo.dto.SemaforoDto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    private SemaforoDto semaforoVehicular;
    @Getter
    @Setter
    private SemaforoDto semaforoPeatonal;

    public void paintComponent(Graphics graphics) {
        this.graphics = graphics;
        if (Objects.nonNull(this.semaforoVehicular)) {
            if (TipoSemaforo.VEHICULAR.equals(semaforoVehicular.getTipoSemaforo())) {
                pintarSemaforo(semaforoVehicular);
            }
            if (TipoSemaforo.PEATONAL.equals(semaforoPeatonal.getTipoSemaforo())) {
                pintarSemaforo(semaforoPeatonal);
            }
        }
    }

    public void pintarSemaforo(SemaforoDto semaforo) {
        for (int i = 0; i < semaforo.getNumCopias(); i++) {
            int adicion = 200 * i;

            int semaforoX = semaforo.getX() + 35 + adicion;
            int semaforoY = semaforo.getY() + 20;
            pintarFondoBlanco(semaforoX, semaforoY);
            pintarTitulo(semaforoX - 30, semaforoY - 20, i + 1, semaforo.getTitulo());
            pintarCuadrado(semaforoX, semaforoY, (semaforo.getLuces().size() * 46), 80, semaforo.getLuces().size());
            pintarLuces(semaforo, semaforoX, semaforoY);
        }

    }

    public void pintarFondoBlanco(int x, int y) {
        graphics.setColor(Color.white);
        graphics.fillRect(x - 35, y - 20, 150, 200);

    }

    public void pintarTitulo(int x, int y, int iterator, String titulo) {
        graphics.setColor(Color.BLACK);
        int fontSize = 10;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        graphics.setFont(f);
        graphics.drawString(titulo + " (" + iterator + ")", x, y + 12);
    }

    public void pintarCuadrado(int semaforoX, int semaforoY, int largo, int ancho, int items) {
        graphics.setColor(Color.BLACK);
        //Cuadro principal semaforo
        //Lineas Vertical
        graphics.fillRect(semaforoX, semaforoY, 5, largo);
        graphics.fillRect(semaforoX + ancho, semaforoY, 5, largo);
        //Lineas Horizontales
        graphics.fillRect(semaforoX, semaforoY, ancho, 5);
        graphics.fillRect(semaforoX, semaforoY + largo, ancho + 5, 5);

        //Circulos de las luces
        for (int i = 0; i < items; i++) {
            graphics.drawOval(semaforoX + 25, semaforoY + 10 + (i * 45), 30, 30);
        }
    }

    public void pintarLuces(SemaforoDto semaforo, int x, int y) {
        if (Objects.nonNull(semaforo)) {
            for (LuzSemaforoDto luz : semaforo.getLuces()) {
                if (EstadoEnum.ENCENDIDO.equals(luz.getEstado()) || EstadoEnum.ROTO.equals(luz.getEstado())) {
                    int posicion = -1;
                    if (ColorEnum.RED.equals(luz.getColor())) {
                        graphics.setColor(Color.RED);
                        posicion = 0;
                    }
                    if (ColorEnum.ORANGE.equals(luz.getColor())) {
                        graphics.setColor(Color.ORANGE);
                        posicion = 1;
                    }
                    if (ColorEnum.GREEN.equals(luz.getColor())) {
                        graphics.setColor(Color.GREEN);
                        if (TipoSemaforo.PEATONAL.equals(semaforo.getTipoSemaforo())) {
                            posicion = 1;
                        } else {
                            posicion = 2;
                        }
                    }
                    graphics.fillOval(x + 24, y + 9 + (45 * posicion), 32, 32);
                    if (EstadoEnum.ROTO.equals(luz.getEstado())) {
                        graphics.setColor(Color.black);
                        graphics.drawLine(x + 24, y + 9 + (posicion * 45), x + 56, y + 45 + (posicion * 45));
                    }
                }
            }
        }
    }

}
