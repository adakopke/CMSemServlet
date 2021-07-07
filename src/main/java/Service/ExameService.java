package Service;

import Domain.Exame;

public interface ExameService {


    void create(Exame exame);

    void listar();

    Exame buscar(String codexame);

}
