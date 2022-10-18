package br.edu.femass.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBibliotecaria {
    private JPanel JPanelBibliotecaria;
    private JButton BtnCadastrarAutor;
    private JButton BtnCadastrarLeitor;
    private JLabel JLMenu;
    private JButton bntCadastrarExemplar;
    private JButton bntListaDeLeitoresAtraso;

    public GuiBibliotecaria() {
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
        bntListaDeLeitoresAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLeitorAtraso guiLeitorAtraso = new GuiLeitorAtraso();
                guiLeitorAtraso.abrirTela();
            }
        });
    }
    public void abrirTelaB(){
        JFrame frame = new JFrame();
        GuiBibliotecaria guiBibliotecaria = new GuiBibliotecaria();
        frame.setContentPane(guiBibliotecaria.JPanelBibliotecaria);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Bibliotecaria");
        frame.pack();
        frame.setVisible(true);
    }
}
