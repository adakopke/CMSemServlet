package Service;

import DAO.ClienteDao;
import Domain.Cliente;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    @Inject
    public ClienteDao clienteDao;


    @Override
    public void create(Cliente cliente) {
        clienteDao.gravar(cliente);
    }


    public List<Cliente> listarTodos() throws IOException {
        return clienteDao.getAll();
    }

    @Override
    public Cliente buscar(String cpf) {
        return clienteDao.buscar(cpf);

    }
}
