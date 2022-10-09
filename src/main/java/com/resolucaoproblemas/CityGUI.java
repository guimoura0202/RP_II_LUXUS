package com.resolucaoproblemas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.*;
import javax.swing.*;


/**
 * The CityGUI class is a JFrame that implements the Actor interface.
 */
public class CityGUI extends JFrame implements Actor {
    public static final int CITY_VIEW_WIDTH = 600;
    public static final int CITY_VIEW_HEIGHT = 600;
    private City city;
    private CityView cityView;


    // Creating a new CityGUI object.
    public CityGUI(City city) {
        this.city = city;
        cityView = new CityView(city.getWidth(), city.getHeight());
        getContentPane().add(cityView);
        setTitle("Taxiville");
        setSize(CITY_VIEW_WIDTH, CITY_VIEW_HEIGHT);
        setVisible(true);
        cityView.preparePaint();
        cityView.repaint();
    }

  /**
   * The function iterates through all the items in the city and draws them on the screen
   */
    public void act() {
        cityView.preparePaint();
        Iterator items = city.getItems();
        while (items.hasNext()) {
            Object obj = items.next();
            if (obj instanceof DrawableItem) {
                DrawableItem item = (DrawableItem) obj;
                Location location = item.getLocation();
                cityView.drawImage(location.getX(), location.getY(), item.getImage());
            }
        }
        cityView.repaint();
    }


    /**
     * The CityView class is a JPanel that displays the city.
     */
    private class CityView extends JPanel {
        private final int VIEW_SCALING_FACTOR = 6;

        private int cityWidth, cityHeight;
        private int xScale, yScale;
        private Dimension size;
        private Graphics g;
        private Image cityImage;


        // Setting the background color to white and setting the size to 0,0.
        public CityView(int width, int height) {
            cityWidth = width;
            cityHeight = height;
            setBackground(Color.white);
            size = new Dimension(0, 0);
        }


       /**
        * It returns the preferred size of the component.
        * 
        * @return The preferred size of the panel.
        */
        public Dimension getPreferredSize() {
            return new Dimension(cityWidth * VIEW_SCALING_FACTOR,
                    cityHeight * VIEW_SCALING_FACTOR);
        }


        // Setting the size of the city.
        public void preparePaint() {
            if (!size.equals(getSize())) { // if the size has changed...
                size = getSize();
                cityImage = cityView.createImage(size.width, size.height);
                g = cityImage.getGraphics();

                xScale = size.width / cityWidth;
                if (xScale < 1) {
                    xScale = VIEW_SCALING_FACTOR;
                }
                yScale = size.height / cityHeight;
                if (yScale < 1) {
                    yScale = VIEW_SCALING_FACTOR;
                }
            }
          // Drawing the grid.
            g.setColor(Color.white);
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.gray);
            for (int i = 0, x = 0; x < size.width; i++, x = i * xScale) {
                g.drawLine(x, 0, x, size.height - 1);
            }
            for (int i = 0, y = 0; y < size.height; i++, y = i * yScale) {
                g.drawLine(0, y, size.width - 1, y);
            }
        }


      /**
       * It draws an image at the specified location.
       * 
       * @param x The x coordinate of the top left corner of the rectangle to be drawn.
       * @param y The y coordinate of the top left corner of the rectangle to be drawn.
       * @param image The image to be drawn.
       */
      // Drawing the image.
        public void drawImage(int x, int y, Image image) {
            g.drawImage(image, x * xScale + 1, y * yScale + 1,
                    xScale - 1, yScale - 1, this);
        }


        public void paintComponent(Graphics g) {
            if (cityImage != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    g.drawImage(cityImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(cityImage, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
    }


    public void setActive(boolean active) {
        // TODO Auto-generated method stub
        
    }

    public void reset() {
        // TODO Auto-generated method stub
        
    }
}
