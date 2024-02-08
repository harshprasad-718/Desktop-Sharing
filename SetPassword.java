import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetPassword extends JFrame implements ActionListener {
    static String port="1234";
    JButton Submit;
    JPanel panel;
    JTextField text1,text2;
    String value1,value2;
    JLabel label,label1,label2;

    SetPassword()
    {
        label1=new JLabel();
        label1.setText("Set Password");
        text1=new JTextField(15);
        label=new JLabel();
        this.setLayout(new BorderLayout());
        Submit=new JButton("Submit");
        panel=new JPanel(new GridLayout(2,1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label);
        panel.add(Submit);
        add(panel,BorderLayout.CENTER);
        Submit.addActionListener(this);
        setTitle("Setting Password for Client");
    }
    public void actionPerformed(ActionEvent e){
        value1= text1.getText();
        dispose();
        new InitConnection(Integer.parseInt(port),value1);
    }
    public String getValue1(){
        return value1;
    }
    public static void main(String args[])
    {
        SetPassword frame1=new SetPassword();
        frame1.setSize(300,80);
        frame1.setLocation(500,300);
        frame1.setVisible(true);
    }
}
