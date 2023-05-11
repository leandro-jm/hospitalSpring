package br.com.ljm.sprest.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "document")
	private String document;
	@Column(name = "heartRate")
	private Integer heartRate;

	public Patient(String name, String document, Integer heartRate) {
		this.name = name;
		this.document = document;
		this.heartRate = heartRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Patient patient = (Patient) o;
		return Objects.equals(id, patient.id) && Objects.equals(name, patient.name) && Objects.equals(document, patient.document) && Objects.equals(heartRate, patient.heartRate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, document, heartRate);
	}

	@Override
	public String toString() {
		return "Patient{" +
				"id=" + id +
				", name='" + name + '\'' +
				", document='" + document + '\'' +
				", heartRate=" + heartRate +
				'}';
	}
}
