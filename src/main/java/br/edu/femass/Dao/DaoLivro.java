package br.edu.femass.Dao;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro extends Persistencia<Livro> implements Dao<Livro>{
    private final static String NOMEARQUIVO = "Livro.json";
    @Override
    public void save(Livro livro) throws Exception {
        List<Livro> livros = getAll();
        livros.add(livro);
        String json = getOjectmapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(livros);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    @Override
    public List<Livro> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Livro> livros = getOjectmapper().readValue(json,
                    new TypeReference<List<Livro>>() {});
            return livros;
        }catch (FileNotFoundException f){
            return new ArrayList<>();
        }
    }
    public List<Livro> getAll(Autor autor) throws Exception{
        List<Livro> livros = getAll();
        List<Livro> livrosFiltrados = new ArrayList<>();

        for (Livro livro: livros){
            if(livro.getAutor().equals(autor)){
                livrosFiltrados.add(livro);
            }
        }

        return livrosFiltrados;
    }
}
