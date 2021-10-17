
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    static int positionX = 0;
    static int positionY = 0;
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            positionX = e.getX()/UserInterface.scale;
            positionY = e.getY()/UserInterface.scale;
            //System.out.println(e.getX() + " " + e.getY());
            World.toggle(positionX,positionY);
        }
        else if(e.getButton() == MouseEvent.BUTTON3) {
            World.paused = !World.paused;
        } else if(e.getButton() == MouseEvent.BUTTON2){
            World.randomize();
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
