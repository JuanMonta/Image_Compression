package com.crowie;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import jnafilechooser.api.JnaFileChooser;

public class TestCompress extends javax.swing.JFrame {

    private float compressionValue = 0.8f;
    private String originalImagePath = null;
    
    public TestCompress() {
        initComponents();
        this.jSlider1.addChangeListener((e)->{
            this.compressionValue = this.jSlider1.getValue()/100.0f;
            this.lb_RazonCompresion.setText(this.jSlider1.getValue() + "%");
            
        });
         this.checkB_Default.addChangeListener(((e) -> {
                this.lb_RelAncho.setEnabled(!this.checkB_Default.isSelected());
                this.lb_RelAlto.setEnabled(!this.checkB_Default.isSelected());
                this.checkB_ForzarDim.setEnabled(!this.checkB_Default.isSelected());
        }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Original = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        lb_Compressed = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        lb_RazonCompresion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_TipoImagen = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_RelAncho = new javax.swing.JTextField();
        lb_RelAlto = new javax.swing.JTextField();
        checkB_Default = new javax.swing.JCheckBox();
        checkB_ForzarDim = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_Original.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("ELEGIR IMAGEN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        lb_Compressed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMPRESSED");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ORIGINAL");

        jSlider1.setValue(80);
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        lb_RazonCompresion.setText("80%");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PORCENTAJE DE COMPRESIÓN");

        cb_TipoImagen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JPG", "JPEG", "PNG" }));
        cb_TipoImagen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_TipoImagenItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Convertir imagen a relación de aspecto.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("X");

        lb_RelAncho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_RelAncho.setText("1920");
        lb_RelAncho.setEnabled(false);
        lb_RelAncho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb_RelAnchoActionPerformed(evt);
            }
        });
        lb_RelAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lb_RelAnchoKeyTyped(evt);
            }
        });

        lb_RelAlto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_RelAlto.setText("1080");
        lb_RelAlto.setEnabled(false);
        lb_RelAlto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb_RelAltoActionPerformed(evt);
            }
        });
        lb_RelAlto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lb_RelAltoKeyTyped(evt);
            }
        });

        checkB_Default.setSelected(true);
        checkB_Default.setText("Default");
        checkB_Default.setToolTipText("No convertir imagen a una relación de aspecto.");
        checkB_Default.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        checkB_Default.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkB_DefaultItemStateChanged(evt);
            }
        });

        checkB_ForzarDim.setText("Forzar dimensiones");
        checkB_ForzarDim.setEnabled(false);
        checkB_ForzarDim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkB_ForzarDimItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_RelAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_RelAlto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(checkB_Default, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkB_ForzarDim, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkB_Default)
                    .addComponent(lb_RelAncho, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lb_RelAlto)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkB_ForzarDim))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lb_RazonCompresion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(cb_TipoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lb_Original, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lb_Compressed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_RazonCompresion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cb_TipoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_Original, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_Compressed, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JnaFileChooser chooser = new JnaFileChooser();
        chooser.addFilter("Imágenes", "jpg", "png", "jpeg");
        boolean returnValue = chooser.showOpenDialog(this);

        if (returnValue) {
            File selectedFile = chooser.getSelectedFile();
            this.originalImagePath = selectedFile.getAbsolutePath();

            ImageIcon imageIcon = new ImageIcon(this.originalImagePath);
            Image imageLb = imageIcon.getImage();
            java.awt.Insets insets = this.lb_Original.getInsets();
            int newWidth = this.lb_Original.getWidth() - insets.left - insets.right;
            int newHeight = this.lb_Original.getHeight() - insets.top - insets.bottom;
            Image newimg = imageLb.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
            this.lb_Original.setIcon(new ImageIcon(newimg));

            String sizeSimbol = "b";
            long fileSizeInBytes = selectedFile.length();
            double fileSize = fileSizeInBytes;

            if (fileSize >= 1024.0) {
                fileSize /= 1024.0;
                sizeSimbol = "Kb";
            }
            if (fileSize > 1024.0) {
                fileSize /= 1024.0;
                sizeSimbol = "MB";
            }
            if (fileSize > 1024.0) {
                fileSize /= 1024.0;
                sizeSimbol = "GB";
            }

            this.jTextArea1.setText("");
            //this.jTextArea1.append("Ruta: " + this.originalImagePath + "\n");
            this.jTextArea1.append("Peso: " + String.format("%.5f", fileSize) +" "+sizeSimbol +"\n");

            try {
                BufferedImage image = ImageIO.read(selectedFile);
                this.jTextArea1.append("Dimensiones: " + image.getWidth() + "x" + image.getHeight() + "\n");
            } catch (IOException ex) {
                Logger.getLogger(TestCompress.class.getName()).log(Level.SEVERE, null, ex);
            }

            actualizarCompressedImage();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
        this.actualizarCompressedImage();
    }//GEN-LAST:event_jSlider1MouseReleased

    private void cb_TipoImagenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_TipoImagenItemStateChanged
       this.actualizarCompressedImage();
    }//GEN-LAST:event_cb_TipoImagenItemStateChanged

    private void lb_RelAnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lb_RelAnchoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }else if(Character.isWhitespace(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_lb_RelAnchoKeyTyped

    private void lb_RelAltoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lb_RelAltoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }else if(Character.isWhitespace(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_lb_RelAltoKeyTyped

    private void checkB_DefaultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkB_DefaultItemStateChanged
        this.actualizarCompressedImage();
    }//GEN-LAST:event_checkB_DefaultItemStateChanged

    private void checkB_ForzarDimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkB_ForzarDimItemStateChanged
      this.actualizarCompressedImage();
    }//GEN-LAST:event_checkB_ForzarDimItemStateChanged

    private void lb_RelAltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb_RelAltoActionPerformed
        System.out.println("Presionando Enter");
        this.actualizarCompressedImage();
    }//GEN-LAST:event_lb_RelAltoActionPerformed

    private void lb_RelAnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb_RelAnchoActionPerformed
        System.out.println("Presionando Enter");
        this.actualizarCompressedImage();
    }//GEN-LAST:event_lb_RelAnchoActionPerformed
 private void actualizarCompressedImage() {
        if (this.originalImagePath == null) {
            return; 
        }
        System.out.println("Comprimiendo al "+(this.compressionValue*100)+"% ...");
        
        String compressedImagePath = new ImageCompression()
                .compressImage(this.originalImagePath, 
                        this.compressionValue,
                        this.cb_TipoImagen.getSelectedItem().toString().toLowerCase().trim(),
                        !this.checkB_Default.isSelected(),
                        this.checkB_ForzarDim.isSelected(),
                        Integer.parseInt(this.lb_RelAncho.getText().trim()),
                        Integer.parseInt(this.lb_RelAlto.getText().trim()));

        if (compressedImagePath == null) {
            this.jTextArea2.setText("Error al comprimir la imagen.");
            this.lb_Compressed.setIcon(null);
            return;
        }

        File compressedFile = new File(compressedImagePath);

        ImageIcon imageIcon = new ImageIcon(compressedImagePath);
        Image imageLb = imageIcon.getImage();
        java.awt.Insets insets = this.lb_Compressed.getInsets();
        int newWidth = this.lb_Compressed.getWidth() - insets.left - insets.right;
        int newHeight = this.lb_Compressed.getHeight() - insets.top - insets.bottom;
        Image newimg = imageLb.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
        this.lb_Compressed.setIcon(new ImageIcon(newimg));

        String sizeSimbol = "b";
        long fileSizeInBytes = compressedFile.length();
        double fileSize = fileSizeInBytes;
        if (fileSize >= 1024.0) {
            fileSize /= 1024.0;
            sizeSimbol = "Kb";
        }
        if (fileSize > 1024.0) {
            fileSize /= 1024.0;
            sizeSimbol = "MB";
        }
        if (fileSize > 1024.0) {
            fileSize /= 1024.0;
            sizeSimbol = "GB";
        }

        this.jTextArea2.setText("");
        //this.jTextArea2.append("Ruta: " + compressedImagePath + "\n");
        this.jTextArea2.append("Peso: " + String.format("%.5f", fileSize) + " " + sizeSimbol + "\n");

        try {
            BufferedImage image = ImageIO.read(compressedFile);
            this.jTextArea2.append("Dimensiones: " + (image.getWidth()) + "x" + image.getHeight() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(TestCompress.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Terminado\n");
    }
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestCompress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestCompress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_TipoImagen;
    private javax.swing.JCheckBox checkB_Default;
    private javax.swing.JCheckBox checkB_ForzarDim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lb_Compressed;
    private javax.swing.JLabel lb_Original;
    private javax.swing.JLabel lb_RazonCompresion;
    private javax.swing.JTextField lb_RelAlto;
    private javax.swing.JTextField lb_RelAncho;
    // End of variables declaration//GEN-END:variables
}
