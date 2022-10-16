package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoAluno;
import br.edu.femass.Dao.DaoLeitor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Leitor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastrarLeitorAluno {
    private JPanel JPanelCadastroLeitorAluno;
    private JTextField textNome;
    private JTextField textEndereco;
    private JTextField textTelefone;
    private JTextField textMatricula;
    private JButton salvarButton;
    private JList listAluno;


    public GuiCadastrarLeitorAluno() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Leitor leitor = new Leitor(textNome.getText(),
                        textEndereco.getText(),textTelefone.getText());
                Aluno aluno = new Aluno(textNome.getText(),
                        textEndereco.getText(),textTelefone.getText(),textMatricula.getText());
                try {
                    new DaoAluno().save(aluno);
                    new DaoLeitor().save(leitor);
                    preencherListaAluno();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        listAluno.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) listAluno.getSelectedValue();
                if(aluno==null) return;
                textNome.setText(aluno.getNome());
                textEndereco.setText(aluno.getEndereco());
                textTelefone.setText(aluno.getTelefone());
                textMatricula.setText(aluno.getMatricula());
            }
        });
    }
    public void preencherListaAluno(){
        try {
            listAluno.setListData(new DaoAluno().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiCadastrarLeitorAluno guiCadastrarLeitorAluno =
                new GuiCadastrarLeitorAluno();
        guiCadastrarLeitorAluno.preencherListaAluno();
        JDialog jFrame = new JDialog(new Frame(), true);
        jFrame.setContentPane(guiCadastrarLeitorAluno.JPanelCadastroLeitorAluno);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
