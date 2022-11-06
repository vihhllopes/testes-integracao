package modulo3;

import conexao.Conexao;
import modulo1.Bibliotecario;
import modulo1.Gerente;
import modulo4.Livro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;

    private Gerente gerente; //Enquanto a classe de gerente não é criada

    private Bibliotecario bibliotecario;

    private List<Livro> livros; //Enquanto a classe livro não é criada

    private List<String> devolucao; //enquanto a classe devolução não é criada

    private List<String> emprestimo; //enquanto a classe emprestimo não é criada

    public boolean possueLivro(String nome){
        return livros.stream().filter(p -> p.getNome().equals(nome)).count() >= 1;
    }

    public boolean possuiLivros(List<Livro> lista){
        return livros.stream().filter(lista::contains).count() == lista.size();
    }

    public double precoDoParaEmprestimo(int quant){
        return quant * 0.5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<String> getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(List<String> devolucao) {
        this.devolucao = devolucao;
    }

    public List<String> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(List<String> emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public int findIdByName(){
        try {
            int id = 0;
            Connection myConnection = Conexao.getConnection();
            Statement statement = myConnection.createStatement();
            String sql = "select ID from biblioteca where nome = '"+this.getNome()+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                id = Integer.parseInt(resultSet.getString("id"));
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


