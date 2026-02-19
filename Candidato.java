public class Candidato {

    private String nome;
    private String numero;
    private int votos;


    //adicionar .trim para remover espacos em branco da string
    //.trim + tratamento
    public Candidato(String nome, String numero) {
        try {
            if (nome == null || nome.trim().isEmpty() || numero == null || numero.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
            this.nome = nome;
            this.numero = numero;
        } catch (IllegalArgumentException e) {
            this.nome = "Indefinido";
            this.numero = "0";
        }
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public int getVotos() {
        return votos;
    }

    public void adicionarVoto() {
        try {
            votos++;
        } catch (Exception e) {
        }
    }
}
