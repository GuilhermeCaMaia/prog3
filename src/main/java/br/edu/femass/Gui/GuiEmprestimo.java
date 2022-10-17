package br.edu.femass.Gui;

import br.edu.femass.Dao.*;
import br.edu.femass.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiEmprestimo {
    private JPanel JPanelEmprestimo;
    private JList listLivros;
    private JList listLeitor;
    private JComboBox cBoxAutor;
    private JButton ButtonAlugar;

    public JPanel getJPanelEmprestimo() {
        return JPanelEmprestimo;
    }

    public GuiEmprestimo() {
        listLivros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) cBoxAutor.getSelectedItem();
                try{
                    List<Livro> livros = new DaoLivro().getAll(autor);
                    listLivros.setListData(livros.toArray());
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        listLeitor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Emprestimo emprestimo = new Emprestimo();
            }
        });
        ButtonAlugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Emprestimo emprestimo = new Emprestimo((Livro) listLivros.getSelectedValue(),(Leitor) listLeitor.getSelectedValue());
                    emprestimo = new Emprestimo((Livro) listLivros.getSelectedValue(),(Leitor) listLeitor.getSelectedValue());
                    new DaoEmprestimo().save(emprestimo);
                    JOptionPane.showMessageDialog(null, "Emprestimo Realizado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
    private void preencherListaAutro(){
        try {
            List<Autor> autors = new DaoAutor().getAll();
            cBoxAutor.removeAllItems();
            for (Autor autor: autors){
                cBoxAutor.addItem(autor);
            }
            listLivros.setListData(
                    new DaoLivro().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private void preencherListaLivro(){
        //DaoLivro daoLivro = new DaoLivro();
        DaoExemplar daoExemplar = new DaoExemplar();
        Autor autor = new Autor();
        if(cBoxAutor.equals(autor)){
            try {
                listLivros.setListData(
                        new DaoExemplar().getAll().toArray());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }
    private void preencherListaLeitor(){
        try{
            List<Aluno> alunos = new DaoAluno().getAll();
            List<Professor> professors = new DaoProfessor().getAll();
            List<Leitor> leitors = new ArrayList<>();
            leitors.addAll(alunos);
            leitors.addAll(professors);
            listLeitor.setListData(leitors.toArray());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void abrirTela(){
        GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
        guiEmprestimo.preencherListaAutro();
        guiEmprestimo.preencherListaLivro();
        guiEmprestimo.preencherListaLeitor();
        JDialog jFrame = new JDialog(new Frame(), true);
        jFrame.setContentPane(guiEmprestimo.getJPanelEmprestimo());
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
