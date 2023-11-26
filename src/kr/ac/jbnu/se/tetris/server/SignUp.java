package kr.ac.jbnu.se.tetris.server;

import javax.swing.*;

import kr.ac.jbnu.se.tetris.ui.Wallpapers;
import kr.ac.jbnu.se.tetris.ui.CustomButton;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class SignUp extends JFrame{

    private JTextField txt_id, txt_pw;
    private CustomButton accept;
    private JLabel id, pw;
    private String sign_id,sign_pw;
    private Wallpapers backgrounds;

    SignUp() {
        setText();
        setTextField();
        setButton();
        setBackgrounds();
        setFrame();
        add(pw); add(id); add(txt_id); add(txt_pw); add(accept); add(backgrounds.getPane());
    }
    private void setText() {
        id = new JLabel("ID : ");
        pw = new JLabel("PW : ");

        id.setFont(id.getFont().deriveFont(15.0f));
        pw.setFont(pw.getFont().deriveFont(15.0f));

        id.setForeground(Color.WHITE);
        pw.setForeground(Color.WHITE);
    }

    private void setBackgrounds() {
        backgrounds = new Wallpapers("image/Background.jpg", LoginPage.FRAME_WIDTH, LoginPage.FRAME_HEIGHT);
    }

    private void setFrame() {

        setSize(LoginPage.FRAME_WIDTH,LoginPage.FRAME_HEIGHT);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void setButton() {
        accept = new CustomButton(new ImageIcon("image/SignUp.png"));
        accept.setBounds(530,270,80,80);
        buttonAction();
    }

    private void setTextField() {
        txt_id = new JTextField(20);
        txt_pw = new JTextField(50);

        id.setBounds(290,280,40,20);
        pw.setBounds(290,350,40,20);

        txt_id.setBounds(330,260,160,50);
        txt_pw.setBounds(330,330,160,50);

    }

    private void buttonAction() {
        accept.addActionListener(e->{
            sign_id = txt_id.getText();
            sign_pw = txt_pw.getText();
            try {
                SignUpSQL signUpSQL = new SignUpSQL(sign_id, sign_pw);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
