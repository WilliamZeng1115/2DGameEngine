package GameEngine;

import Inputs.KeyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Created by william on 2017-10-21.
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;
    private JPanel panel;

    private int gameWidth, gameHeight;
    private String gameTitle;

    public Display(String title, int width, int height) {
        gameTitle = title;
        gameWidth = width;
        gameHeight = height;

        InitializeCanvasAndFrame();
    }

    private void InitializeCanvasAndFrame() {
        InitializeFrame();
        InitializeCanvas();
        frame.add(canvas);
        frame.pack();
    }

    private void InitializeFrame() {
        frame = new JFrame(gameTitle);
        frame.setSize(gameWidth, gameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        frame.addComponentListener(new ComponentAdapter() {
//            public void componentResized(ComponentEvent e) {
//                gameWidth = frame.getWidth();
//                gameHeight = frame.getHeight();
//            }
//        });
        panel = new JPanel();
        frame.add(panel);
    }

    private void InitializeCanvas() {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(gameWidth, gameHeight));
        canvas.setMaximumSize(new Dimension(gameWidth, gameHeight));
        canvas.setMinimumSize(new Dimension(gameWidth, gameHeight));
        canvas.setFocusable(false);
//        canvas.addComponentListener(new ComponentAdapter() {
//            public void componentResized(ComponentEvent e) {
//                canvas.setPreferredSize(new Dimension(gameWidth, gameHeight));
//                canvas.setMaximumSize(new Dimension(gameWidth, gameHeight));
//                canvas.setMinimumSize(new Dimension(gameWidth, gameHeight));
//            }
//        });
    }

    public void AddListeners(KeyManager keyManager, ArrayList<MouseAdapter> adaptors) {
        frame.addKeyListener(keyManager);
        canvas.addKeyListener(keyManager);
        for (MouseAdapter adaptor : adaptors) {
            frame.addMouseListener(adaptor);
            frame.addMouseMotionListener(adaptor);
            canvas.addMouseListener(adaptor);
            canvas.addMouseMotionListener(adaptor);
        }
    }

    public void UpdatePanel(ArrayList<JButton> buttons) {
        panel.removeAll();
        buttons.forEach(b -> panel.add(b));
    }

    public BufferStrategy getBufferStrategy() {
        return canvas.getBufferStrategy();
    }

    public void createBufferStrategy(int numberOfFrames) {
        canvas.createBufferStrategy(numberOfFrames);
    }
}
