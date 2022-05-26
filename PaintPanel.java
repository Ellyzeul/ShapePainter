import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import painters.ShapePainter;


public class PaintPanel extends JPanel {
    private String polygonType;
    private Point p0;
    private Point p1;
    private HashMap<String, Polygons> validPolygons = new HashMap<>();
    private Object[] selectOptions;
    private ShapePainter painter;

    public PaintPanel() {
        this.setLayout(new GridBagLayout());

        JButton displayInput = new JButton("Escolher forma geométrica");
        GridBagConstraints cons = new GridBagConstraints();
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.FIRST_LINE_START;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        this.add(displayInput, cons);

        Polygons[] rawList = Polygons.values();
        selectOptions = new Object[rawList.length];
        int optionsCount = 0;
        List<Polygons> list = Arrays.asList(rawList);
        for (Polygons polygon : list) {
            validPolygons.put(polygon.getValue(), polygon);
            selectOptions[optionsCount++] = polygon.getValue();
        }

        displayInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Boolean keepLoop;
                do {
                    keepLoop = false;
                    try {
                        polygonType = JOptionPane.showInputDialog(
                            null, 
                            "Escolha uma forma geométrica", 
                            "Formas para desenhar", 
                            JOptionPane.PLAIN_MESSAGE, 
                            null, 
                            selectOptions, 
                            selectOptions[0]
                        ).toString();
                    }
                    catch(NullPointerException e) {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Escolha ao menos uma forma para desenhar", 
                            "Forma geométrica necessária", 
                            JOptionPane.ERROR_MESSAGE
                        );
                        keepLoop = true;
                    }
                } while(keepLoop);

                painter = validPolygons.get(polygonType).getPainter();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if(p0 == null) p0 = event.getPoint();
                else p1 = event.getPoint();

                revalidate();
                repaint();
            }
        });

        this.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseReleased(MouseEvent event) {
                p0 = p1 = null;
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(painter != null && p0 != null && p1 != null) {
            painter.draw(g, p0, p1);
        }
    }
}
