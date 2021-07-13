package Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Laudo {


    private Cliente cliente;
    private Exame exame;
    private String resultado;
    private String comentarios;
    private LocalDate data;


}
