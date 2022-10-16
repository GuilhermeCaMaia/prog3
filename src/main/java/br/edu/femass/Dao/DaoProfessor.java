package br.edu.femass.Dao;

import br.edu.femass.model.Professor;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoProfessor extends Persistencia<Professor> implements Dao<Professor>{
    private final static String NOMEARQUIVO = "Professor.json";

    @Override
    public void save(Professor professor) throws Exception {
        List<Professor> professors = getAll();
        professors.add(professor);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(professors);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Professor> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Professor> professors = getOjectmapper().readValue(json,
                    new TypeReference<List<Professor>>() {});
            return professors;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
