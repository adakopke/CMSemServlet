package Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exame {
    private String codigo;
    private String nome;
    private String unidade;
    private String valorRefMin;
    private String valorRefMax;

}
