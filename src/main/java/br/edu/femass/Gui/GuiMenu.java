package br.edu.femass.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu {
    private JPanel JPanelMenu;
    private JButton BtnCadastrarAutor;
    private JButton BtnAlugarLivro;
    private JLabel JLMenu;

    public GuiMenu() {
        BtnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                JDialog jFrame = new JDialog(new Frame(), true);
                jFrame.setContentPane(guiAutor.getJPanelCadastrarAutor());

                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }
    public void abrirTelaI(){
        JFrame frame = new JFrame();
        GuiMenu guiMenu = new GuiMenu();
        frame.setContentPane(guiMenu.JPanelMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu");
        frame.pack();
        frame.setVisible(true);
    }
}