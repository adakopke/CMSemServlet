package DAO;

import Domain.Cliente;
import Domain.SexoEnum;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClienteDaoImpl implements ClienteDao {


    @Override
    public void gravar(Cliente cliente) {

        try (FileWriter fw = new FileWriter("CLIENTES.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf(cliente.getCpf() + ";" + cliente.getNome() + ";" + cliente.getSexo() + ";" + cliente.getDataNascimento() + "\n");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    @Override
    public Cliente buscar(String cpf) {
        Cliente cliente = new Cliente();
        try {

            BufferedReader br = new BufferedReader(new FileReader("CLIENTES.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {

                String[] cols = linha.split(";");

                if (cols[0].equalsIgnoreCase(cpf)) {

                    cliente.setCpf(cols[0]);
                    cliente.setNome(cols[1]);
                    cliente.setSexo(SexoEnum.valueOf(cols[2]));
                    cliente.setDataNascimento(LocalDate.parse(cols[3]));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }


        return cliente;
    }

    @Override
    public List<Cliente> getAll() throws IOException {
        List<Cliente> clientes;
        try (BufferedReader br = new BufferedReader(new FileReader("CLIENTES.txt"))) {
            clientes = br.lines()
                    .filter(Objects::nonNull)
                    .filter(Predicate.not(String::isEmpty))
                    .map(this::convert)
                    .collect(Collectors.toList());
       }

        return clientes;
    }

    private Cliente convert(String linha) {
        StringTokenizer token = new StringTokenizer(linha, ";");
        Cliente cliente = new Cliente();
        //cliente.setIdentificador(token.nextToken());
        cliente.setCpf(token.nextToken());
        cliente.setNome(token.nextToken());
        cliente.setSexo(SexoEnum.valueOf(token.nextToken()));
        cliente.setDataNascimento(LocalDate.parse(token.nextToken()));
        return cliente;

    }
}

