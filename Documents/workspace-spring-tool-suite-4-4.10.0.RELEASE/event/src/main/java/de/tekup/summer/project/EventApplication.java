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

import de.tekup.summer.project.model.category;
import de.tekup.summer.project.model.reservation;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.CategoryRepository;
import de.tekup.summer.project.repository.ReservationERepository;
import de.tekup.summer.project.repository.SalleRepository;

@SpringBootApplication
public class EventApplication   implements CommandLineRunner{
	@Autowired
	private SalleRepository reposale;
	@Autowired
	private ReservationERepository respres;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    

	
	
	 
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
	    category sport= categoryRepository.save(new category("sport","https://i.pinimg.com/736x/e9/c6/79/e9c679ed87b200ae4fb89fe52dc6de01.jpg","nous ouffrons une category des salles des sports click sur la boutton pour voir plus de detailles "));
	    category catmariage=categoryRepository.save(new category("marriage","https://png.pngtree.com/element_origin_min_pic/16/07/09/155780a20633522.jpg","nous ouffrons une category des salles des fetes click sur la boutton pour voir plus de detailles "));
	    category catkids= categoryRepository.save(new category("enfants","https://media.istockphoto.com/vectors/group-of-children-putting-hands-together-on-white-background-vector-id1095196468?k=20&m=1095196468&s=612x612&w=0&h=_7F3lk0P-IYJnZ5Gex2xu3yX45Z0vv15n8f8nPmTG7Y=","nous ouffrons une category des salles des fetes click sur la boutton pour voir plus de detailles "));
	    category it=categoryRepository.save(new category("travailler","https://media.istockphoto.com/vectors/business-seminar-speakers-financial-and-financial-data-analysis-and-vector-id1166966512?k=20&m=1166966512&s=612x612&w=0&h=dzFtl6mR4Sxc69nB4v0y-pxABal1R9dzrfwccV8ruS0=","nous ouffrons une category des salles des fetes click sur la boutton pour voir plus de detailles "));
		salle salle1  =reposale.save(new salle("ZITOUNA","TUNIS","TUNIS","https://i0.wp.com/www.prestigemaison.com/wp-content/uploads/2011/09/Decor-de-mariage-en-plein-air.jpg?ssl=1",200,350,catmariage));
		salle salle2  =reposale.save(new salle("LA PERLE BLANCHE","MANOUBA","sidi hatab","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpRsgVcx_M6D_1LARppvqdv7SBnM0Z2qxPFA&usqp=CAU",220,650,catmariage));
		salle salle3  =reposale.save(new salle("PRESTIJE","TUNIS","TUNIS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeTpLSC8b1-L-Uuz4qXy4i3ZCWeq_huSxIsA&usqp=CAU",230,340,catmariage));
		salle salle4  =reposale.save(new salle("LOVE NIGTH","BEN AROUS","RADES","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjHQDr4J261Pxofc2FNquFRh-xooytKr5KgA&usqp=CAU",190,260,catmariage));
		salle salle5=reposale.save(new salle("KHOMSA","TUNIS","TUNIS","http://linstant-m.tn/dev/media/2381.png",12,300,sport));
		salle salle6=reposale.save(new salle("CALIFORNIA","ARIANA","GHAZELA","https://media.lesechos.com/api/v1/images/view/5fd484fa8fe56f3475588ba5/1280x720/061100075065-web-tete.jpg",100,650,sport));
		salle salle7=reposale.save(new salle("cinéma pathé","ariana","TUNIS","https://www.sortiraparis.com/images/80/73089/318483-la-salle-mome-la-salle-cinema-et-jeux-pour-les-enfants-11.jpg",120,750,catkids));
		salle salle8=reposale.save(new salle("KIDS ADOS","TUNIS","BARDO","https://image.made-in-china.com/45f3j00GoQakTPtvwbO/Kids-Plastic-Toy-Baby-Play-Yard-Safety-Plastic-Fence-Plastic-Playpen-Kids-Large-Baby-Playpen-Indoor-Playground.jpg",50,450,catkids));
		salle salle9=reposale.save(new salle("event center","ARIANA","GHAZELA","https://lh3.googleusercontent.com/proxy/qluVdOiYWsH_fzbLVL_D9KU3ZEHnCpx8TeWw8vBDrynLsJS5rUHRId2e4Q-o-YtkelxgXvKDMQwU8FgibzYB1zqq-zd7pPTeDVyUUxTUDbpVn2gARHvrBfPaQt0KI7JrsAyStbhUdtMU-d5SPUx1J1XnmCN02fWrHv2TaUnUnWvafGBiFY8byN6sz-hod0sPbi1eb53zABW5PI5-6g",100,650,it));
		salle salle10=reposale.save(new salle("center tunis","tunis","tunis","https://s3-eu-west-1.amazonaws.com/privateaser-media/etab_photos/5055/750x375/131237.jpg",300,850,it));
	}
}
