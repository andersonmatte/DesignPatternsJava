package objectPool.pool;

import objectPool.entity.Aluno;
import objectPool.interfaces.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class AlunoPool implements Pool<Aluno> {

    private List<Aluno> alunos;

    public AlunoPool() {
        this.alunos = new ArrayList<Aluno>();
        this.alunos.add(new Aluno("Anderson Matte"));
        this.alunos.add(new Aluno("Alicia Mendes"));
        this.alunos.add(new Aluno("Juliana Chaves"));
    }

    @Override
    public Aluno acquire() {
        if (!this.alunos.isEmpty()) {
            return this.alunos.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public void release(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
