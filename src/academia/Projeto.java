package academia;

import java.util.LinkedList;

public class Projeto {
    public static void main(String[] args) {
        String memb;
        ControleDosMembros mm = new ControleDosMembros();
        Organizador fh = new Organizador();
        LinkedList<Membro> membros = fh.readFile();
        int escolha = mm.getEscolha();

        while (escolha != -1) {
            switch (escolha) {
                case 1:
                    Membro novoMembro = mm.addMembro(membros);
                    if (novoMembro != null) {
                        memb = novoMembro.toString();
                        fh.appendFile(memb);
                    }
                    break;
                case 2:
                    mm.removeMembro(membros);
                    fh.overwriteFile(membros);
                    break;
                case 3:
                    mm.printMembroInfo(membros);
                    break;
                default:
                    System.out.print("\nVocê selecionou uma opção inválida\n\n");
                    break;
            }
            escolha = mm.getEscolha();
        }

        mm.fecharScanner();
        System.out.println("\nAdeus!");
    }
}

