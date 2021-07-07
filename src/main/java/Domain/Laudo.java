package Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Laudo {

    //TODO Discutir porque deveria usar composicao nesta classe
    //private Cliente cliente;
    //private Exame exame;
    private String cpf;
    private String codigoExame;
    private String resultado;
    private String data;


}
