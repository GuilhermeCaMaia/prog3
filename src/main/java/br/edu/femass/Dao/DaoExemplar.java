package br.edu.femass.Dao;

import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoExemplar extends Persistencia<Exemplar> implements Dao<Exemplar>{
    private final static String NOMEARQUIVO = "Exemplar.json";

    @Override
    public void save(Exemplar exemplar) throws Exception {
        List<Exemplar> exemplars = getAll();
        exemplars.add(exemplar);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(exemplars);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Exemplar> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Exemplar> exemplars = getOjectmapper().readValue(json,
                    new TypeReference<List<Exemplar>>() {});
            return exemplars;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
    public List<Exemplar> getAll(Livro livro) throws Exception {
        List<Exemplar> exemplars = getAll();
        List<Exemplar> exemplarsNovo = getAll();

        for(Exemplar exemplar: exemplars){
            if(exemplar.getLivro().getAutor().equals(livro.getAutor())){
                exemplarsNovo.add(exemplar);
            }
        }
        return exemplarsNovo;
    }
}
