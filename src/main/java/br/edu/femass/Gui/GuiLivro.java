package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoAutor;
import br.edu.femass.Dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
                Livro livro = new Livro(
                        textTitulo.getText(),
                        (Autor) CBAutor.getSelectedItem()
                );
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
                Livro livro = (Livro) listLivros.getSelectedValue();
                if(livro==null) return;
                textCodigos.setText(livro.getCodigo().toString());
                textTitulo.setText(livro.getTitulo());
                CBAutor.setSelectedItem(livro.getAutor());
            }
        });
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
        try {
            listLivros.setListData(
                    new DaoLivro().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void abrirTela2(){
        JFrame frame = new JFrame();
        GuiLivro guiLivro = new GuiLivro();
        guiLivro.preencherLista();
        guiLivro.preencherListaAutro();
        frame.setContentPane(guiLivro.JPanelLivro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cadastrar Livro");
        frame.pack();
        frame.setVisible(true);
    }
}
