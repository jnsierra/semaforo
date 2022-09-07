/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.dto.SemaforoDto;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Getter
@Setter
public class Vista extends javax.swing.JFrame {

    private Lienzo lienzo = new Lienzo();
    private SemaforoDto semaforoVehicular;
    private SemaforoDto semaforoPeatonal;
    private SemaforoControlador semaforoControlador;
    private SemaforoModel semaforoModel;

    /**
     * Creates new form Vista
     * @param semaforoControlador Controlador de la vista
     */
    public Vista(SemaforoModel semaforoModel) {
        this.semaforoModel = semaforoModel;
        if(Objects.isNull(this.semaforoControlador)){
            this.semaforoControlador = new SemaforoControlador(this);
        }
        this.setContentPane(lienzo);
        initComponents();
        capturarEventos();
    }

    public void repintarSemaforos() {
        lienzo.setSemaforoVehicular(semaforoVehicular);
        lienzo.setSemaforoPeatonal(semaforoPeatonal);
        lienzo.repaint();
        //lienzo.revalidate();
    }
    
    private void capturarEventos(){
        ejecutorBoton.addActionListener(semaforoControlador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoUno = new javax.swing.ButtonGroup();
        grupoDos = new javax.swing.ButtonGroup();
        tipoSemaforoGroup = new javax.swing.ButtonGroup();
        opcRojo = new javax.swing.JRadioButton();
        opcAmarillo = new javax.swing.JRadioButton();
        opcVerde = new javax.swing.JRadioButton();
        ejecutorBoton = new javax.swing.JButton();
        opcEncender = new javax.swing.JRadioButton();
        opcApagar = new javax.swing.JRadioButton();
        opcRomper = new javax.swing.JRadioButton();
        checkBoxPeatonal = new javax.swing.JCheckBox();
        checkBoxVehicular = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoUno.add(opcRojo);
        opcRojo.setSelected(true);
        opcRojo.setText("Rojo");
        opcRojo.setToolTipText("");
        getContentPane().add(opcRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 40, -1, -1));

        grupoUno.add(opcAmarillo);
        opcAmarillo.setText("Amarillo");
        getContentPane().add(opcAmarillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 66, -1, -1));

        grupoUno.add(opcVerde);
        opcVerde.setText("Verde");
        getContentPane().add(opcVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 92, -1, -1));

        ejecutorBoton.setText("Ejecutar");
        getContentPane().add(ejecutorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, -1));

        grupoDos.add(opcEncender);
        opcEncender.setText("Encender");
        getContentPane().add(opcEncender, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 40, -1, -1));

        grupoDos.add(opcApagar);
        opcApagar.setSelected(true);
        opcApagar.setText("Apagar");
        getContentPane().add(opcApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 66, -1, -1));

        grupoDos.add(opcRomper);
        opcRomper.setText("Romper");
        getContentPane().add(opcRomper, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 92, -1, -1));

        checkBoxPeatonal.setText("Peatonal");
        getContentPane().add(checkBoxPeatonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));

        checkBoxVehicular.setSelected(true);
        checkBoxVehicular.setText("Vehicular");
        getContentPane().add(checkBoxVehicular, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxPeatonal;
    private javax.swing.JCheckBox checkBoxVehicular;
    private javax.swing.JButton ejecutorBoton;
    private javax.swing.ButtonGroup grupoDos;
    private javax.swing.ButtonGroup grupoUno;
    private javax.swing.JRadioButton opcAmarillo;
    private javax.swing.JRadioButton opcApagar;
    private javax.swing.JRadioButton opcEncender;
    private javax.swing.JRadioButton opcRojo;
    private javax.swing.JRadioButton opcRomper;
    private javax.swing.JRadioButton opcVerde;
    private javax.swing.ButtonGroup tipoSemaforoGroup;
    // End of variables declaration//GEN-END:variables
}
