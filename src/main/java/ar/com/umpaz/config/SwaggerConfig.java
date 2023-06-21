package ar.com.umpaz.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {
	
	 private final String appApiName;
	 private final String appApiVersion;

	 public SwaggerConfig(
	        @Value("${app.api.name}") String appApiName ,
	        @Value("${app.api.version}") String appApiVersion) {
	      this.appApiName = appApiName;
	      this.appApiVersion = appApiVersion;
	    }

	    @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
//	                .addSecurityItem(new SecurityRequirement().addList("Authorization"))
//	                .components(new Components()
//	                        .addSecuritySchemes("Authorization", new SecurityScheme()
//	                                .type(SecurityScheme.Type.APIKEY)
//	                                .in(SecurityScheme.In.HEADER)
//	                                .name("X-API-KEY")
//	                        )
//	                    )
	                .info(new Info().title(appApiName).version(appApiVersion));

	    }
}