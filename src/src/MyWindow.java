import javax.swing.*;
import java.awt.*;

public class MyWindow {
    public Canvas canvas = new Canvas();
    public JFrame frame = new JFrame();
    public MyWindow(){
        canvas.setSize(new Dimension(World.numWidth * UserInterface.scale,World.numHeight * UserInterface.scale));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        canvas.createBufferStrategy(2);
        canvas.setFocusable(true);
        canvas.addMouseListener(new MyMouseListener());
        canvas.addKeyListener(new MyKeyListener());
        frame.setVisible(true);
    }
}
