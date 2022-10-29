package com.example.googleform.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.client.registration.github.client-id}") String clientId;
    @Value("${spring.security.oauth2.client.registration.github.client-id}") String clientSecret;

    //@Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(getGithubClientReg());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/test-env/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
                //.clientRegistrationRepository(clientRegistrationRepository());
    }

//    @Bean
//    public OAuth2AuthorizedClientService authorizedClientService() {
//
//        return new InMemoryOAuth2AuthorizedClientService(
//                clientRegistrationRepository());
//    }

    private ClientRegistration getGithubClientReg(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }
}
