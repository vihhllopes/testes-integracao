package modulo1.integracao;

import modulo1.*;
import modulo3.Faculdade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class IntegracaoTeste01 {
    @Test
    public void getEstudantesByPeriodo() {
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(2)).thenReturn(Arrays.asList("Maria Victória", "Katarina", "Arthur"));
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertFalse(estudantes.size() > 2);
    }

    @Test
    public void getEstudantesByPeriodoverifyTrue(){
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(1)).thenReturn(Arrays.asList("Maria Victória", "Katarina", "Arthur"));
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertTrue(estudantes.size()>2);
        Mockito.verify(estudante).findByPeriodo(1);
    }
    @Test
    public void getEstudantesByPeriodoverifyFalse(){
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(2)).thenReturn(Arrays.asList("Maria Victória", "Katarina", "Arthur"));
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertFalse(estudantes.size()>2);
        Mockito.verify(estudante).findByPeriodo(1);
    }
    @Test
    public void InsertEstudante(){
        Estudante estudante = Mockito.mock(Estudante.class);
        List<Estudante> estudantes = Arrays.asList(new Estudante());
        Mockito.when(estudante.insertEstudantes(estudantes)).thenReturn(true);
        Assertions.assertTrue(estudante.insertEstudantes(estudantes));
    }
    @Test
    public void InsertEstudanteverify(){
        Estudante estudante = Mockito.mock(Estudante.class);
        List<Estudante> estudantes = Arrays.asList(new Estudante());
        Mockito.when(estudante.insertEstudantes(estudantes)).thenReturn(true);
        Assertions.assertTrue(estudante.insertEstudantes(estudantes));
        Mockito.verify(estudante).insertEstudantes(estudantes);
    }



}
