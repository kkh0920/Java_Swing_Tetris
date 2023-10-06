package kr.ac.jbnu.se.tetris;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Tutorial extends JFrame{
    Backgrounds background;
    int tutorial_Frame_X = 315, tutorial_Frame_Y = 430;
    static final String tutorialpng = "image\\tutorials.png";
    Tutorial() throws IOException {
        setFrame();
    }

    public void setFrame() throws IOException {
        background = new Backgrounds(tutorialpng, tutorial_Frame_X, tutorial_Frame_Y);
        add(background.getPane());
        setSize(tutorial_Frame_X, tutorial_Frame_Y);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
    }

}