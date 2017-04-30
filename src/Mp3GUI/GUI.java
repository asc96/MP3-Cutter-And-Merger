
package Mp3GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

public class GUI extends javax.swing.JFrame {

     Player audioPlayer = null;
    String audioPath = "";
    
    public GUI() {
        initComponents();
        audioPath = "G:\\songs\\Maroon 5 - Animals.mp3";
        initAudioPlayer(audioPath);     
    }
    
     private void initAudioPlayer(String pathname) {
        try {
            URL url = new File(pathname).toURL();
            audioPlayer = Manager.createRealizedPlayer(url);
        } catch (IOException | NoPlayerException | CannotRealizeException ex) {
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PauseButton = new javax.swing.JButton();
        PlayButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PauseButton.setText("Pause");
        PauseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseButtonMouseReleased(evt);
            }
        });

        PlayButton.setText("Play");
        PlayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayButtonMouseReleased(evt);
            }
        });

        StopButton.setText("Stop");
        StopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StopButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PauseButton)
                    .addComponent(PlayButton)
                    .addComponent(StopButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PauseButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseButtonMouseReleased
        // TODO add your handling code here:
        audioPlayer.stop();
    }//GEN-LAST:event_PauseButtonMouseReleased

    private void PlayButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayButtonMouseReleased
        // TODO add your handling code here:
        audioPlayer.start();
    }//GEN-LAST:event_PlayButtonMouseReleased

    private void StopButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopButtonMouseReleased
        // TODO add your handling code here:
        audioPlayer.stop();
        audioPlayer.setMediaTime(new Time(0.0));
    }//GEN-LAST:event_StopButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PauseButton;
    private javax.swing.JButton PlayButton;
    private javax.swing.JButton StopButton;
    // End of variables declaration//GEN-END:variables
}
