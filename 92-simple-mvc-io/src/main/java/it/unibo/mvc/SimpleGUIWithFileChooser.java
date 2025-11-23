package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Constructs the GUI.
     */
    public SimpleGUIWithFileChooser() { 
        frame.setTitle("My second java graphical interface");

        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JPanel northPanel = new JPanel(new BorderLayout());
        final JTextField selectedFile = new JTextField(controller.getPathFile());
        selectedFile.setEditable(false);
        final JButton browseButton = new JButton("Browse ...");
        northPanel.add(selectedFile, BorderLayout.CENTER);
        northPanel.add(browseButton, BorderLayout.LINE_END);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        final JTextArea text = new JTextArea();
        final JButton saveButton = new JButton("Save");

        mainPanel.add(text, BorderLayout.CENTER);
        mainPanel.add(saveButton, BorderLayout.SOUTH);

        browseButton.addActionListener((ActionEvent e) -> {
            final JFileChooser fileChooser = new JFileChooser();
            final int result = fileChooser.showSaveDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                controller.setFile(fileChooser.getSelectedFile());
                selectedFile.setText(fileChooser.getSelectedFile().getPath());
            } else if (result != JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(frame, "error occured");
            }
        });

        saveButton.addActionListener((ActionEvent event) -> {
            try { 
                controller.save(text.getText());
                JOptionPane.showMessageDialog(frame, "text saved");
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); //NOPMD
            }
        });

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Display graphical intarface.
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
     * Main of application. 
     * 
     * @param args argomenti
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }

}
