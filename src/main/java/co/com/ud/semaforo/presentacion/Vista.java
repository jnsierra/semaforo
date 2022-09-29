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
        lienzo.setSemaforoUno(semaforoVehicular);
        lienzo.setSemaforoDos(semaforoPeatonal);
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
        ejecutorBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ipTextField = new javax.swing.JTextField();
        portTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        msnServer = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ejecutorBoton.setText("Conectar");
        ejecutorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutorBotonActionPerformed(evt);
            }
        });
        getContentPane().add(ejecutorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jLabel1.setText("IP:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        jLabel2.setText("PUERTO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        ipTextField.setText("localhost");
        getContentPane().add(ipTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 110, -1));

        portTextField.setText("1234");
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(portTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 110, -1));

        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        estadoLabel.setText("DESCONECTADO");
        getContentPane().add(estadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 120, -1));

        jLabel4.setText("Mensaje enviado por el server");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        msnServer.setText("MSN");
        getContentPane().add(msnServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 200, -1));

        labelNombre.setText("ESTE ES EL NOMBRE");
        getContentPane().add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 130, -1));

        jLabel6.setText("ID:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 20, -1));

        jLabel7.setText("NOMBRE:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 70, -1));

        labelId.setText("ESTE ES EL ID");
        getContentPane().add(labelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutorBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ejecutorBotonActionPerformed

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ejecutorBoton;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.ButtonGroup grupoDos;
    private javax.swing.ButtonGroup grupoUno;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel msnServer;
    private javax.swing.JTextField portTextField;
    private javax.swing.ButtonGroup tipoSemaforoGroup;
    // End of variables declaration//GEN-END:variables
}
