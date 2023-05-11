package br.com.ljm.sprest;

import br.com.ljm.sprest.entities.Patient;
import br.com.ljm.sprest.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {

    @Autowired
    PatientRepository patientRepository;

    @Test
    void save() {

        Patient _patient = patientRepository.save(new Patient("Name Test", "045165656564", 123));
    }
}
