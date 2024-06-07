import java.util.ArrayList;
import java.util.List;

public class Administrador extends Funcionario {
    private final List<Membro> membros;

    public Administrador(int id, String nome, String cpf, String cargo) {
        super(id, nome, cpf, cargo);
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(int id, String nome) {
        Membro novoMembro = new Membro(id, nome);
        membros.add(novoMembro);
        System.out.println("Membro adicionado com sucesso: " + novoMembro.getNome());
    }

    public Membro buscarMembroPorId(int id) {
        for (Membro membro : membros) {
            if (membro.getId() == id) {
                return membro;
            }
        }
        System.out.println("Membro não encontrado.");
        return null;
    }

    public void promoverParaFuncionario(Membro membro) {
        // Lógica para promover um membro para funcionário
        System.out.println("Membro promovido para funcionário: " + membro.getNome());
    }
}