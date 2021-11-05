package com.project.personapi.services;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.dto.response.MessageResponseDTO;
import com.project.personapi.entities.Person;
import com.project.personapi.mapper.PersonMapper;
import com.project.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder() //passa de uma forma encapsulada e faz o tratamento dos dados de entrada
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }
}
