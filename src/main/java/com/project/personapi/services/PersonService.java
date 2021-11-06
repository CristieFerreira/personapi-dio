package com.project.personapi.services;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.dto.response.MessageResponseDTO;
import com.project.personapi.entities.Person;
import com.project.personapi.exeption.PersonNotFoundException;
import com.project.personapi.mapper.PersonMapper;
import com.project.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PersonDTO> listAll() {
        List<Person> allpeople = personRepository.findAll();
        //precisa converter a lista allpeople em personDTO
        return allpeople.stream() //stream serve para a manipulção e transformação de coleções
                .map(personMapper::toDTO)//converte os dados
                .collect(Collectors.toList()); // manda para uma lista
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person =  verifyIfExists(id);
        //        .orElseThrow(() -> new PersonNotFoundException(id)); // uma maneira diferente de se fazer o código descrito abaixo
        //Optional<Person> optionalPerson = personRepository.findById(id);
        //if (optionalPerson.isEmpty()) {
        //     throw new PersonNotFoundException(id);
        //}
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);

    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
