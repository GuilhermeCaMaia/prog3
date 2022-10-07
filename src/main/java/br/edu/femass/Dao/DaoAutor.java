package br.edu.femass.Dao;

import br.edu.femass.model.Autor;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoAutor extends Persistencia<Autor> implements Dao<Autor>{
    private final static String NOMEARQUIVO = "Autor.json";
    @Override
    public void save(Autor autor) throws Exception {
        List<Autor> autors = getAll();
        autors.add(autor);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(autors);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Autor> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Autor> autors = getOjectmapper().readValue(json,
                    new TypeReference<List<Autor>>() {});
            return autors;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
