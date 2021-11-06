package com.project.personapi.service;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.dto.response.MessageResponseDTO;
import com.project.personapi.entities.Person;
import com.project.personapi.repositories.PersonRepository;
import com.project.personapi.services.PersonService;
import com.project.personapi.utils.PersonUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.project.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//injeta nessa classe/ test que ele rode o mockito
public class PersonServiceTest {

    @Mock //vai mockar ele e criar um objeto dublê
    private PersonRepository personRepository;

    @InjectMocks // vai injetar o objeto mock acima na classe personService
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
        //ele vai na classe para validar se o retorno deu certo

        MessageResponseDTO expectedSuccessMessage = expectedMethodResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);

    }

    private MessageResponseDTO expectedMethodResponse(Long Id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID" + Id)
                .build();
    }
}
