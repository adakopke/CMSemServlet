package View;

import Domain.Exame;
import Domain.Laudo;
import Service.ClienteService;
import Service.ExameService;
import Service.LaudoService;

import javax.inject.Inject;
import java.util.Scanner;

public class LaudoViewImpl implements LaudoView {


    @Inject
    public ClienteService clienteService;

    @Inject
    public ExameService exameService;

    @Inject
    public LaudoService laudoService;


    @Override
    public void create(Scanner sc) {
        Laudo laudo = new Laudo();

        System.out.println("Para qual cliente deseja cadastrar um laudo?");
        clienteService.listar();
        System.out.println("\nDigite o CPF do cliente desejado:");
        laudo.setCpf(sc.next());
        exameService.listar();
        System.out.println("Para qual exame deseja registrar o laudo?");
        System.out.println("Informe o código do exame");
        laudo.setCodigoExame(sc.next());
        System.out.println("Informe o resultado do exame");
        laudo.setResultado(sc.next());
        System.out.println("Informe a data de realização do exame");
        laudo.setData(sc.next());
        laudoService.create(laudo);
        System.out.println("Laudo cadastrado com sucesso");
    }

    @Override
    public void consultar(Scanner sc) {

        System.out.println("Informe seu cpf:");
        String cpf = sc.next();

        //TODO retirar essa tosqueira de um if dentro do outro
        if (cpf.equalsIgnoreCase(clienteService.buscar(cpf).getCpf())) {

            exameService.listar();
            System.out.println("Informe o código do exame que deseja consultar");
            String codexame = sc.next();

            if (codexame.equalsIgnoreCase(exameService.buscar(codexame).getCodigo())) {

                System.out.println("Registros do exame: " + exameService.buscar(codexame).getNome());
                System.out.println("Dados de referência do exame:\n" +
                                   "Valor mínimo desejado:" + exameService.buscar(codexame).getValorRefMin() + "\n" +
                                   "Valor máximo desejado:" + exameService.buscar(codexame).getValorRefMax() + "\n"
                );
                laudoService.resultado(cpf, codexame);

            }



        } else  {
            System.out.println("Cpf não encontrado");
            //TODO trocar isso depois
            System.exit(0);
        }



    }

}

