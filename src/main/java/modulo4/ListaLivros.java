package modulo4;

import java.util.ArrayList;
import java.util.List;


public class ListaLivros {

    private List<Livro> livros;

    public ListaLivros() {
        this.livros = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Livro findPorCodigo(String codigo){
        return livros.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public Livro findPorNome(String nome){
        return livros.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
    }

    public Livro findPorAutor(String autor){
        return livros.stream().filter(p -> p.getAutor().equals(autor)).findFirst().orElse(null);
    }

    public List<Livro> groupNyName(String name){
        List<Livro> livrosReturn = new ArrayList<Livro>();

        this.getLivros().forEach(l -> {
            if(l.getNome().startsWith(name)){
                livrosReturn.add(l);
            }
        });

        return livrosReturn;
    }
}
