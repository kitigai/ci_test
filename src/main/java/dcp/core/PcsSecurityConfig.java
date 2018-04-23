package dcp.core;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * PC# Member's Web セキュリティ設定クラス
 * @author tikK65339
 *
 */
@EnableWebSecurity
public class PcsSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// FIXME CSRF対策は一時的に無効にしています。
		http.csrf().disable();
	}

}
