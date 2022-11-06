package modulo1;

import conexao.Conexao;
import modulo3.Faculdade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa{

    Faculdade faculdade;
    List<Pessoa> encarregados;

    public Gerente() {
    }

    public Gerente(String nome, int idade, String sexo, Faculdade faculdade, List<Pessoa> encarregados) {
        super(nome, idade, sexo);
        this.faculdade = faculdade;
        this.encarregados = encarregados;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public List<Pessoa> getEncarregados() {
        return encarregados;
    }

    public void setEncarregados(List<Pessoa> encarregados) {
        this.encarregados = encarregados;
    }

    public boolean isFull(){
        List<Class> classesFound = new ArrayList<>();
        for(Pessoa p : encarregados){
            if(!classesFound.contains(p.getClass())){
                classesFound.add(p.getClass());
            }
        }
        return classesFound.size() == 3;
    }

    public List<String> getFuncionarios() {
        List<String> funcionario = new ArrayList<>();
        try {
            Connection myConnection = Conexao.getConnection();
            Statement statement = myConnection.createStatement();
            String sql = "select b.nome from bibliotecario b, gerente g where g.id = b.gerente AND g.nome = '"+this.getNome()+"'";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                funcionario.add(resultSet.getString("nome"));
            }
            return funcionario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
}
