package br.edu.femass.Dao;

import br.edu.femass.model.Aluno;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoAluno extends Persistencia<Aluno> implements Dao<Aluno>{
    private final static String NOMEARQUIVO = "Aluno.json";

    @Override
    public void save(Aluno aluno) throws Exception {
        List<Aluno> alunos = getAll();
        alunos.add(aluno);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(alunos);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Aluno> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Aluno> alunos = getOjectmapper().readValue(json,
                    new TypeReference<List<Aluno>>() {});
            return alunos;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
