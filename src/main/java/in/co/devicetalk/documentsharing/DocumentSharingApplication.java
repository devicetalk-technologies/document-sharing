package in.co.devicetalk.documentsharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DocumentSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentSharingApplication.class, args);
	}

}
