package objectPool;

import objectPool.entity.Aluno;
import objectPool.interfaces.Pool;
import objectPool.pool.AlunoPool;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class AlunoPoolTest {

    @Test
    public void testarAlunoPool() {
        Pool<Aluno> alunoPool = new AlunoPool();
        Aluno aluno = alunoPool.acquire();
        while (aluno != null) {
            System.out.println(aluno.getNome());
            aluno = alunoPool.acquire();
        }
    }

}
