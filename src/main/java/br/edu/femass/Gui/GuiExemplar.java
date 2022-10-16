package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoAutor;
import br.edu.femass.Dao.DaoExemplar;
import br.edu.femass.Dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class GuiExemplar {
    private JPanel JPanelExemplar;
    private JList listLivros;
    private JList listExemplar;
    private JButton salvarButton;
    private JComboBox cBAutor;


    public GuiExemplar() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = new Exemplar();
                    exemplar = new Exemplar();
                    new DaoExemplar().save(exemplar);// adicionar os nomes dos livros tbm
                    preencherListaExemplar();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void preencherListaExemplar(){
        try {
            listExemplar.setListData(new DaoExemplar().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    private void preencherListaAutro(){
        try {
            List<Autor> autors = new DaoAutor().getAll();
            cBAutor.removeAllItems();
            for (Autor autor: autors){
                cBAutor.addItem(autor);
            }
            listLivros.setListData(
                    new DaoLivro().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private void preencherListaLivro(){
        DaoLivro daoLivro = new DaoLivro();
        Autor autor = new Autor();
        if(cBAutor.equals(autor)){
            try {
                listLivros.setListData(
                        new DaoLivro().getAll().toArray());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }

    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiExemplar guiExemplar = new GuiExemplar();
        JDialog jFrame = new JDialog(new Frame(), true);
        guiExemplar.preencherListaAutro();
        guiExemplar.preencherListaExemplar();
        guiExemplar.preencherListaLivro();
        jFrame.setContentPane(guiExemplar.JPanelExemplar);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
