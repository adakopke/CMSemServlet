package DAO;

import Domain.Cliente;
import Domain.SexoEnum;

import java.io.*;

public class ClienteDaoImpl implements ClienteDao {


    @Override
    public void gravar(Cliente cliente) {

        try (FileWriter fw = new FileWriter("CLIENTES.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf( cliente.getCpf() + "," + cliente.getNome() + "," + cliente.getSexo() + "\n");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    @Override
    public void listar() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("CLIENTES.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {

                String[] cols = linha.split(",");
                System.out.println("CPF_CLIENTE: " + cols[0] + " | NOME_CLIENTE: " + cols[1]) ;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }

    @Override
    public Cliente buscar(String cpf) {
        Cliente cliente = new Cliente();
        try {

            BufferedReader br = new BufferedReader(new FileReader("CLIENTES.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {

                String[] cols = linha.split(",");

                if (cols[0].equalsIgnoreCase(cpf)) {

                    cliente.setCpf(cols[0]);
                    cliente.setNome(cols[1]);
                    cliente.setSexo(SexoEnum.valueOf(cols[2]));

            }
        }

    } catch (IOException e) {
            e.printStackTrace();

        }


        return cliente;
    }


}

