package io.helioanacronista.CrudCliente.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "TB_CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 80, message = "O nome precisa ter entre 3 a 8 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(min = 11, message = "Descrição miníma de 11 caracteres")
    @NotBlank(message = "Campo requerido")
    private String cpf;


    @Positive(message = "O preço deve ser positivo")
    private Double income;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull(message = "Campo requerido")
    private Integer children;
}
