import java.util.ArrayList;
import java.util.Scanner;

public class Urna {
    private ArrayList<Cargo> cargos;
    private Scanner ler;

    public Urna(){
        cargos = new ArrayList<>();
        ler = new Scanner(System.in);
    }

    //MENU COM AS OPCOES DA URNA
    public void menu(){
        int opcao;

        while (true) {

            try {

                System.out.println("-------Urna Eletronica--------");
                System.out.println("MENU");
                System.out.println("1 - Cadastro de cargo");
                System.out.println("2 - Cadastro de candidato");
                System.out.println("3 - Iniciar votacao");
                System.out.println("4 - SAIR");
                System.out.println("");

                opcao = ler.nextInt();
                ler.nextLine();

                if (opcao < 1 || opcao > 4) {
                    throw new IllegalArgumentException();
                }

                switch (opcao) {
                    case 1:
                        cadastrarCargo();
                        break;
                    case 2:
                        cadastrarCandidato();
                        break;
                    case 3:
                        iniciarVotacao();
                        break;
                    case 4:
                        System.out.println("Encerrando....");
                        return;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Opcao invalida! Digite de 1 a 4.");
            }

            catch (Exception e) {
                System.out.println("Entrada invalida! Digite apenas numeros.");
                ler.nextLine();
            }
        }
    }

    private void cadastrarCargo(){
        System.out.println("\nCADASTRO DE CARGO");
        System.out.println("Nome do cargo: ");
        String nome = ler.nextLine();

        cargos.add(new Cargo(nome));
        System.out.println("Cargo adicionado");
    }

    private void cadastrarCandidato(){
        if (cargos.isEmpty()){
            System.out.println("Nao e possivel, pois nao tem nenhum cargo");
            return;
        }

        System.out.println("\nCADASTRO DE CANDIDATO");
        System.out.println("Escolha o cargo:");

        for (int i = 0; i < cargos.size(); i++) {
            System.out.println((i + 1) + " - " + cargos.get(i).getNome());
        }

        int escolha;

        while (true) {
            try {
                escolha = ler.nextInt();
                ler.nextLine();

                if (escolha < 1 || escolha > cargos.size()) {
                    throw new IllegalArgumentException();
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Entrada invalida! Digite um numero entre 1 e " + cargos.size());
            } catch (Exception e) {
                System.out.println("Entrada invalida! Digite apenas numeros.");
                ler.nextLine();
            }
        }

        Cargo cargo = cargos.get(escolha - 1);

        System.out.print("Digite o nome do candidato: ");
        String nome = ler.nextLine();

        String numero;

        while (true) {
            System.out.print("Digite o número (3 digitos): ");
            numero = ler.nextLine();

            if (!numero.matches("\\d{3}") ||
                numero.equals("000") ||
                numero.equals("111") ||
                numero.equals("999")) {

                System.out.println("Número invalido! Nao pode ser 000, 111 ou 999 e deve conter apenas 3 digitos.");
            } else {
                break;
            }
        }

        cargo.adicionarCandidato(new Candidato(nome, numero));

        System.out.println("Candidato registrado!");
    }

    private void iniciarVotacao() {

        for (Cargo cargo : cargos) {

            while (true) {

                System.out.println("\n------Urna Eletronica---------");
                System.out.println("Processo de eleicao para o cargo de " + cargo.getNome());
                System.out.println("Candidatos:");

                for (Candidato c : cargo.getCandidatos()) {
                    System.out.println(c.getNumero() + " - " + c.getNome());
                }

                System.out.println("000 - BRANCO");

                System.out.print("Insira seu voto: ");
                String voto = ler.nextLine();

                if (voto.equals("999")) {
                    encerrarEleicao();
                    return;
                }

                if (voto.equals("000")) {

                    System.out.println("Voce esta votando BRANCO");
                    if (confirmar()) {
                        cargo.votarBranco();
                        System.out.println("Voto registrado");
                        break;
                    }

                    continue;
                }

                Candidato candidato = cargo.buscarCandidato(voto);

                if (candidato != null) {

                    System.out.println("Voce esta votando " +
                            candidato.getNumero() + " - " + candidato.getNome());

                    if (confirmar()) {
                        candidato.adicionarVoto();
                        System.out.println("Voto registrado");
                        break;
                    }

                } else {

                    System.out.println("Voce esta votando NULO");

                    if (confirmar()) {
                        cargo.votarNulo();
                        System.out.println("Voto registrado");
                        break;
                    }
                }
            }
        }
    }

    private boolean confirmar() {
        System.out.println("\nAperte a tecla:");
        System.out.println("CONFIRMA (2) para CONFIRMAR este voto");
        System.out.println("CORRIGE (1) para REINICIAR este voto");

        int opcao = ler.nextInt();
        ler.nextLine();

        if (opcao == 2) {
            return true;
        }

        System.out.println("Voto reiniciado!");
        return false;
    }

    private void encerrarEleicao(){
        System.out.println("\nELEICAO ENCERRADA");
        System.out.println("Gerando resultados\n");

        for (Cargo cargo : cargos) {

            System.out.println(" - Cargo " + cargo.getNome() + " -");

            for (Candidato c : cargo.getCandidatos()) {
                System.out.println(c.getVotos() + " - " + c.getNome());
            }

            System.out.println(cargo.getVotosBrancos() + " - BRANCO");
            System.out.println(cargo.getVotosNulos() + " - NULO\n");
        }
    }
}

//numero como string