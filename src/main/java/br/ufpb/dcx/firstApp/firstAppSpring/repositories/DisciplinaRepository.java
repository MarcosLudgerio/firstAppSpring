package br.ufpb.dcx.firstApp.firstAppSpring.repositories;


import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DisciplinaRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Long>{
}
