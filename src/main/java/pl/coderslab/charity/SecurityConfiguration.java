package pl.coderslab.charity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.coderslab.charity.services.AuthenticationSuccessHandlerImpl;
import pl.coderslab.charity.services.user.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationSuccessHandler handler(){
        return new AuthenticationSuccessHandlerImpl();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Available for everyone
        http.authorizeRequests()
                .antMatchers("/").permitAll();

        //Only logged users
        http.authorizeRequests()
                .antMatchers("/app", "/app/**")
                .authenticated()
                .and().formLogin().loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password").successHandler(handler())
                .and().logout().logoutSuccessUrl("/").deleteCookies("JSESSIONID");

        //Only logged admins
        http.authorizeRequests()
                .antMatchers("/admin", "/admin/**")
                .hasRole("ADMIN")
                .and().formLogin().loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password").successHandler(handler())
                .and().logout().logoutSuccessUrl("/").deleteCookies("JSESSIONID");
    }
}
