package MP3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


        
public class PlayerMain extends Thread{
    
    JSlider slider=new JSlider();
    JLabel timeCounter=new JLabel("00:00:00" );
    JLabel duration=new JLabel("00:00:00" );
    
    FileInputStream fis;
    BufferedInputStream bis;
    FileOutputStream fos;
    BufferedOutputStream bos;
    public Player player;
    
    public long pauseLocation;
    public long totalLength;
    public long c=1;
    public int stime=0;
    public int etime=0;
    
    public boolean isPaused=false;
    public boolean isStop=false;
    int count=0;
    
    long pauseTime;
    long startTime;
    
    Thread t1;
    Thread t2;
    
    public String songPath;
    public void Stop()
    {
        if(player!=null){
            player.close();
            player=null;
            pauseLocation=0;
            totalLength=0;
            isStop=true;
            slider.setValue(0);
            slider.setMaximum(0);
        }
    }
    
    
    public void Pause() 
    {
        if(player!=null){
            try 
            {
                pauseLocation=fis.available();
                player.close();
                player=null;
                isPaused=true;
            }
            catch (IOException ex) {
                //Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void Play(String path,JSlider s,JLabel tc) throws IOException 
    {
        slider=s;
        timeCounter=tc;
        slider.setMinimum(0);
        count=0;
        if(player==null)
        {
            try 
            {

                songPath= path+"";

                fis= new FileInputStream(path);
                bis=new BufferedInputStream(fis);
                totalLength=fis.available();
                slider.setMaximum((int) totalLength);
                slider.setValue(0);
                player = new Player(bis);
                isStop=false;
                isPaused=false;
            } 
            catch (FileNotFoundException | JavaLayerException ex)
            {
                   System.out.println("Play catch before thread");
            } catch (IOException ex) 
            {
                System.out.println("Play catch before thread");
            }
            
            
            t1=new Thread()
            {
                public void run()
                {

                    try
                    {

                      player.play();
                      //slider.setValue((int) (totalLength-fis.available()));
                      if(player.isComplete())
                          Stop();
                      //System.out.println(".run()");
                      //  t2.start();

                    }
                    catch (JavaLayerException ex)
                    {
                        System.out.println("play catch");
                        Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                        Stop();
                    }
                }
            };
            t1.start();
            
            
            
            t2=new Thread()
            {
                public void run()
                {
                    try 
                    {
                        //t1.wait(1);
                       // startTime = System.currentTimeMillis();
                        
                        while(fis.available()!=0 && !isPaused)
                        {
                            slider.setValue((int) (totalLength-fis.available()));
                            //timeCounter.setText(toTimeString());
                            //count++;
                            t2.sleep(1000);
                            //System.out.println("Slider value"+slider.getValue());
                        }/*
                        pauseTime+=1000;
                        t2.sleep(1000);*/
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("play catch 1");
                        Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                        Stop();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                        Stop();
                    }
                }
            };
            t2.start();
         
        }
    }   
   
    public void Resume() 
    {
        if(player==null)
        {
            try 
            {

                fis= new FileInputStream(songPath);
                bis=new BufferedInputStream(fis);
                //totalLength=fis.available();
                player = new Player(bis);
                //System.out.println("Pause Location -"+c+"-"+pauseLocation+" "+"Total Length"+totalLength);
                //c++;
                fis.skip(totalLength-pauseLocation-42500);
                isPaused=false;
                //totalLength=fis.available();
               
            } 

            catch (FileNotFoundException | JavaLayerException ex)
            {

            } catch (IOException ex) 
            {

            }
            t1=new Thread()
            {
                public void run()
                {
                    try 
                    {
                        
                        player.play();
                        slider.setValue((int) (totalLength-fis.available()));
                        if(player.isComplete())
                          Stop();
                        //t2.start();
                        
                    } 
                    catch (JavaLayerException | IOException ex) 
                    {
                        System.out.println("Resume catch");
                        Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                        Stop();
                    }
                }
            };
            t1.start();
            
            
            t2=new Thread()
            {
               
                public void run()
                {
                   
                    try 
                    {
                        //t1.wait(1);
                        while(fis.available()!=0 && !isPaused)
                        {
                            slider.setValue((int) (totalLength-fis.available()));
                          
                            //timeCounter.setText(toTimeString());
                            //count++;
                            t2.sleep(1000);
                            //System.out.println("Slider value"+slider.getValue());
                        }/*
                        pauseTime+=1000;
                        t2.sleep(1000);*/
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Resume catch 1");
                        Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                        Stop();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                        Stop();
                    }
                }
            };
            t2.start();
        }
    }
    
    public void Start(JSlider s,JLabel tc) throws IOException
    {
        
        if(totalLength==0)
        {
            Play(songPath,s,tc);
        }
        else
        {
            Resume();
        }
    }
    
    public void cut() throws IOException
    {
        if(etime>stime)
        {
            FileInputStream fis1 = null;
            //BufferedInputStream bis1=null;
            byte[] buffer= new byte[4096];
            try {

                try {
                    fis1 = new FileInputStream(songPath);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String fileName=null;
                JFrame frame = new JFrame();
                fileName = JOptionPane.showInputDialog(frame, "Enter File Name:");
                try {
                    fos = new FileOutputStream("G:\\songs\\"+fileName+".mp3");
                } catch (FileNotFoundException ex) {
                    System.out.println("OUTPUT FILE NOT FOUND");
                    Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                //bos = new BufferedOutputStream(fos);

                fis1.skip(stime);
                Path path = Paths.get(songPath);
                buffer = Files.readAllBytes(path);

                int len;
                while ((len=fis1.read(buffer)) > 0 && etime<(totalLength-fis1.available()) ) 
                { 
                    System.out.println("fis1.avilable = "+(totalLength-fis1.available()));
                    fos.write(buffer,0,etime-stime);
                }


            } catch (IOException ex) {
                Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                fis1.close();
                //bos.close();
                fos.close();
            }
            
        }
      
    }
    public void Merge(String path1,String path2) throws IOException
    {
        // System.out.println("MP3 PLAYER XUXUXUXUX");
         FileInputStream fis1 = null;
         FileInputStream fis2 = null;
         FileOutputStream fos = null;
         
         byte[] buffer= new byte[4096];
         
        try {
            fis1=new FileInputStream(path1);
            fis2=new FileInputStream(path2);
        } catch (FileNotFoundException ex) 
        {
            Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
          int totalLength1 = 0;
          int totalLength2 = 0;
          
        try {
            totalLength1=fis1.available();
            totalLength2=fis2.available();
        } catch (IOException ex) {
            Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
          String fileName=null;
          JFrame frame = new JFrame();
          fileName = JOptionPane.showInputDialog(frame, "Enter File Name:");
          
        try {
             fos = new FileOutputStream("G:\\songs\\"+fileName+".mp3");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        SequenceInputStream sis=new SequenceInputStream(fis1,fis2);  
         Path path = Paths.get(path1);
         Path pa = Paths.get(path2);
        try {
            buffer = Files.readAllBytes(path);
            buffer = Files.readAllBytes(pa);
        } catch (IOException ex) {
            Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        //StringBuilder sb = new StringBuilder();
        int len;
        try {
            while ((len=sis.read(buffer)) > 0  )
            {
                //sb.append(buffer);
                fos.write(buffer,0,len);
            }
        } catch (IOException ex) {
            Logger.getLogger(PlayerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            fos.close();
            sis.close();
            fis1.close();
            fis2.close();
        }
        
        
         
    }
    
    

 /* private String toTimeString() throws IOException {
       /* long now = System.currentTimeMillis();
        
        Date current = new Date(now - startTime - pauseTime);
        dateFormater.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timeCounter = dateFormater.format(current);
        return timeCounter;
       String time=null;
      
       /*int curr=(int) (totalLength-fis.available());
       curr=curr/1000000;
       int sec=curr%60;
       int min=(curr/60);
       int hr=min/60;
       min=min%60;
       time=Integer.toString(hr) +":"+Integer.toString(min)+":"+Integer.toString(sec);
        
       int s,m,h;
       String ss,mm,hh;
       s=count%60;
       m=(count/60);
       h=m/60;
       m=m%60;
       ss=Integer.toString(s);
       mm=Integer.toString(m);
       hh=Integer.toString(h);
       if(ss.length()<=1)
           ss="0"+ss;
       if(mm.length()<=1)
           mm="0"+mm;
       if(hh.length()<=1)
           hh="0"+hh;
       time=hh+":"+mm+":"+ss+"";
      
       return time;
       
    }*/
    
}
    
