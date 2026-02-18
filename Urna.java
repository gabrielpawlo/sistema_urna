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
    }
    private void cadastrarCandidato(){}
    private void iniciarVotacao(){}
    private void confirmarVoto(){}
    private void encerrarEleicao(){}
}