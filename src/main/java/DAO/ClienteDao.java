package DAO;

import Domain.Cliente;

import java.io.IOException;
import java.util.List;

public interface ClienteDao {
    void gravar(Cliente cliente);

    Cliente buscar(String cpf);

    public List<Cliente> getAll() throws IOException;
}
