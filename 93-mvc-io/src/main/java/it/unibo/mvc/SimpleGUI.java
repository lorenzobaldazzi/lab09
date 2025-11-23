    package it.unibo.mvc;

    import java.awt.BorderLayout;
    import java.awt.Dimension;
    import java.awt.Toolkit;
    import java.awt.event.ActionEvent;
    import java.util.List;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JTextArea;
    import javax.swing.JTextField;

    /**
     * A very simple program using a graphical interface.
     *
     */
    public final class SimpleGUI {

        private static final int PROPORTION = 5;
        private final JFrame frame = new JFrame();
        private final Controller controller = new SimpleController();

        /**
         * Graphical Interface.
         */
        public SimpleGUI() {

            frame.setTitle("Simple GUI");
            final JPanel canvas = new JPanel(new BorderLayout());
            final JTextField text = new JTextField();
            canvas.add(text, BorderLayout.NORTH);
            final JTextArea area = new JTextArea();
            area.setEditable(false);
            canvas.add(area, BorderLayout.CENTER);
            final JPanel canvasButton = new JPanel();
            final JButton printButton = new JButton("Print");
            canvasButton.add(printButton);
            final JButton showHistoryButton = new JButton("Show History");
            canvasButton.add(showHistoryButton);
            canvas.add(canvasButton, BorderLayout.SOUTH);

            printButton.addActionListener((ActionEvent e) -> {
                try {
                    controller.setNextString(text.getText());
                    controller.printCurrentString();
                } catch (final IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Can not set null string", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (final IllegalStateException ex) {
                    JOptionPane.showMessageDialog(frame, "No string to print", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            });

                showHistoryButton.addActionListener((ActionEvent e) -> {
                    final List<String> history = controller.getHistoryStrings();
                    final StringBuilder tmpString = new StringBuilder();
                    for (final String s: history) {
                        tmpString.append(s).append('\n');
                    }
                    area.setText(tmpString.toString());
                });

            frame.setContentPane(canvas);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
         * Laungh GUI.
         * 
         * @param args argomenti
         */
        public static void main(final String... args) {
            new SimpleGUI().display();
        }

    }
