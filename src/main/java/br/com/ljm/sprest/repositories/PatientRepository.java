package br.com.ljm.sprest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ljm.sprest.entities.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByName(String name);

    List<Patient> findByDocument(String document);
}
