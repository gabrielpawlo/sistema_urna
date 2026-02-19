import java.util.ArrayList;

public class Cargo {

    private String nome;
    private ArrayList<Candidato> candidatos;
    private int votosBrancos;
    private int votosNulos;

    public Cargo(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            this.nome = "Indefinido";
        }
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
        try {
            if (c == null) {
                throw new IllegalArgumentException();
            }
            candidatos.add(c);
        } catch (IllegalArgumentException e) {
        }
    }

    //FALTA TRATAMENTO DE EXCECAO (numero invalido)
    //tratei
    public Candidato buscarCandidato(String numero) {
        try {
            if (numero == null || numero.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
            for (Candidato c : candidatos) {
                if (c.getNumero().equals(numero)) {
                    return c;
                }
            }
        } catch (IllegalArgumentException e) {
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
//talvez tenha muita tratacao de excecao