import java.awt.*;
import java.awt.image.BufferStrategy;

public class UserInterface {
    static MyWindow window;
    public static int scale = 10;
    static Color [] colors = {Color.ORANGE, Color.GREEN, Color.CYAN,Color.MAGENTA,Color.RED,Color.PINK};
    static int randomColor = (int)(Math.random() * 6);
    public static void renderer(BufferStrategy bs) {
        long timeThen = System.currentTimeMillis();
        while (true) {
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            g.setColor(Color.gray);
            g.fillRect(0, 0, World.numWidth * scale, World.numHeight * scale);
            g.dispose();
            if (!World.paused && (timeThen + 100 < System.currentTimeMillis())) {
                World.update();
                timeThen = System.currentTimeMillis();
            }
            for (int y = 0; y < World.numHeight; y++) {
                for (int x = 0; x < World.numWidth; x++) {
                    g = (Graphics2D) bs.getDrawGraphics();
                    if (World.grid[y][x]) {
                        g.setColor(colors[randomColor]);
                    } else if (!World.grid[y][x]) {
                        g.setColor(Color.black);
                    }
                    g.fillRect(x * scale, y * scale, scale - 2, scale - 2);
                    g.dispose();
                }
            }

            bs.show();

        }
    }
    public static void main(String [] args){
        window = new MyWindow();
        renderer(window.canvas.getBufferStrategy());



    }
}
