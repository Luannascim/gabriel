package mefood.produto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;

@Data
@Entity
public class Produto {

    @Id
    @Column (name = "idproduto")
    private Long id;

    @NotNull
    private String nome;

    private String descricao;

    private DecimalFormat preco;
}
