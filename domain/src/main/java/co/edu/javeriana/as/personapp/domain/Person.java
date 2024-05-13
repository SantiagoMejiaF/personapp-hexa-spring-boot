package co.edu.javeriana.as.personapp.domain;

import java.util.List;

import co.edu.javeriana.as.personapp.domain.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

	@NonNull
	private Integer identification;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private GenderEnum gender;

	private Integer age;

	@ToString.Exclude

	private List<Phone> phoneNumbers;

	@ToString.Exclude
	private List<Study> studies;

	public Boolean isValidAge() {
		return this.age >= 0;
	}
}
