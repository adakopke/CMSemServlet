package Service;

import DAO.LaudoDao;
import Domain.Laudo;

import javax.inject.Inject;

public class LaudoServiceImpl implements LaudoService {

    @Inject
    public LaudoDao laudoDao;


    @Override
    public void create(Laudo laudo) {
        laudoDao.create(laudo);


    }

    @Override
    public void resultado(String cpf, String codexame) {
         laudoDao.resultado(cpf, codexame);
    }
}
