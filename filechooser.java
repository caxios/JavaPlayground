package snakePackage;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class filechooser implements ActionListener {
	 
    static JLabel l;
    static JLabel l2;
    
    filechooser()
    {
    }
 
    public static void main(String args[])
    {
        MyFrame frame = new MyFrame(800,400,true);

        JButton button = new JButton("open");
 
        filechooser f1 = new filechooser();
 
        button.addActionListener(f1);
 
        JPanel p = new JPanel();
 
        p.add(button);
 
        l = new JLabel("no file selected");
        l2 = new JLabel("no file name");
        		
        p.add(l);
        p.add(l2);
        frame.setTitle("Show file dir and name");
        frame.add(p);
        frame.task();
        frame.show();

    }
    public void actionPerformed(ActionEvent evt)
    {
        String com = evt.getActionCommand();
 
        if(com.equals("open"))
        {
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
 
            int r = j.showOpenDialog(null);
 
            if (r == JFileChooser.APPROVE_OPTION)
            {
            	String path = j.getSelectedFile().getAbsolutePath();
                l.setText(path);
                File f = new File(path);
                String name = f.getName();
                l2.setText(name);
            }
            else
                l.setText("tou should select file");
        }
    }
}
class MyFrame extends JFrame
{
	int width;
	int height;
	boolean setVisible;
	
	MyFrame(int width, int height, boolean setVisible)
	{
		this.width = width;
		this.height = height;
		this.setVisible = setVisible;
	}
	void task() 
	{
		this.setSize(width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
