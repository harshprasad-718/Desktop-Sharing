import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class ReceiveEvents extends Thread
{
    Socket socket=null;
    Robot robot=null;
    boolean continueLoop=true;
    public ReceiveEvents (Socket socket, Robot robot)
    {
        this.socket=socket;
        this.robot=robot;
        start();
    }
    public void run()
    {
        Scanner scanner = null;
        try
        {
            scanner=new Scanner(socket.getInputStream());
            while(continueLoop)
            {
                //try {
                    if(scanner.hasNext()) {
                        int command = scanner.nextInt();
                        switch (command) {
                            case-1:
                                robot.mousePress(scanner.nextInt());
                                break;
                            case-2:
                                robot.mouseRelease(scanner.nextInt());
                                break;
                            case-3:
                                robot.keyPress(scanner.nextInt());
                                break;
                            case-4:
                                robot.mouseRelease(scanner.nextInt());
                                break;
                            case-5:
                                robot.mouseMove(scanner.nextInt(), scanner.nextInt());
                                break;
                        }
                    }
                    else{
                        continueLoop=false;
                   }
              //  }catch(NoSuchElementException e){
                //    continueLoop=false;
                //}
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //finally {
          //  if (scanner!=null){
            //    scanner.close();
            //}
        //}
    }
}