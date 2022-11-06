package modulo1;

import conexao.Conexao;
import modulo3.Faculdade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estudante extends Pessoa{
    private String curso;
    private int periodo;
    private Faculdade faculdade;
    private String matricula;

    public Estudante() {
    }

    public Estudante(String nome, int idade, String sexo, String curso, int periodo, Faculdade faculdade, String matricula) {
        super(nome, idade, sexo);
        this.curso = curso;
        this.periodo = periodo;
        this.faculdade = faculdade;
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean validarPeriodo(){
        return periodo > 0 && periodo <= 8;
    }

    public boolean validaMatricula(){
        if(matricula.isEmpty() || matricula.isBlank()){
            return false;
        }else if(matricula.length() < 8){
            return false;
        }else{
            try {
                Integer.parseInt(matricula);
            }catch (Exception e){
                return false;
            }
            return true;
        }
    }

    public List<String> findByPeriodo(int p) {
        List<String> estudantes = new ArrayList<>();
        try {
            Connection myConnection = Conexao.getConnection();
            Statement statement = myConnection.createStatement();
            String sql = "select nome from estudantes where periodo = "+p;
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                estudantes.add(resultSet.getString("nome"));
            }
            return estudantes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }

    public boolean insertEstudantes(List<Estudante> estudantes){
        for(Estudante e : estudantes){
            if (!salvarEstudante(e))
                return false;
        }
        return true;
    };

    public boolean salvarEstudante(Estudante estudante){
        try {
            Connection myConnection = Conexao.getConnection();
            String sql = "insert into estudante (NOME, IDADE, SEXO, CURSO, PERIODO, MATRICULA, FACULDADE ) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparableStatement = myConnection.prepareStatement(sql);
            preparableStatement.setString(1, estudante.getNome());
            preparableStatement.setString(2, String.valueOf(estudante.getIdade()));
            preparableStatement.setString(3, estudante.getSexo());
            preparableStatement.setString(4, estudante.getCurso());
            preparableStatement.setString(5, String.valueOf(estudante.getPeriodo()));
            preparableStatement.setString(6, estudante.getMatricula());
            preparableStatement.setString(7, String.valueOf(1));
            preparableStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
