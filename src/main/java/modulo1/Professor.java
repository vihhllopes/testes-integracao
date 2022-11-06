package modulo1;

import java.util.List;

public class Professor extends Pessoa{
    private List<String> cadeiras;
    private String matricula;

    public Professor() {
    }

    public Professor(String nome, int idade, String sexo, List<String> cadeiras, String matricula) {
        super(nome, idade, sexo);
        this.cadeiras = cadeiras;
        this.matricula = matricula;
    }

    public List<String> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(List<String> cadeiras) {
        this.cadeiras = cadeiras;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean verificaCadeiraNaLista(String cadeira){
        for(String c : cadeiras){
            if (c.equals(cadeira)){
                return true;
            }
        }
        return false;
    }

    public boolean validaMatricula(){
        if(matricula.isEmpty() || matricula.isBlank()){
            return false;
        }else if(matricula.length() < 8){
            return false;
        }else if(matricula.charAt(0) != 'P'){
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
}
