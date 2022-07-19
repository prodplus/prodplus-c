package br.com.proconweb.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.proconweb.models.auxiliares.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Marlon F. Garcia
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Configuracao implements Serializable {

	private static final long serialVersionUID = -7351528300134347500L;
	@Id
	@JsonIgnore
	private Integer id;
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Turno> turnosSemana = new HashSet<>();
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Turno> turnosSabado = new HashSet<>();
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Turno> turnosDomingo = new HashSet<>();
	private boolean estruturaCompleta = false;
	private Double mediaIpcm = 0.0;

}
