package br.edu.femass.Dao;

import br.edu.femass.model.Leitor;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoLeitor extends Persistencia<Leitor> implements Dao<Leitor>{
    private final static String NOMEARQUIVO = "Leitor.json";

    @Override
    public void save(Leitor leitor) throws Exception {
        List<Leitor> leitors = getAll();
        leitors.add(leitor);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(leitors);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Leitor> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Leitor> leitors = getOjectmapper().readValue(json,
                    new TypeReference<List<Leitor>>() {});
            return leitors;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
}
