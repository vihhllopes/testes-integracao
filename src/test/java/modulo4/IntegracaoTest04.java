package modulo4.integracao;

import modulo1.Bibliotecario;
import modulo1.Estudante;
import modulo1.Gerente;
import modulo1.Professor;
import modulo4.ListaLivros;
import modulo4.ListaPessoas;
import modulo4.Livro;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegracaoTest04 {

    @Test
    public void listarEstudantesFromPessoas(){
        ListaPessoas listaPessoas = Mockito.mock(ListaPessoas.class);
        Mockito.when(listaPessoas.getPessoas()).thenReturn(Arrays.asList(new Estudante(),new Estudante(),new Professor(),new Professor(),new Estudante(),new Gerente(),new Estudante(),new Estudante(),new Bibliotecario()));
        List<Estudante> estudantes = new ArrayList<Estudante>();

        listaPessoas.getPessoas().forEach(p -> {
            if(p.getClass() == Estudante.class){
                estudantes.add((Estudante) p);
            }
        });

        Assertions.assertEquals(5, estudantes.size());
    }

    @Test
    public void listarEstudantesFromPessoaInexistente(){
        ListaPessoas listaPessoas = Mockito.mock(ListaPessoas.class);
        Mockito.when(listaPessoas.getPessoas()).thenReturn(Arrays.asList(new Professor(),new Professor(),new Gerente(),new Bibliotecario()));
        List<Estudante> estudantes = new ArrayList<Estudante>();

        listaPessoas.getPessoas().forEach(p -> {
            if(p.getClass() == Estudante.class){
                estudantes.add((Estudante) p);
            }
        });

        Assertions.assertEquals(0, estudantes.size());
    }


    @Test
    public void agruparLivrosByName(){
        ListaLivros listaLivros = Mockito.mock(ListaLivros.class);
        Mockito.when(listaLivros.groupNyName("Use a cabeça!")).thenReturn(Livro.findAll());
        Assertions.assertEquals(0, listaLivros.groupNyName("Use a cabeça!").size());
        Mockito.verify(listaLivros, Mockito.atMost(0)).getLivros();
    }


}
