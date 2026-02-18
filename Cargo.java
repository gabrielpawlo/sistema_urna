import java.util.ArrayList;

public class Cargo {

    private String nome;
    private ArrayList<Candidato> candidatos;
    private int votosBrancos;
    private int votosNulos;

    public Cargo(String nome) {
        this.nome = nome;
        candidatos = new ArrayList<>();
        votosBrancos = 0;
        votosNulos = 0;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void adicionarCandidato(Candidato c) {
        candidatos.add(c);
    }

    public Candidato buscarCandidato(int numero) {
        for (Candidato c : candidatos) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public void votarBranco() {
        votosBrancos++;
    }

    public void votarNulo() {
        votosNulos++;
    }

    public int getVotosBrancos() {
        return votosBrancos;
    }

    public int getVotosNulos() {
        return votosNulos;
    }
}
