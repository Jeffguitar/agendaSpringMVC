package br.com.spring.agenda.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//avisando que o Spring, a partir de agora, vai gerenciar as requisições de "/" em diante.
//Classe Spring que inicializa o seu próprio servlet (alternativa ao XML)

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// Mapeando as classes (controller)
	// classe que mapeia qual/quais controller vamos utilizar
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppWebConfiguration.class, JPAConfiguration.class };
	}

	// Mapeamento do servlet
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// Definindo o filtro default de Encoding UTF-8
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] { encodingFilter };
	}

}
