package Service;

import DAO.ClienteDao;
import Domain.Cliente;

import javax.inject.Inject;

public class ClienteServiceImpl implements ClienteService {

    @Inject
    public ClienteDao clienteDao;


    @Override
    public void create(Cliente cliente) {
        clienteDao.gravar(cliente);
    }

    @Override
    public void listar() {
        clienteDao.listar();
    }

    @Override
    public Cliente buscar(String cpf) {
        return clienteDao.buscar(cpf);

    }
}
