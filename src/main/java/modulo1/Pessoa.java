package modulo1;

import conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String sexo;
    private double saldo[];

    public Pessoa(){
        this.saldo = new double[]{0.0, 0.0};
    }

    public Pessoa(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void addSaldoCred(double cred){
        this.saldo[0] += cred;
    }

    public void retirarSaldoCred(double cred){
        this.saldo[0] -= cred;
    }

    public double getSaldoCred(){
        return this.saldo[0];
    }

    public void addSaldoDeb(double deb){
        this.saldo[1] += deb;
    }

    public void retirarSaldoDeb(double deb){
        this.saldo[1] -= deb;
    }

    public double getSaldoDev(){
        return this.saldo[1];
    }

    public double getCarteira(){
        return this.getSaldoCred() + this.getSaldoDev();
    }
}
