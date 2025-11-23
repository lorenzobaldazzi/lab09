package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Graphical interface.
     */
    public SimpleGUI() {
        frame.setTitle("My first java graphical interface");

        final JPanel canvas = new JPanel(new BorderLayout());
        final JTextArea text = new JTextArea();
        canvas.add(text, BorderLayout.NORTH);
        final JButton saveButton = new JButton("Save");
        canvas.add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener((ActionEvent event) -> {
            try { 
                controller.save(text.getText());
                JOptionPane.showMessageDialog(frame, "text saved");
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); //NOPMD
            }
        });

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * display graphical intarface.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize(sw / PROPORTION, sh / PROPORTION);
        this.frame.setLocationByPlatform(true);
        this.frame.setVisible(true);
    }

    /**
     * Launch GUI.
     * 
     * @param args argomenti
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }

}
