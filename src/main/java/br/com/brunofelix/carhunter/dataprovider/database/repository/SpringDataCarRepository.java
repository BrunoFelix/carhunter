package br.com.brunofelix.carhunter.dataprovider.database.repository;

import br.com.brunofelix.carhunter.dataprovider.database.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SpringDataCarRepository extends JpaRepository<CarEntity, String> {
    Long countByDtCreateGreaterThanEqual(LocalDateTime date);
}
