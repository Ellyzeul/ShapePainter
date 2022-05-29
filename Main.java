import javax.swing.JFrame;

import View.PaintPanel;


public class Main {
    private static void setConfigs(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Shape Painter");
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Main.setConfigs(frame);
        frame.add(new PaintPanel());

        frame.setVisible(true);
    }
}
