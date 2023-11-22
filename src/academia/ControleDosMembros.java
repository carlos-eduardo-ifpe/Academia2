package academia;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ControleDosMembros {
    private final Scanner sc = new Scanner(System.in);

    private int getIntInput() {
        int escolha = 0;
        while (escolha == 0) {
            try {
                escolha = sc.nextInt();
                if (escolha == 0)
                    throw new InputMismatchException();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("\nEntrada Inválida!!! Por favor tente novamente.");
            }
        }
        return escolha;
    }

    private void printClubOptions() {
        System.out.println("\n1) Clube Musculação");
        System.out.println("2) Clube Natação");
        System.out.println("3) Clube Crossfit");
        System.out.println("4) Todos os Clubes");
    }

    public int getEscolha() {
        int escolha;
        System.out.println("\nBem-vindo à Academia Pedra Vermelha");
        System.out.println("================================");
        System.out.println("1) Adicionar novo Membro");
        System.out.println("2) Remover Membro");
        System.out.println("3) Mostrar Informação do Membro");
        System.out.print("\nSelecione uma opção (ou insira -1 para sair): ");
        escolha = getIntInput();
        return escolha;
    }

    public Membro addMembro(LinkedList<Membro> m) {
        String nome;
        int clube;
        double mensalidade;
        int NumMembro;
        Membro membro;
        Calculadora<Integer> cal;

        System.out.print("\nPor favor, insira o nome do Membro: ");
        nome = sc.nextLine();
        printClubOptions();
        System.out.print("\nPor favor, insira o numero do clube do Membro: ");
        clube = getIntInput();

        while (clube < 1 || clube > 4) {
            System.out.print("\nClube Inválido. Tente novamente: ");
            clube = getIntInput();
        }

        if (m.size() > 0)
            NumMembro = m.getLast().getNumMembro() + 1;
        else
            NumMembro = 1;

        if (clube != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 60;
                    case 2:
                        return 65;
                    case 3:
                        return 70;
                    default:
                        return -1;
                }
            };
            mensalidade = cal.calculaMensalidade(clube);
            membro = new MembroSingular('S', NumMembro, nome, mensalidade, clube);
            m.add(membro);
            System.out.println("\nNovo Membro Singular Adicionado.\n");
        } else {
            cal = (n) -> {
                if (n == 4)
                    return 120;
                else
                    return -1;
            };
            mensalidade = cal.calculaMensalidade(clube);
            membro = new MultiMembros('P', NumMembro, nome, mensalidade, 100);
            m.add(membro);
            System.out.println("\nNovo Membro Plural Adicionado.\n");
        }
        return membro;
    }

    public void removeMembro(LinkedList<Membro> m) {
        int NumMembro;
        System.out.print("\nDigite o Numero do membro cadastrado que deseja remover: ");
        NumMembro = getIntInput();
        
        for (Membro mem : new LinkedList<>(m)) {
            if (mem.getNumMembro() == NumMembro) {
                m.remove(mem);
                System.out.print("\nMembro Removido\n");
                return;
            }
        }
        System.out.println("\nNumero de Cadastro não encontrado \n");
    }

    public void printMembroInfo(LinkedList<Membro> m) {
        int NumMembro;
        System.out.print("\nDigite a identidade do membro para mostrar informação: ");
        NumMembro = getIntInput();
        
        for (Membro mem : m) {
            if (mem.getNumMembro() == NumMembro) {
                String[] membroInfo = mem.toString().split(", ");
                System.out.println("\nTipo de Membro = " + membroInfo[0]);
                System.out.println("Numero = " + membroInfo[1]);
                System.out.println("Nome = " + membroInfo[2]);
                System.out.println("Valor da Mensalidade = " + membroInfo[3]);
                if (membroInfo[0].equals("S")) {
                    System.out.println("Clube nº = " + membroInfo[4]);
                } else {
                    System.out.println("Pontos de Fidelidade = " + membroInfo[4]);
                }
                return;
            }
        }
        System.out.println("\nCPF não encontrado.\n");
    }

    public void fecharScanner() {
        sc.close();
    }
}
