import javax.swing.*;
import java.net.Socket;

public class Start {
    static String port="1234";
    public static void main(String[] args){
        String ip= JOptionPane.showInputDialog("Please enter server ip");
        new Start().initialize(ip,Integer.parseInt(port ));
    }
    public void initialize(String ip,int port){
        try{
            Socket socket=new Socket(ip,port);
            System.out.println("Connecting to server..");
            Authentication f1=new Authentication(socket);
            f1.setSize(300,80);
            f1.setLocation(500,300);
            f1.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
