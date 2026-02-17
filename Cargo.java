import java.util.ArrayList;

public class Cargo {

    private String nome;
    private ArrayList<Candidato> candidatos;

    public Cargo(String nome){
        this.nome = nome;
        candidatos = new ArrayList<>();
    }

    public void adicionarCandidato(Candidato c){
        candidatos.add(c);
    }

    //DENTRO DO BUSCAR CANDIDATO
    //TEM QUE TRATAR A EXCECAO CASO NAO ENCONTRE NENHUM NUMERO
    public Candidato buscarCandidato(int numero){
        for (Candidato candidato : candidatos) {
            if(candidato.getNumero() == numero)
                return candidato;
        }
        return null;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Candidato> getCandidatos(){
        return candidatos;
    }
}
