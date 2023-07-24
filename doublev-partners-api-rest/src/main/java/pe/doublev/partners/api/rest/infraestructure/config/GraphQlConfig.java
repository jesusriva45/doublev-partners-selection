package pe.doublev.partners.api.rest.infraestructure.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQlConfig {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date);
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurerLong() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurerObject() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Object);
    }

}
