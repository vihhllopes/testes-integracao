package modulo3;

public class Pagamento {

    //Valor será substituido pela classe pagamento
    public static boolean transacao(Faculdade faculdade, double valor) {
        if(valor <= 0){
            return false;
        }else if(faculdade == null){
            throw new NullPointerException("Faculdade não pode ser null");
        }

        faculdade.addReceita(valor);
        return true;
    }
}
