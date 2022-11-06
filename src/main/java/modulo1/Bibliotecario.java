package modulo1;

import modulo3.Faculdade;
import conexao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bibliotecario extends Pessoa{
    private String matricula;
    private Gerente gerente;
    private Faculdade faculdade;

    public Bibliotecario() {
    }

    public Bibliotecario(String nome, int idade, String sexo, String matricula, Gerente gerente, Faculdade faculdade) {
        super(nome, idade, sexo);
        this.matricula = matricula;
        this.gerente = gerente;
        this.faculdade = faculdade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public boolean validaMatricula(){
        if(matricula.isEmpty() || matricula.isBlank()){
            return false;
        }else if(matricula.length() < 8){
            return false;
        }else if(matricula.charAt(0) != 'B'){
            return false;
        }else{
            matricula = matricula.substring(1);
            try {
                Integer.parseInt(matricula);
            }catch (Exception e){
                return false;
            }
            return true;
        }
    }

    public boolean verificaGerente(){
        for(Pessoa p : gerente.getEncarregados()){
            if(p == this){
                return true;
            }
        }
        return false;
    }

    public String findBibliotecaById() {
        try {
            Connection myConnection = Conexao.getConnection();
            Statement statement = myConnection.createStatement();
            String sql = "select bi.nome from biblioteca bi, bibliotecario b where b.id = bi.bibliotecario AND b.matricula = " +this.getMatricula();
            ResultSet resultSet = statement.executeQuery(sql);

            String bibliotecaName = "";
            while(resultSet.next()){
                bibliotecaName = resultSet.getString("nome");
            }
            return bibliotecaName;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

}
