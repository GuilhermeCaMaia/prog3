package br.edu.femass.Gui;

import br.edu.femass.Dao.*;
import br.edu.femass.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiEmprestimo {
    private JPanel JPanelEmprestimo;
    private JList listLivros;
    private JList listAluno;
    //private JComboBox cBoxAutor;
    private JButton ButtonAlugarAluno;
    private JList listProfessor;
    private JLabel Aluno;
    private JButton btnAlugarProfessor;

    public JPanel getJPanelEmprestimo() {
        return JPanelEmprestimo;
    }

    public GuiEmprestimo() {
//        listLivros.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                //Autor autor = (Autor) cBoxAutor.getSelectedItem();
//                try{
//                    List<Livro> livros = new DaoLivro().getAll(/*autor*/);
//                    listLivros.setListData(livros.toArray());
//                }catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null,ex.getMessage());
//                }
//            }
//        });
        ButtonAlugarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Emprestimo emprestimo = new Emprestimo((Livro) listLivros.getSelectedValue(),(Aluno) listAluno.getSelectedValue());
                    emprestimo = new Emprestimo((Livro) listLivros.getSelectedValue(),(Aluno) listAluno.getSelectedValue());
                    new DaoEmprestimo().save(emprestimo);
                    JOptionPane.showMessageDialog(null, "Emprestimo Realizado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnAlugarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Emprestimo emprestimo = new Emprestimo((Livro) listLivros.getSelectedValue(),(Professor) listProfessor.getSelectedValue());
                emprestimo = new Emprestimo((Livro) listLivros.getSelectedValue(),(Professor) listProfessor.getSelectedValue());
                try {
                    new DaoEmprestimo().save(emprestimo);
                    JOptionPane.showMessageDialog(null, "Emprestimo Realizado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
//    private void preencherListaAutro(){
//        try {
//            List<Autor> autors = new DaoAutor().getAll();
//            cBoxAutor.removeAllItems();
//            for (Autor autor: autors){
//                cBoxAutor.addItem(autor);
//            }
//            listLivros.setListData(
//                    new DaoLivro().getAll().toArray());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e.getMessage());
//        }
//    }

    private void preencherListaLivro(){ // não consegui filtrar por autor
        DaoLivro daoLivro = new DaoLivro();
        //DaoExemplar daoExemplar = new DaoExemplar();
        //Autor autor = new Autor();
        //if(cBoxAutor.equals(autor)){
            try {
                listLivros.setListData(
                        new DaoLivro().getAll().toArray());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        //}
    }
    private void preencherListaAluno(){
        try{
            List<Aluno> alunos = new DaoAluno().getAll();
//            List<Professor> professors = new DaoProfessor().getAll();
//            List<Leitor> leitors = new ArrayList<>();
//            leitors.addAll(alunos);
//            leitors.addAll(professors);
            listAluno.setListData(alunos.toArray());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    private void preencherListaProfessor(){
        try {
            List<Professor> professors = new DaoProfessor().getAll();
            listProfessor.setListData(professors.toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void abrirTela(){
        GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
        //guiEmprestimo.preencherListaAutro();
        guiEmprestimo.preencherListaLivro();
        guiEmprestimo.preencherListaAluno();
        guiEmprestimo.preencherListaProfessor();
        JDialog jFrame = new JDialog(new Frame(), true);
        jFrame.setContentPane(guiEmprestimo.getJPanelEmprestimo());
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
