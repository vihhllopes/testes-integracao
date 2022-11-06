package modulo4;

import modulo1.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ListaPessoas {

    private List<Pessoa> pessoas;

    public ListaPessoas(){
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void  setPessoas(List<Pessoa> pessoas){
        this.pessoas = pessoas;
    }

    public Pessoa findPorNome(String nome){
        return pessoas.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
    }

    public Pessoa findPorIdade(int idade){
        return (Pessoa) pessoas.stream().filter(p -> p.getIdade() == idade);
    }

    public Pessoa findPorSaldo(double saldo){
        return (Pessoa) pessoas.stream().filter(p -> p.getCarteira() == saldo);
    }
}
