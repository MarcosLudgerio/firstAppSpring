package br.ufpb.dcx.firstApp.firstAppSpring.services;

import br.ufpb.dcx.firstApp.firstAppSpring.model.Disciplina;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    MockService serviceDiscplinaMock = new MockService();


    public Disciplina insertNewDiscplina(Disciplina disciplina){
        Disciplina disciplina1 = serviceDiscplinaMock.insert(disciplina);
        return disciplina1;
    }

}
