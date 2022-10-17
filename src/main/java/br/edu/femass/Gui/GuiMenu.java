package br.edu.femass.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu {
    private JPanel JPanelMenu;
    private JButton btnBibliotecaria;
    private JButton btnAtendente;

    public GuiMenu() {
        btnBibliotecaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiBibliotecaria().abrirTelaB();
            }
        });
        btnAtendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAtendente().abrirTela();
            }
        });
    }
    public void abrirTelaI(){
        JFrame frame = new JFrame();
        GuiMenu guiMenu = new GuiMenu();
        frame.setContentPane(guiMenu.JPanelMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu principal");
        frame.pack();
        frame.setVisible(true);
    }
}
