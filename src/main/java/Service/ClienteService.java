package Service;

import Domain.Cliente;

import java.io.IOException;
import java.util.List;

public interface ClienteService {

     void create(Cliente cliente);

     public List<Cliente> listarTodos() throws IOException;

     Cliente buscar(String cpf);

}
