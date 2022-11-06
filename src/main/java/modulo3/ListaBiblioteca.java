package modulo3;

import conexao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaBiblioteca {

    private List<Biblioteca> bibliotecas;

    public ListaBiblioteca() {
        this.bibliotecas = new ArrayList<>();
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Biblioteca findPorNome(String nome){
        return bibliotecas.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
    }

    public Biblioteca findPorGerente(String nome){
        return bibliotecas.stream().filter(p -> p.getGerente().getNome().equals(nome)).findFirst().orElse(null);
    }

    public List<Biblioteca> findPorQuantLivros(int quant){
        return bibliotecas.stream().filter(p -> p.getLivros().size() >= quant).collect(Collectors.toList());
    }

    public List<Biblioteca> findAll() {
        List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
        try {
            Connection myConnection = Conexao.getConnection();
            Statement statement = myConnection.createStatement();
            String sql = "select * from biblioteca";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setNome(resultSet.getString("nome"));
                bibliotecas.add(biblioteca);
            }
            return bibliotecas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bibliotecas;
    }
}
