package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiDevolucao {
    private JPanel JPanelDevolucao;
    private JList listLeitoresParaDevolver;
    private JButton devolverButton;

    public JPanel getJPanelDevolucao() {
        return JPanelDevolucao;
    }

    public GuiDevolucao() {
        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Clicou no botão,\nContinua na n2!");
            }
        });
    }

    public void preencherListaEmprestimo(){
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            listLeitoresParaDevolver.setListData(emprestimos.toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void abrirTela(){
        GuiDevolucao guiDevolucao = new GuiDevolucao();
        guiDevolucao.preencherListaEmprestimo();
        JDialog jFrame = new JDialog(new Frame(), true);
        jFrame.setTitle("Devolução");
        jFrame.setContentPane(guiDevolucao.getJPanelDevolucao());
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
