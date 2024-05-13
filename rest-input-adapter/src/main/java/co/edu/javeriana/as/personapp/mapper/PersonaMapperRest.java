package co.edu.javeriana.as.personapp.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.enums.GenderEnum;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.model.response.PersonaResponse;

@Mapper
public class PersonaMapperRest {
	
	public PersonaResponse fromDomainToAdapterRestMaria(Person person) {
		return fromDomainToAdapterRest(person, "MariaDB");
	}
	public PersonaResponse fromDomainToAdapterRestMongo(Person person) {
		return fromDomainToAdapterRest(person, "MongoDB");
	}
	
	public PersonaResponse fromDomainToAdapterRest(Person person, String database) {
		return new PersonaResponse(
				person.getIdentification()+"", 
				person.getFirstName(), 
				person.getLastName(), 
				person.getAge()+"", 
				person.getGender().toString(), 
				database,
				"OK");
	}

	public Person fromAdapterToDomain(PersonaRequest request) {
		Person person = new Person();
		if (request.getSex().equals("M")) {
			person = new Person(Integer.parseInt(request.getDni()), request.getFirstName(), request.getLastName(),
					GenderEnum.MALE);
		} else if (request.getSex().equals("F")) {
			person = new Person(Integer.parseInt(request.getDni()), request.getFirstName(), request.getLastName(),
					GenderEnum.FEMALE);
		} else {
			person = new Person(Integer.parseInt(request.getDni()), request.getFirstName(), request.getLastName(),
					GenderEnum.OTHER);
		}
		if (request.getAge() != null) {
			person.setAge(Integer.parseInt(request.getAge()));
		}
		return person;
	}
}
