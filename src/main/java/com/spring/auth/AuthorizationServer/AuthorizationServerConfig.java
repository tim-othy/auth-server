package com.spring.auth.AuthorizationServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Value("${user.oauth.clientId}")
  private String clientId;
  @Value("${user.oauth.clientSecret}")
  private String clientSecret;
  @Value("${user.oauth.redirectUris}")
  private String redirectUris;

  private final PasswordEncoder passwordEncoder;

  public AuthorizationServerConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()")
      .checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
      .withClient(clientId)
      .secret(passwordEncoder.encode(clientSecret))
      .authorizedGrantTypes("authorization_code")
      .scopes("user_info")
      .autoApprove(true)
      .redirectUris(redirectUris);
  }
}
