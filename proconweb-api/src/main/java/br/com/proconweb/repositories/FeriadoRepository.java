package br.com.proconweb.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.proconweb.models.Feriado;

/**
 * 
 * @author Marlon F. Garcia
 *
 */
@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Integer> {

	Optional<Feriado> findOneByData(LocalDate data);

	Page<Feriado> findAllByDataAfter(LocalDate de, Pageable pageable);

}
