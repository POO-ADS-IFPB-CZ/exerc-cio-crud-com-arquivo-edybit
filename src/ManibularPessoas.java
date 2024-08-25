import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ManibularPessoas {

    private Set<Pessoa> pessoas;
    private final String arquivo;

   public ManibularPessoas(String arquivo){
       this.arquivo = arquivo;
       this.pessoas = new HashSet<>();
       carregarPessoas();
   }

   public Set<Pessoa> listaPessoas(){
       return pessoas;
   }
    public void adicionarPessoas(Pessoa pessoa){
       pessoas.add(pessoa);
       salvaPessoas();
    }

    private void salvaPessoas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar pessoas: " + e.getMessage());
        }
    }

    private void deletarPessoas(String email){
       pessoas.removeIf(pessoa -> pessoa.getEmail().equals(email));
       salvaPessoas();
    }

    private void carregarPessoas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoas = (Set<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar pessoas: " + e.getMessage());
        }
    }
}
