package com.api.crowdlending.auth;

//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfiguration {
//    @Autowired
//    private CrowdlendingUserDetailsService userDetailsService;
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(encoder());
//        return provider;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors();
//        http.headers().frameOptions().disable();
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }

}
