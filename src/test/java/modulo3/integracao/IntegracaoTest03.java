package modulo3.integracao;

import modulo3.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class IntegracaoTest03 {


    @Test
    public void addReceitaFaculVerifyTrue(){
        Faculdade faculdade = Mockito.mock(Faculdade.class);
        Mockito.when(faculdade.getArrecadado()).thenReturn(100.0);

        boolean pagamentoResult = Pagamento.transacao(faculdade, 100);
        Mockito.verify(faculdade).addReceita(100);

        Assertions.assertTrue(pagamentoResult);
    }


    @Test
    public void getFaculdades(){
        ListaFaculdade faculdades = Mockito.mock(ListaFaculdade.class);

        Faculdade faculdade = new Faculdade();
        faculdade.setNome("FAFIRE");
        faculdade.setArrecadado(2000000);

        Mockito.when(faculdades.findAll()).thenReturn(Arrays.asList(faculdade));
        List<Faculdade> faculdadeList = faculdades.findAll();

        Assertions.assertEquals("FAFIRE", faculdadeList.get(0).getNome());
    }

    @Test
    public void getFaculdadesInexistente(){
        ListaFaculdade faculdades = Mockito.mock(ListaFaculdade.class);

        Faculdade faculdade = new Faculdade();
        faculdade.setNome("UNICAP");
        faculdade.setArrecadado(2000000);

        Mockito.when(faculdades.findAll()).thenReturn(Arrays.asList(faculdade));
        List<Faculdade> faculdadeList = faculdades.findAll();

        Assertions.assertNotEquals("FAFIRE", faculdadeList.get(0).getNome());
    }
    @Test
    public void getBibliotecas(){
        ListaBiblioteca bibliotecas = Mockito.mock(ListaBiblioteca.class);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("São Cristovão");

        Mockito.when(bibliotecas.findAll()).thenReturn(Arrays.asList(biblioteca));
        List<Biblioteca> bibliotecaList = bibliotecas.findAll();

        Assertions.assertEquals("São Cristovão", bibliotecaList.get(0).getNome());
    }


    @Test
    public void getBibliotecasInexistente(){
        ListaBiblioteca bibliotecas = Mockito.mock(ListaBiblioteca.class);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("São Jorge");

        Mockito.when(bibliotecas.findAll()).thenReturn(Arrays.asList(biblioteca));
        List<Biblioteca> bibliotecaList = bibliotecas.findAll();

        Assertions.assertNotEquals("São Cristovão", bibliotecaList.get(0).getNome());
    }


}