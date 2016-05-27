package br.com.spring.agenda.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.spring.agenda.models.Contato;

public class ContatoValidation implements Validator {

	public void valida(Contato contato, Errors errors) {

	}

	// indicando que o Contato será validado pelo ContatoValidation
	@Override
	public boolean supports(Class<?> clazz) {
		return Contato.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "numero", "field.required");
		// p/ tipos primitivos:
		// Contato contato = (Contato) target;
		// if (i <= 0) {
		// errors.rejectValue("campoReferenteAoInteiro", "field.required");
		// }
	}

}
