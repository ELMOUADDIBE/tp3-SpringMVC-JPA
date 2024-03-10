package ma.enset.tp3;

import ma.enset.tp3.entities.Patient;
import ma.enset.tp3.repository.PatientRepository;
import ma.enset.tp3.service.IHospital;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp3SpringMvcJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp3SpringMvcJpaApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(IHospital iHospital, PatientRepository patientRepository){
		return args -> {
			Patient p1 = new Patient();
			p1.setName("Hassan");
			p1.setDateNaissance(new Date());
			p1.setMalade(true);
			p1.setScore(2300);
			iHospital.savePatient(p1);

			Patient p2 = new Patient(-1,"Youssef",new Date(), false, 500,null);

			Patient p3 = Patient.builder()
					.name("Imane")
					.dateNaissance(new Date())
					.malade(false)
					.score(100)
					.build();
		};
	}
}
