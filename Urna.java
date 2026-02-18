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
                System.out.println("");;

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
                ler.nextLine(); // limpa o buffer
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
        
        int escolha = ler.nextInt();
        ler.nextLine();

        Cargo cargo = cargos.get(escolha - 1);

            System.out.print("Digite o nome do candidato: ");
        String nome = ler.nextLine();

        System.out.print("Digite o número (3 dígitos, diferente de 999): ");
        int numero = ler.nextInt();

        if (numero == 999 || numero > 999) {
            System.out.println("Número inválido!");
            return;
        }
        cargo.adicionarCandidato(new Candidato(nome, numero));

        System.out.println("Candidato registrado!");
    }

    private void iniciarVotacao(){}
    private void confirmarVoto(){}
    private void encerrarEleicao(){}
}