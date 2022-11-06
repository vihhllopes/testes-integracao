package modulo3;

import conexao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaFaculdade {

    private List<Faculdade> faculdades;

    public ListaFaculdade() {
        this.faculdades = new ArrayList<>();
    }

    public List<Faculdade> getFaculdades() {
        return faculdades;
    }

    public void setFaculdades(List<Faculdade> faculdades) {
        this.faculdades = faculdades;
    }

    public Faculdade pesquisarPorNome(String nome){
        return faculdades.stream().filter(f -> f.getNome().equals(nome)).findFirst().orElse(null);
    }

    public List<Faculdade> filtarPorNome(String nome){
        return faculdades.stream().filter(f -> f.getNome().contains(nome)).collect(Collectors.toList());
    }

    public List<Faculdade> findAll() {
        List<Faculdade> faculdades = new ArrayList<Faculdade>();
        try {
            Connection myConnection = Conexao.getConnection();
            Statement statement = myConnection.createStatement();
            String sql = "select * from faculdade";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Faculdade faculdade = new Faculdade();
                faculdade.setNome(resultSet.getString("nome"));
                faculdade.setArrecadado(Double.parseDouble(resultSet.getString("arrecadado")));
                faculdades.add(faculdade);
            }
            return faculdades;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculdades;
    }
}
