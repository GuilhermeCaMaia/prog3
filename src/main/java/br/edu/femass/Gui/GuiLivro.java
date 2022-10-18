package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoAutor;
import br.edu.femass.Dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private JPanel JPanelLivro;
    private JList listLivros;
    private JTextField textTitulo;
    private JTextField textCodigos;
    private JButton salvarButton;
    private JComboBox CBAutor;

    public GuiLivro() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Livro livro = new Livro();
                try {
                    livro = new Livro(
                                textTitulo.getText(),
                                (Autor) CBAutor.getSelectedItem());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                preencherLista();
                try {
                    new DaoLivro().save(livro);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        listLivros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) CBAutor.getSelectedItem();
                try {
                    List<Livro> livros = new DaoLivro().getAll(autor);
                    listLivros.setListData(livros.toArray());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public JPanel getJPanelLivro() {
        return JPanelLivro;
    }

    private void preencherListaAutro(){
        try {
            List<Autor> autors = new DaoAutor().getAll();
            CBAutor.removeAllItems();
            for (Autor autor: autors){
                CBAutor.addItem(autor);
            }
            listLivros.setListData(
                    new DaoLivro().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private void preencherLista(){
        DaoLivro daoLivro = new DaoLivro();
        Autor autor = new Autor();
        if(CBAutor.equals(autor)){
            try {
                listLivros.setListData(
                        new DaoLivro().getAll().toArray());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }

    public void abrirTela(){
        GuiLivro guiLivro = new GuiLivro();
        guiLivro.preencherListaAutro();
        guiLivro.preencherLista();
        JDialog jFrame = new JDialog(new Frame(), true);
        jFrame.setTitle("Cadastrar livros");
        jFrame.setContentPane(guiLivro.getJPanelLivro());
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
//    Livro livro = (Livro) listLivros.getSelectedValue();
//                if(livro==null) return;
//                        textCodigos.setText(livro.getCodigo().toString());
//                        textTitulo.setText(livro.getTitulo());
//                        CBAutor.setSelectedItem(livro.getAutor());