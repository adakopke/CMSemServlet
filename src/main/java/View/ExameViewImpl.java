package View;

import Domain.Exame;
import Domain.Cliente;
import Domain.SexoEnum;
import Service.ExameService;

import javax.inject.Inject;
import java.util.Scanner;

public class ExameViewImpl implements ExameView {

    @Inject
    public ExameService exameService;

    @Override
    public void create(Scanner sc) {

            Exame exame = new Exame();
            System.out.println("Informe o código do exame");
            exame.setCodigo(sc.next());
            System.out.println("Informe o nome do exame");
            exame.setNome(sc.next());
            System.out.println("Informe a unidade de medida do exame");
            exame.setUnidade(sc.next());
            System.out.println("Informe valor mínimo de referência do exame");
            exame.setValorRefMin(sc.next());
            System.out.println("Informe valor máximo de referência do exame");
            exame.setValorRefMax(sc.next());
            exameService.create(exame);
            System.out.println("Exame cadastrado com sucesso");
        }

    }

