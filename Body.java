import java.awt.Color;
import java.util.*;

public class Body {
    private String name;
    private double mass;
    private int x;
    private int y;
    private double velX;
    private double velY;
    private String size;
    private Color color;
    private Random random;
    private double forceX;
    private double forceY;
    public Body(String name, String mass, String x, String y, String velX, String velY, String size)
    {
        this.name = name;
        this.mass = Double.parseDouble(mass);
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.velX = Double.parseDouble(velX);
        this.velY = Double.parseDouble(velY);
        this.size = size.substring(1, size.length());
        random = new Random();
        color = new Color (random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getSize()
    {
        return Integer.parseInt(size);
    }
    public Color getColor()
    {
        return color;
    }

    public void force(Body b, double scale)
    {
        Body a = this;
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double force = (6.673e-11 * a.mass * b.mass / ((distance * distance) / scale));
        a.forceX += force * dx / distance;
        a.forceY += force * dy / distance;

    }

    public void updatePosition()
    {
        velX += forceX / mass;
        velY += forceY / mass;
        x += velX;
        y += velY;
    }

    public void reset()
    {
        forceX = 0.0;
        forceY = 0.0;
    }

}
