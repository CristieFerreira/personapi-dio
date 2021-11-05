package com.project.personapi.mapper;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.entities.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    //serve para retornar uma instancia do proprio personMapper
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    // instrui o mapstruct que ele irá receber uma data contendo dia, mês e ano e fazer a conversão para entidade
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    Person toModel(PersonDTO personDTO);
    //faz a converção de Person para PersonDTO

    PersonDTO toDTO(Person person);

}