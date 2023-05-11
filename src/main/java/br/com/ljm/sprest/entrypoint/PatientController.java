package br.com.ljm.sprest.entrypoint;

import br.com.ljm.sprest.component.MessageProducer;
import br.com.ljm.sprest.entities.Patient;
import br.com.ljm.sprest.repositories.PatientRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@Tag(name="Patients", description="Endpoint for manager data of patients.")
@Slf4j
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MessageProducer messageProducer;

    @PostMapping()
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {

        try {
            Patient _patient = patientRepository.save(new Patient(patient.getName(), patient.getDocument(), patient.getHeartRate()));
            messageProducer.sendMessage(patient.toString());

            log.info("Save patient with successful!");
            return new ResponseEntity<>(_patient, HttpStatus.CREATED);

        } catch (Exception e) {

            log.error(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping()
    public ResponseEntity<?> getPatients () {

        try {
            List<Patient> patients = patientRepository.findAll();
            log.error("Get patients with successful!");

            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {

            log.error(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long id) {

        try {
            patientRepository.findById(id).ifPresent(patientRepository::delete);
            log.error("Delete patient with sucessecful!");

            return new ResponseEntity<>(null, HttpStatus.OK);

        }  catch (Exception e) {

            log.error(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("exam")
    public ResponseEntity<?> processExamPatient() {

        try {

            return new ResponseEntity<>(null, HttpStatus.OK);

        }  catch (Exception e) {

            log.error(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}