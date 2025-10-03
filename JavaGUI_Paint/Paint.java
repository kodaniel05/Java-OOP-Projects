import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * This program allows you to paint anything. The set color is always going to be black
 * When you press clear it makes the canvas blank, fill option fills the whole screen with the last
 *color created. Erase uses white to get rid of the color and random chooses 3 different random numbers
 *
 * <p>Purdue University -- CS18000 -- Fall 2023 -- HW 12 -- Paint Challenge
 *
 * @author Katie O'daniel
 * @version Nov 10h, 2023
 */
public class Paint extends JComponent implements Runnable {

    //Fields
    private Image image; // the canvas
    private Graphics2D graphics2D; // this will enable drawing
    private int curX; // current mouse x coordinate
    private int curY; // current mouse y coordinate
    private int oldX; // previous mouse x coordinate
    private int oldY; // previous mouse y coordinate


    int rValue;
    int gValue;
    int bValue;

    //all the buttons options for the top panel
    JButton clrButton; // A button that makes canvas blank
    JButton fillButton; // fills in a space with a color
    JButton eraseButton; // Make it the color of the canvas to earse
    JButton randomButton; // picks a random color

    //Button options for bottom panel
    String hexValue;
    JButton hexButton;
    JButton rgbButton; //change title to read it

    //Bottom panel as well but txt
    JTextField hexText;
    JTextField rText;
    JTextField gText;
    JTextField bText;

     Paint paint; // variable of the type Paint

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());
    }
    public void run() {
        JFrame frame = new JFrame("Paint");
        Container content = frame.getContentPane();

        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER); //Keeps box in middle of screen
        //size
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //Top of the panel

        clrButton = new JButton("Clear");
        fillButton = new JButton("Fill");
        eraseButton = new JButton("Erase");
        randomButton = new JButton("Random");
        JPanel topPanel = new JPanel();
        //Allows for buttons to actually do something
        topPanel.add(clrButton);
        clrButton.addActionListener(actionListener);
        topPanel.add(fillButton);
        fillButton.addActionListener(actionListener);
        topPanel.add(eraseButton);
        eraseButton.addActionListener(actionListener);
        topPanel.add(randomButton);
        randomButton.addActionListener(actionListener);
        content.add(topPanel, BorderLayout.NORTH); //Adds to top

        //Bottom Panels
        JPanel bottomPanel = new JPanel();
        hexText = new JTextField(10);
        hexText.setText("#");
        hexButton = new JButton("Hex");
        hexButton.addActionListener(actionListener);
        rText = new JTextField(5);
        gText = new JTextField(5);
        bText = new JTextField(5);
        rgbButton = new JButton("RGB");
        rgbButton.addActionListener(actionListener);
        bottomPanel.add(hexText);
        bottomPanel.add(hexButton);
        bottomPanel.add(rText);
        bottomPanel.add(gText);
        bottomPanel.add(bText);
        bottomPanel.add(rgbButton);
        content.add(bottomPanel , BorderLayout.SOUTH);//Adds to bottom

    }



    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clrButton) {
                paint.clearCanvas();
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");
            }
            if (e.getSource() == fillButton) {
                paint.fill(rValue, gValue, bValue);

                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");
            }
            if (e.getSource() == eraseButton) {
                paint.erase();
            }
            if (e.getSource() == randomButton) {
                ArrayList<Integer> integerList = randomNum(3, 0, 255);
                rText.setText(integerList.get(0).toString());
                rValue = integerList.get(0);
                gText.setText(integerList.get(1).toString());
                gValue = integerList.get(1);
                bText.setText(integerList.get(2).toString());
                bValue = integerList.get(2);
                paint.setRGB(rValue, gValue, bValue);
                hexText.setText(String.format("#%02x%02x%02x", rValue, gValue, bValue));
            }
            if (e.getSource() == hexButton) {
                try {
                    hexValue = hexText.getText();
                    paint.setHex(hexValue);
                    Color color = Color.decode(hexValue);
                    Color color1 = color; // convert hex to RGB
                    rValue = color1.getRed();
                    gValue = color1.getGreen();
                    bValue = color1.getBlue();

                } catch (NumberFormatException ea) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == rgbButton) {
                try {
                    rValue = Integer.valueOf(rText.getText());
                    if (rValue < 0) throw new Exception();
                    gValue = Integer.valueOf(gText.getText());
                    if (gValue < 0) throw new Exception();
                    bValue = Integer.valueOf(bText.getText());
                    if (bValue < 0) throw new Exception();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    rText.setText("");
                    gText.setText("");
                    bText.setText("");
                }

                if (rText.getText().equals("")) {
                    rText.setText("0");
                }
                if (gText.getText().equals("")) {
                    gText.setText("0");
                }
                if (bText.getText().equals("")) {
                    bText.setText("0");
                }

                rValue = Integer.valueOf(rText.getText());
                gValue = Integer.valueOf(gText.getText());
                bValue = Integer.valueOf(bText.getText());
                paint.setRGB(rValue, gValue, bValue);
            }
        }
    };
    //Mouse listeners(Walkthrough)
    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press*/
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where the mouse is being dragged*/
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh the frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;
            }
        });

    }
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            /* this lets us draw on the image (ie., the canvas) */
            graphics2D = (Graphics2D) image.getGraphics();
            /* gives us better rendering quality for the drawing lines */
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            /* set the canvas to white with the default paint color */
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }
    public void clearCanvas() {
        graphics2D.setPaint(Color.white);
        graphics2D.setBackground(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void fill(int r, int g, int b) {
        Color rgbColor = new Color(r, g, b);
        graphics2D.setPaint(rgbColor);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        graphics2D.setBackground(rgbColor);
        repaint();
    }

    public void setRGB(int r, int g, int b) {
        Color rgbColor = new Color(r, g, b);
        graphics2D.setPaint(rgbColor);
    }

    public void setHex(String hexValue1) {
            Color color = Color.decode(hexValue1);
            graphics2D.setPaint(color);
            rValue = color.getRed();
            gValue = color.getGreen();
            bValue = color.getBlue();

    }

    public void erase() {
        Color background = graphics2D.getBackground();
        graphics2D.setPaint(background);
    }
    //Array of random numbers
    public static ArrayList<Integer> randomNum(int size, int lowerBound, int upperBound) {
        Random random = new Random();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(upperBound - lowerBound) + lowerBound);
        }
        return result;
    }

}

