package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAutor {
    private JList listAutores;
    private JTextField textNome;
    private JTextField textSobrenome;
    private JTextField textNacionalidade;
    private JButton BtnPoximo;
    private JButton BtnGravar;
    private JPanel JPanelCadastrarAutor;
    private JScrollPane JScrollDeAutror;

    public GuiAutor() {
        BtnGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Autor autor = new Autor(textNome.getText(),
                        textSobrenome.getText(),
                        textNacionalidade.getText());
                try {
                    new DaoAutor().save(autor);
                    preencherLista();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        listAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) listAutores.getSelectedValue();
                if (autor==null) return;
                textNome.setText(autor.getNome());
                textSobrenome.setText(autor.getSobrenome());
                textNacionalidade.setText(autor.getNacionalidade());
            }
        });
    }
    public JPanel getJPanelCadastrarAutor(){return JPanelCadastrarAutor;}

    private void preencherLista(){
        try {
            listAutores.setListData(
                    new DaoAutor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.preencherLista();
        frame.setContentPane(guiAutor.JPanelCadastrarAutor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cadastrar autor");
        frame.pack();
        frame.setVisible(true);
    }

}
