package br.edu.femass.Gui;

import br.edu.femass.Dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class GuiLeitorAtraso {
    private JPanel JPanelLeitorAtraso;
    private JList listLeitorAtraso;

    private void preencherLista(){
        try {
            DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
            Emprestimo emprestimo = new Emprestimo();
            //if(emprestimo.getDataPrevistaDevolicao()<=LocalDate.now()){
                listLeitorAtraso.setListData(new DaoEmprestimo().getAll().toArray());
            //}
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void abrirTela(){
        GuiLeitorAtraso guiLeitorAtraso = new GuiLeitorAtraso();
        guiLeitorAtraso.preencherLista();
        JDialog jFrame = new JDialog(new Frame(),true);
        jFrame.setTitle("Leitores em atraso");
        jFrame.setContentPane(guiLeitorAtraso.JPanelLeitorAtraso);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
