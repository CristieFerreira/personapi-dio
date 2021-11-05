package com.project.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.br.CPF;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    //os DTO são responsáveis por receberem todos os dados de entrada, e esses dados
    //iram ser mapeados no obj DTO
    // consegue fazer a validação na própria camada de controle, no momento que é executado

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100) //limita o tamanho
    private String lastName;

    @NotEmpty
    @CPF //formata o cpf no padrão brasileiro, se tiver numeros a mais e caracteres errados, ele irá barrar
    private String cpf;

    @NotNull
    private String birthDate;

    @Valid // esses dados precisam ser validados
    @NotEmpty // nunca pode ser vazio
    private List<PhoneDTO> phones;
}

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-validation</artifactId>
//</dependency>