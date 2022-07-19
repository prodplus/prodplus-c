package br.com.proconweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.proconweb.models.Configuracao;

/**
 * 
 * @author Marlon F. Garcia
 *
 */
@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Integer> {

}
