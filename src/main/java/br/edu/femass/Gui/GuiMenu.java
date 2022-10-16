package br.edu.femass.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu {
    private JPanel JPanelMenu;
    private JButton BtnCadastrarAutor;
    private JButton BtnCadastrarLeitor;
    private JLabel JLMenu;
    private JButton bntCadastrarExemplar;

    public GuiMenu() {
        BtnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                guiAutor.abrirTela();
            }
        });
        BtnCadastrarLeitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastro guiCadastro = new GuiCadastro();
                guiCadastro.abrirTela();
            }
        });
        bntCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                guiExemplar.abrirTela();
            }
        });
    }
    public void abrirTelaI(){
        JFrame frame = new JFrame();
        GuiMenu guiMenu = new GuiMenu();
        frame.setContentPane(guiMenu.JPanelMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Bibliotecaria");
        frame.pack();
        frame.setVisible(true);
    }
}
