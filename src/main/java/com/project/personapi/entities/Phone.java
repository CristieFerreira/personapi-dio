package com.project.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.project.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
//o lombok adiciona um getter e setter para cada variavel
@Builder
//vai dar um padrão de projetos para fazer a construção de objetos de uma forma mais
@AllArgsConstructor
@NoArgsConstructor
//adiciona os cosntrutores
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //faz com que o banco de dados gere o id automaticamente
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // faz com que seja obrigatório que esse dado seja inserido
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
