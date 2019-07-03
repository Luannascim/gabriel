package mefood.cliente;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotNull
    private String nome;

    @NotNull
    private String endereco;

    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

}
