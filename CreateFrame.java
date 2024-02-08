
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class CreateFrame extends Thread{
    String width="",height="";
    private JFrame frame=new JFrame();
    private JDesktopPane desktop=new JDesktopPane();
    private Socket csocket=null;
    private JInternalFrame interFrame=new JInternalFrame("Server Screen",true,true,true);
    private JPanel cPanel=new JPanel();

    public CreateFrame(String width, String height, Socket csocket) {
        this.width = width;
        this.height = height;
        this.csocket = csocket;
        start();
    }
    public void drawGUI() {
        frame.add(desktop, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        interFrame.setLayout(new BorderLayout());
        interFrame.getContentPane().add(cPanel,BorderLayout.CENTER);
        desktop.add(interFrame);

        try {
            interFrame.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cPanel.setFocusable(true);
        interFrame.setVisible(true);
    }
    public void run(){
        InputStream in=null;
        drawGUI();
        try{
            in=csocket.getInputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
        new ReceivingScreen(in,cPanel);
        new SendEvents(csocket,cPanel,width,height);
    }
}

