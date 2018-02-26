package com.edsd.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.edsd.repository.UsersRepository;
import com.edsd.service.CustomUserDetailsService;

import jersey.repackaged.com.google.common.collect.ImmutableList;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	

	
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	//csrf() .ignoringAntMatchers("/nocsrf","/ignore/startswith/**")
    	http.cors();
        http.csrf().disable();
        
        http.httpBasic().and()
        		.authorizeRequests()    
//        		.antMatchers( "/**").permitAll()
//        		.antMatchers("/**").permitAll()
//        		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//        		.antMatchers(HttpMethod.GET, "/**").permitAll()
//        	    .antMatchers(HttpMethod.POST, "/**").permitAll()
                .antMatchers("api/admin/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.defaultSuccessUrl("/api/home")
            	.failureUrl("/api/loginFailure")
                .permitAll(true)
                .and()
                .logout();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }
    
    @Bean
	CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedMethod("*");
		//ImmutableList.of("HEAD","GET", "POST", "PUT", "DELETE", "PATCH"));
//		configuration.setAllowCredentials(true);
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:8000", "https://www.getpostman.com"));
 //       configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedOrigin("*");
//        configuration.addAllowedOrigin("**/getpostman/**");
		configuration.addAllowedHeader("*");
//		configuration.setMaxAge(new Long(3600));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
//		source.registerCorsConfiguration("/login", configuration);
//		source.registerCorsConfiguration("/login/**", configuration);
//		source.registerCorsConfiguration("/logout", configuration);
//		source.registerCorsConfiguration("/api/**", configuration);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(1); 
		return source;
	}
}
