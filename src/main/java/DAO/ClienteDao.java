package DAO;

import Domain.Cliente;

public interface ClienteDao {
    void gravar(Cliente cliente);
    void listar();

    Cliente buscar(String cpf);

}
