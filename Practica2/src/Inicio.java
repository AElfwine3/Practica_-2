
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ushi
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    static String[] disparos = new String[4];

    Control config = new Control();
    stage jugar = new stage();
    teclaso ventana = new teclaso();

    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bini = new javax.swing.JButton();
        bconfig = new javax.swing.JButton();
        bcarga = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Practica 2");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("CUPHEAD");

        bini.setText("Iniciar");
        bini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biniActionPerformed(evt);
            }
        });

        bconfig.setText("Configuracion");
        bconfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bconfigActionPerformed(evt);
            }
        });

        bcarga.setText("Cargar");
        bcarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcargaActionPerformed(evt);
            }
        });

        bsalir.setText("Salir");
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bconfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(bini)
                .addGap(18, 18, 18)
                .addComponent(bconfig)
                .addGap(18, 18, 18)
                .addComponent(bcarga)
                .addGap(18, 18, 18)
                .addComponent(bsalir)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void biniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biniActionPerformed
        // TODO add your handling code here:
        if (ventana.keyderecha == -1 || ventana.keyizquierda == -1 || ventana.keysalto == -1 || ventana.keydisparo1 == -1 || ventana.keydisparo2 == -1 || config.indice_1 == -1) {
            JOptionPane.showMessageDialog(null, "Configure Todos los Controles", "Configuracion Incorrecta", JOptionPane.PLAIN_MESSAGE);
        } else {
            //jugar.Vida_Jefe = 40;
            //jugar.vida = 3;
            this.dispose();
            jugar.setVisible(true);
            stage.Disparos_Jefes = "stage1";
        }
    }//GEN-LAST:event_biniActionPerformed

    private void bconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconfigActionPerformed
        // TODO add your handling code here:
        this.dispose();
        config.setVisible(true);
    }//GEN-LAST:event_bconfigActionPerformed

    private void bcargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcargaActionPerformed
        // TODO add your handling code here:

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Seleccion un Archivo de Configuracion");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Config", "config");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showDialog(null, "A Jugar!");
        //int returnValue = jfc.showDialog(null, "A button!");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println(jfc.getSelectedFile().getPath());

            InputStream ins = null;
            Reader r = null;
            BufferedReader br = null;
            try {
                String s;
                ins = new FileInputStream(jfc.getSelectedFile().getPath());
                r = new InputStreamReader(ins, "UTF-8");
                br = new BufferedReader(r);
                while ((s = br.readLine()) != null) {
                    String campos[] = s.split("%%");
                    if (campos[0].equals("CUPHEAD")) {
                        for (int i = 0; i < disparos.length; i++) {
                            if (disparos[i] == null) {
                                disparos[i] = campos[1];
                                System.out.println(disparos[i] + "");
                                break;
                            }
                        }
                        for (int i = 0; i < jugar.velocidad.length; i++) {
                            if (jugar.velocidad[i] == 0) {
                                jugar.velocidad[i] = Integer.parseInt(campos[2]) * 10;
                                System.out.println(jugar.velocidad[i] + "");
                                break;
                            }
                        }
                        for (int i = 0; i < jugar.daños.length; i++) {
                            if (jugar.daños[i] == 0) {
                                jugar.daños[i] = Integer.parseInt(campos[3]);
                                System.out.println(jugar.daños[i] + "");
                                break;
                            }
                        }
                        System.out.println(campos[1] + " - " + disparos[3] + "\n");
                    } else if (campos[0].equals("JEFE")) {
                        jugar.NombreJefe = campos[1];
                    }
                }
                JOptionPane.showMessageDialog(null, "Datos Cargados", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se Cargaron los Datos" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                System.err.println(e.getMessage());
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (Throwable t) {
                    }
                }
                if (r != null) {
                    try {
                        r.close();
                    } catch (Throwable t) {
                    }
                }
                if (ins != null) {
                    try {
                        ins.close();
                    } catch (Throwable t) {
                    }
                }
            }
        }
    }//GEN-LAST:event_bcargaActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bsalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcarga;
    private javax.swing.JButton bconfig;
    private javax.swing.JButton bini;
    private javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}