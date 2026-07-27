package br.com.brunofelix.carhunter.dataprovider.database.repository;

import br.com.brunofelix.carhunter.dataprovider.database.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataParameterRepository extends JpaRepository<ParameterEntity, String> {
}
