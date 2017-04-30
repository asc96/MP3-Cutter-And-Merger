
package MP3;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Merger extends javax.swing.JFrame {

    

    PlayerMain pm=new PlayerMain();
    public String song;
    public String song1;
    
    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //To change body of generated methods, choose Tools | Templates.
    }
    public Merger() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Firstone = new javax.swing.JButton();
        Secondone = new javax.swing.JButton();
        Merge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Firstone.setText("Choose First File ");
        Firstone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FirstoneMousePressed(evt);
            }
        });

        Secondone.setText("Choose Second File");
        Secondone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SecondoneMouseReleased(evt);
            }
        });

        Merge.setText("Merge");
        Merge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MergeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Firstone)
                .addGap(35, 35, 35)
                .addComponent(Secondone)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Merge, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Firstone)
                    .addComponent(Secondone))
                .addGap(18, 18, 18)
                .addComponent(Merge)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FirstoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FirstoneMousePressed
        // TODO add your handling code here:
        FileFilter filter =new FileNameExtensionFilter("MP3 Files","mp3");
        JFileChooser chooser = new JFileChooser("G:\\songs");
        chooser.addChoosableFileFilter(filter);
        
        int flag= chooser.showOpenDialog(null);
        
        if(flag==JFileChooser.APPROVE_OPTION)
        {
            File myFile =chooser.getSelectedFile();
             song = myFile + "";
        }
    }//GEN-LAST:event_FirstoneMousePressed

    private void SecondoneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecondoneMouseReleased
        // TODO add your handling code here:
        FileFilter filter =new FileNameExtensionFilter("MP3 Files","mp3");
        JFileChooser chooser = new JFileChooser("G:\\songs");
        chooser.addChoosableFileFilter(filter);
        
        int flag= chooser.showOpenDialog(null);
        
        if(flag==JFileChooser.APPROVE_OPTION)
        {
            File myFile =chooser.getSelectedFile();
             song1 = myFile + "";
        }
    }//GEN-LAST:event_SecondoneMouseReleased

    private void MergeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MergeMouseReleased
        try {
            // TODO add your handling code here:
            pm.Merge(song,song1);
        } catch (IOException ex) {
            Logger.getLogger(Merger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_MergeMouseReleased
   
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
            java.util.logging.Logger.getLogger(Merger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Merger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Merger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Merger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Merger().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Firstone;
    private javax.swing.JButton Merge;
    private javax.swing.JButton Secondone;
    // End of variables declaration//GEN-END:variables
}
