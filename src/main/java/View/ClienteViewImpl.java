package View;

import Domain.Cliente;
import Domain.SexoEnum;
import Service.ClienteService;

import javax.inject.Inject;
import java.util.Scanner;

public class ClienteViewImpl implements ClienteView {

    @Inject
    public ClienteService clienteService;


    @Override
    public Cliente create(Scanner sc) {
        Cliente cliente = new Cliente();
        System.out.println("Informe o nome do cliente");
        sc.nextLine();
        cliente.setNome(sc.nextLine());
        System.out.println("Informe o cpf do cliente");
        cliente.setCpf(sc.next());
        int sexo;
         do {
             System.out.println("Informe o sexo do cliente:\n1 - Masculino\n2 - Feminino");
             sexo = sc.nextInt();
            if (sexo == 1) {
                cliente.setSexo(SexoEnum.MASCULINO);
            } else if (sexo == 2) {
                cliente.setSexo(SexoEnum.FEMININO);
            } else {
                sexo = 0;
                System.out.println("Digite uma opção válida");;
            }
        } while ((sexo == 0));

        clienteService.create(cliente);
        System.out.println("Cliente cadastrado com sucesso");

        return cliente;




    }
}
