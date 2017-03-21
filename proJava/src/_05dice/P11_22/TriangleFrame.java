package _05dice.P11_22;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Created by jakecoll on 10/31/16.
 */
public class TriangleFrame extends JFrame {

    private int[] arrXCoord = new int[3];
    private int[] arrYCoord = new int[3];
    private int nXYLength = 0;
    private int x;
    private int y;

    public TriangleFrame() {


        setSize(300, 300);

        /**
         * inner class for mouse listener
         */
        class MousePressListener implements MouseListener {
            public void mousePressed(MouseEvent event) {
                //store x,y coordinates and number of mouse clicks
                x = event.getX();
                y = event.getY();
                nXYLength++;

                //is 4th mouse click then reset frame
                if (nXYLength == 4) {
                    nXYLength = 0;
                    repaint();
                }
                if (nXYLength == 1) {
                    arrXCoord[0] = x;
                    arrYCoord[0] = y;
                }
                if (nXYLength == 2) {
                    arrXCoord[1] = x;
                    arrYCoord[1] = y;
                }
                //if third mouse click then draw the polygon
                if (nXYLength == 3) {
                    arrXCoord[2] = x;
                    arrYCoord[2] = y;

                    getGraphics().drawPolygon(arrXCoord,arrYCoord,nXYLength);

                }
            }

            //unused methods by mouse event listener
            public void mouseReleased(MouseEvent event) {
            }

            public void mouseClicked(MouseEvent event) {
            }

            public void mouseEntered(MouseEvent event) {
            }

            public void mouseExited(MouseEvent event) {
            }
        }

        //add mouselistener to frame
        MouseListener listener = new MousePressListener();
        addMouseListener(listener);
    }



}

