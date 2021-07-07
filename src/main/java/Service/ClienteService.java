package Service;

import Domain.Cliente;

public interface ClienteService {

     void create(Cliente cliente);

     void listar();

     Cliente buscar(String cpf);

}
