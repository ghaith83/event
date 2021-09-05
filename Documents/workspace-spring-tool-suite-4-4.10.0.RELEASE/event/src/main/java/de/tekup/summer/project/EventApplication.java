package de.tekup.summer.project;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import de.tekup.summer.project.model.reservation;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.ReservationERepository;
import de.tekup.summer.project.repository.SalleRepository;

@SpringBootApplication
public class EventApplication   implements CommandLineRunner{
	@Autowired
	private SalleRepository reposale;
	@Autowired
	private ReservationERepository respres;
	
    

	
	
	 
	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	
	@Override
	public void run(String... args)  {
		// TODO Auto-generated method stub
	    
		salle salle1  =reposale.save(new salle("ZITOUNA","TUNIS","TUNIS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy17xSPnd_28M1PjohadjgRF-evNwUmo8jkA&usqp=CAU",200,350));
		salle salle2  =reposale.save(new salle("LA PERLE BLANCHE","MANOUBA","sidi hatab","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpRsgVcx_M6D_1LARppvqdv7SBnM0Z2qxPFA&usqp=CAU",220,650));
		salle salle3  =reposale.save(new salle("PRESTIJE","TUNIS","TUNIS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeTpLSC8b1-L-Uuz4qXy4i3ZCWeq_huSxIsA&usqp=CAU",230,340));
		salle salle4  =reposale.save(new salle("LOVE NIGTH","BEN AROUS","RADES","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjHQDr4J261Pxofc2FNquFRh-xooytKr5KgA&usqp=CAU",190,260));
		
	}
}
