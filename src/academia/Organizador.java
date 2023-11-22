package academia;

import java.io.*;
import java.util.LinkedList;

public class Organizador {
    public LinkedList<Membro> readFile() {
        LinkedList<Membro> m = new LinkedList<>();
        String linhaLida;
        String[] splitLine;
        Membro mem;

        try (BufferedReader leitor = new BufferedReader(new FileReader("Membros.csv"))) {
            linhaLida = leitor.readLine();
            while (linhaLida != null) {
                splitLine = linhaLida.split(", ");
                if (splitLine.length >= 5) {
                    if (splitLine[0].equals("S")) {
                        mem = new MembroSingular('S', Integer.parseInt(splitLine[1]),
                                splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    } else {
                        mem = new MultiMembros('M', Integer.parseInt(splitLine[1]),
                                splitLine[2], Double.parseDouble(splitLine[3]),
                                Integer.parseInt(splitLine[4]));
                    }
                    m.add(mem);
                } else {
                    System.out.println("Erro ao ler a linha do arquivo: " + linhaLida);
                }
                linhaLida = leitor.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    public void appendFile(String mem) {
        if (mem != null && !mem.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Membros.csv", true))) {
                writer.write(mem + "\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void overwriteFile(LinkedList<Membro> m) {
        String s;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Membros.temp", false))) {
            for (Membro mem : m) {
                s = mem.toString();
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            File f = new File("Membros.csv");
            File tf = new File("Membros.temp");
            f.delete();
            tf.renameTo(f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
