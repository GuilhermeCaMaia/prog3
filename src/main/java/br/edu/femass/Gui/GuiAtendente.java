package br.edu.femass.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAtendente {
    private JPanel JPanelAtendente;
    private JButton btnAlugarLivro;
    private JButton button2;

    public GuiAtendente() {
        btnAlugarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTela();
            }
        });
    }
    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiAtendente guiAtendente = new GuiAtendente();
        frame.setContentPane(guiAtendente.JPanelAtendente);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Atendete");
        frame.pack();
        frame.setVisible(true);
    }
}
