package cz.vsb.vea.cz.vsb.vea.lab02v2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void initGlobal(AuthenticationManagerBuilder builder) throws Exception {

		// Simple hardcoded example
		builder.inMemoryAuthentication().withUser("tom").password("{noop}tom").roles("USER", "EDITOR");
		builder.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
		builder.authenticationProvider(new AuthenticationProvider() {

			@Override
			public boolean supports(Class<?> authentication) {
				return authentication.equals(UsernamePasswordAuthenticationToken.class);
			}

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String name = authentication.getName();
				String password = authentication.getCredentials().toString();
				if (name.startsWith("a") && password.startsWith("b")) {
					List<GrantedAuthority> grantedAuths = new ArrayList<>();
					grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
					Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
					return auth;
				}
				return null;
			}
		});
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/person/**").hasRole("EDITOR")
				.antMatchers("/**").authenticated().and()
				.formLogin().permitAll().and().logout().permitAll().invalidateHttpSession(true)
				.logoutSuccessUrl("/login?logout").permitAll().and().exceptionHandling().accessDeniedPage("/403");
	}
}
