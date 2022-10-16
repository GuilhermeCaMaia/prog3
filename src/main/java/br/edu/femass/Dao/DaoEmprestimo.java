package br.edu.femass.Dao;

import br.edu.femass.model.Emprestimo;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoEmprestimo extends Persistencia<Emprestimo> implements Dao<Emprestimo>{
    private final static String NOMEARQUIVO = "Emprestimo.json";

    @Override
    public void save(Emprestimo emprestimo) throws Exception {
        List<Emprestimo> emprestimos = getAll();
        emprestimos.add(emprestimo);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(emprestimos);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Emprestimo> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Emprestimo> emprestimos = getOjectmapper().readValue(json,
                    new TypeReference<List<Emprestimo>>() {});
            return emprestimos;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
