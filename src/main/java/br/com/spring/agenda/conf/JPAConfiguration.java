package br.com.spring.agenda.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Habilitando a transação pelo Spring
@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		// Adaptador do hibernate
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		factoryBean.setJpaVendorAdapter(vendorAdapter);

		// Gerenciador de conexões
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// usuário de conexão ao banco
		dataSource.setUsername("root");
		// Senha para conexão com o banco
		dataSource.setPassword("JeffersonLima10");
		// configura a url de conexão com o banco
		dataSource.setUrl("jdbc:mysql://localhost:3306/agendaSpring");
		// configura o driver de conexão com o banco de dados
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		factoryBean.setDataSource(dataSource);

		Properties props = new Properties();
		// Configuração do dialeto usado para criação dos comandos SQL
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		// serve para ver o SQL que o Hibernate está gerando através do Console
		props.setProperty("hibernate.show_sql", "true");
		// faz com que o Hibernate crie as tabelas no banco caso estas não
		// existam, no caso como configuramos para “update” ele tentará corrigir
		// a tabela do banco para ficar idêntica ao definido nos mapeamentos.
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setJpaProperties(props);

		factoryBean.setPackagesToScan("br.com.spring.agenda.models");
		return factoryBean;
	}

	// Criador da transação
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
