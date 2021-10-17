import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            World.createCrasher();

        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            MyFileReader.readFile();
            boolean[][] gate = MyFileReader.interpreter(MyFileReader.gateWay);
            int mousePositionX = UserInterface.window.frame.getMousePosition().x / UserInterface.scale;
            int mousePositionY = UserInterface.window.frame.getMousePosition().y / UserInterface.scale;
            int height = gate.length;
            int width = gate[0].length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    World.grid[mousePositionY + y][mousePositionX + x] = gate[y][x];
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_R){
            for(int y =0; y < World.numHeight; y++){
                for(int x =0; x < World.numWidth; x++){
                    World.grid[y][x] = false;
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_I){
            for(int y =0; y < World.numHeight; y++){
                for(int x =0; x < World.numWidth; x++){
                    World.grid[y][x] = !World.grid[y][x];
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
