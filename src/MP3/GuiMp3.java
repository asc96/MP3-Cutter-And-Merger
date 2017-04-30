
package MP3;

import com.sun.scenario.effect.Merge;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static org.eclipse.persistence.config.FlushClearCache.Merge;
import static org.eclipse.persistence.sessions.SessionProfiler.Merge;


public class GuiMp3 extends javax.swing.JFrame {
    
    PlayerMain pm= new PlayerMain();
    
    
    //private PlayingTimer timer;
    
    public GuiMp3() {
        initComponents();
        sliderTime.setValue(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pause = new javax.swing.JButton();
        play = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        choosefile = new javax.swing.JButton();
        timeCounter = new javax.swing.JLabel();
        duration = new javax.swing.JLabel();
        StartTime = new javax.swing.JButton();
        EndTime = new javax.swing.JButton();
        Cut = new javax.swing.JButton();
        sliderTime = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        Media = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Merge = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pause.setText("Pause");
        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pauseMouseReleased(evt);
            }
        });

        play.setText("Play");
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playMouseReleased(evt);
            }
        });

        stop.setText("Stop");
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopMouseReleased(evt);
            }
        });

        choosefile.setText("Choose File..");
        choosefile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                choosefileMouseReleased(evt);
            }
        });
        choosefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosefileActionPerformed(evt);
            }
        });

        StartTime.setText("Get Start Time");
        StartTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StartTimeMouseReleased(evt);
            }
        });

        EndTime.setText("Get End Time");
        EndTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EndTimeMouseReleased(evt);
            }
        });

        Cut.setText("Cut");
        Cut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CutMouseReleased(evt);
            }
        });

        sliderTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sliderTimeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sliderTimeMouseReleased(evt);
            }
        });

        Media.setText("Media");

        Open.setText("Open");
        Media.add(Open);

        Merge.setText("Merge");
        Merge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MergeActionPerformed(evt);
            }
        });
        Media.add(Merge);

        jMenuBar1.add(Media);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choosefile)
                        .addGap(31, 31, 31)
                        .addComponent(StartTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EndTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cut, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(timeCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duration)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeCounter)
                    .addComponent(duration)
                    .addComponent(sliderTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pause)
                    .addComponent(play)
                    .addComponent(stop)
                    .addComponent(choosefile)
                    .addComponent(StartTime)
                    .addComponent(EndTime)
                    .addComponent(Cut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseReleased
        // TODO add your handling code here:
        pm.Pause();
    }//GEN-LAST:event_pauseMouseReleased

    private void playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseReleased
        try {
            // TODO add your handling code here:
            pm.Start(sliderTime,timeCounter);
        } catch (IOException ex) {
            Logger.getLogger(GuiMp3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_playMouseReleased

    private void stopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseReleased
        // TODO add your handling code here:
        pm.Stop();
    }//GEN-LAST:event_stopMouseReleased

    private void choosefileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choosefileMouseReleased
        // TODO add your handling code here:
        //timer =  new PlayingTimer(timeCounter,sliderTime);
        
        
        FileFilter filter =new FileNameExtensionFilter("MP3 Files","mp3");
        JFileChooser chooser = new JFileChooser("G:\\songs");
        chooser.addChoosableFileFilter(filter);
        
        int flag= chooser.showOpenDialog(null);
        
        if(flag==JFileChooser.APPROVE_OPTION)
        {
            File myFile =chooser.getSelectedFile();
            String song = myFile + "";
            
            pm.Stop();
            
            try {
                
                pm.Play(song,sliderTime,timeCounter);
            } catch (IOException ex) {
                
                Logger.getLogger(GuiMp3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }//GEN-LAST:event_choosefileMouseReleased

    private void choosefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosefileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choosefileActionPerformed

    private void StartTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartTimeMouseReleased
        // TODO add your handling code here:
         pm.stime=sliderTime.getValue();
         System.out.println("start time = "+pm.stime);

    }//GEN-LAST:event_StartTimeMouseReleased

    private void EndTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EndTimeMouseReleased
        // TODO add your handling code here:\
        pm.etime=sliderTime.getValue();
        System.out.println("end time = "+pm.etime);
    }//GEN-LAST:event_EndTimeMouseReleased

    private void CutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CutMouseReleased
        try {
           
            pm.cut();
        } catch (IOException ex) {
            Logger.getLogger(GuiMp3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CutMouseReleased

    private void sliderTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderTimeMouseReleased
        // TODO add your handling code here:
         /*try {
            pm.t2.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(GuiMp3.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        int slide=sliderTime.getValue();
        pm.pauseLocation=pm.totalLength-slide;
        
        if(pm.player!=null){
            pm.player.close();
            pm.player=null;
   
        }
        
        sliderTime.setValue(slide); 
        if(!pm.isPaused)
            pm.Resume();
       
       
       /*int slide=sliderTime.getValue();
       int prevSlider;
        try {
            prevSlider = pm.fis.available();
            pm.fis.skip(slide-(pm.totalLength-prevSlider));
           
        } catch (IOException ex) {
            Logger.getLogger(GuiMp3.class.getName()).log(Level.SEVERE, null, ex);
        }
       */
    }//GEN-LAST:event_sliderTimeMouseReleased

    private void sliderTimeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderTimeMousePressed
        // TODO add your handling code here:
        //        try {
//            // TODO add your handling code here:
//            // pm.t2.interrupt();
//            pm.t2.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(GuiMp3.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_sliderTimeMousePressed
     
    private void MergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MergeActionPerformed
        // TODO add your handling code here:
     //  this.setVisible(false);
       Merger mer=new Merger();
       mer.setVisible(true);
    
     
     //mer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     
    }//GEN-LAST:event_MergeActionPerformed

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
            java.util.logging.Logger.getLogger(GuiMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMp3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cut;
    private javax.swing.JButton EndTime;
    private javax.swing.JMenu Media;
    private javax.swing.JMenuItem Merge;
    private javax.swing.JMenuItem Open;
    private javax.swing.JButton StartTime;
    private javax.swing.JButton choosefile;
    private javax.swing.JLabel duration;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JSlider sliderTime;
    private javax.swing.JButton stop;
    private javax.swing.JLabel timeCounter;
    // End of variables declaration//GEN-END:variables
   
}
