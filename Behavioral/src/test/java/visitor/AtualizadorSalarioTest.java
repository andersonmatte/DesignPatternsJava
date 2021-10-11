package visitor;

import org.junit.Test;
import visitor.control.AtualizadorSalario;
import visitor.entity.Departamento;
import visitor.entity.Funcionario;
import visitor.entity.Gerente;
import visitor.entity.Programador;
import visitor.interfaces.AtualizadorFuncionario;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class AtualizadorSalarioTest {

    @Test
    public void testaAtualizadorSalario() {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        Departamento departamento = new Departamento("Desenvolvimento de Software");
        Gerente gerente = new Gerente("Cassio Santos ", 15000D, 1234);
        Programador programador = new Programador("Anderson Matte ", 10000D, "Java");
        departamento.getFuncionarios().add(gerente);
        departamento.getFuncionarios().add(programador);
        departamentos.add(departamento);

        Departamento departamento2 = new Departamento("Desenvolvimento de Software");
        Gerente gerente2 = new Gerente("Jonas Costa ", 18000D, 1235);
        Programador programador2 = new Programador("Marcos Bahuer ", 2000D, "PHP");
        departamento2.getFuncionarios().add(gerente2);
        departamento2.getFuncionarios().add(programador2);
        departamentos.add(departamento2);

        AtualizadorFuncionario atualizadorFuncionario = new AtualizadorSalario();

        for (Departamento d : departamentos) {
            d.aceita(atualizadorFuncionario);
        }

        for (Departamento dd : departamentos) {
            for (Funcionario funcionario : dd.getFuncionarios()) {
                System.out.println("Nome: " + funcionario.getNome() + "- Salário : " + funcionario.getSalario());
            }
        }

    }

}
