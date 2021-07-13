package Domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {

    private String cpf;
    private String nome;
    private SexoEnum sexo;
    private LocalDate dataNascimento;

}
