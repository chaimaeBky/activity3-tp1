package net.elbakay.hospital;

import net.elbakay.hospital.entities.Patient;
import net.elbakay.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner /* executer automatiquement au demarage */ {
@Autowired // injection des dep
private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(Patient.builder()
                .nom("ahmed")
                .dateNaissance(new Date())
                .score(56)
                .malade(true)
                .build());
        patientRepository.save(Patient.builder()
                .nom("yassine")
                .dateNaissance(new Date())
                .score(30)
                .malade(true)
                .build());


    }

}

