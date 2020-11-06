import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class nBody extends JPanel implements ActionListener
{
    private final static int maxX = 768;
    private final static int maxY = 768;
    private List<Body> list;
    private double scale;

    public nBody(List<Body> newList, double newScale)
    {
        list = newList;
        scale = newScale;
    }

    public void actionPerformed(ActionEvent ae)
    {
        update();
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Timer tm = new Timer(500, this);
        try
        {
            for (int i = 0; i < list.size(); i++)
            {
                g.setColor(list.get(i).getColor());
                g.fillOval(list.get(i).getX(), list.get(i).getY(), (int) list.get(i).getSize(), (int) list.get(i).getSize());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        tm.start();
    }

    public void update()
    {
        try{
            int i;
            for(i = 0; i < list.size() - 1; i++)
            {
                list.get(i).force(list.get(i + 1), scale);
                list.get(i).updatePosition();
                list.get(i).reset();
            }
            if(list.size() > 1){
                list.get(i).force(list.get(i - 1), scale);
                list.get(i).updatePosition();
                list.get(i).reset();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{

        List<Body> tempList = null;
        double tempScale = 0;
        File input = new File("nbody_input.txt");
        try{
            Scanner scan = new Scanner(input);
            String type = scan.nextLine();
            if(type.equals("ArrayList")){
                tempList = new ArrayList<Body>();
            }
            else if(type.equals("LinkedList")){
                tempList = new LinkedList<Body>();
            }
            else{
                throw new Exception("Invalid data structure :( . Please pick ArrayList or LinkedList only");
            }

            tempScale = Double.parseDouble(scan.nextLine());
            scan.useDelimiter(",");
            while (scan.hasNext()){
                tempList.add(new Body(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.nextLine()));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        nBody nBody = new nBody(tempList, tempScale);
        JFrame jf = new JFrame();
        jf.setTitle("NBodies");
        jf.setSize(nBody.maxX, nBody.maxY);
        jf.add(nBody);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
