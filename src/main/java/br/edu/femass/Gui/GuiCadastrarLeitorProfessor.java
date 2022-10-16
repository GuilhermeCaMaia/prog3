package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoLeitor;
import br.edu.femass.Dao.DaoProfessor;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastrarLeitorProfessor {
    private JPanel JPanelCadastroLeitorProfessor;
    private JList listProfessor;
    private JTextField textNome;
    private JTextField textEndereco;
    private JTextField textTelefone;
    private JTextField textDisciplina;
    private JButton salvarButton;

    public GuiCadastrarLeitorProfessor() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Leitor leitor = new Leitor(textNome.getText(),
                        textEndereco.getText(),textTelefone.getText());
                Professor professor = new Professor(textNome.getText(),
                        textEndereco.getText(),textTelefone.getText(),textDisciplina.getText());
                try {
                    new DaoLeitor().save(leitor);
                    new DaoProfessor().save(professor);
                    preencherListaProfessor();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        listProfessor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Professor professor = (Professor) listProfessor.getSelectedValue();
                if(professor==null) return;
                textNome.setText(professor.getNome());
                textEndereco.setText(professor.getEndereco());
                textTelefone.setText(professor.getTelefone());
                textDisciplina.setText(professor.getDisciplina());
            }
        });
    }
    public void preencherListaProfessor(){
        try {
            listProfessor.setListData(new DaoProfessor().getAll().toArray());
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiCadastrarLeitorProfessor guiCadastrarLeitorProfessor =
                new GuiCadastrarLeitorProfessor();
        guiCadastrarLeitorProfessor.preencherListaProfessor();
        JDialog jFrame = new JDialog(new Frame(), true);
        jFrame.setContentPane(guiCadastrarLeitorProfessor.JPanelCadastroLeitorProfessor);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
