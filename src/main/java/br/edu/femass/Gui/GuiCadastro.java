package br.edu.femass.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastro {
    private JButton cadastrarAlunoButton;
    private JButton cadastrarProfessorButton;
    private JPanel JPanelCadastro;

    public GuiCadastro() {
        cadastrarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarLeitorAluno guiCadastrarLeitorAluno=
                        new GuiCadastrarLeitorAluno();
                guiCadastrarLeitorAluno.abrirTela();
            }
        });
        cadastrarProfessorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarLeitorProfessor guiCadastrarLeitorProfessor =
                        new GuiCadastrarLeitorProfessor();
                guiCadastrarLeitorProfessor.abrirTela();
            }
        });
    }
    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiCadastro guiCadastro = new GuiCadastro();
        frame.setContentPane(guiCadastro.JPanelCadastro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro");
        frame.pack();
        frame.setVisible(true);
    }
}
