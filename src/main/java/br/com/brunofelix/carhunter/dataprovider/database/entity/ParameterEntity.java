package br.com.brunofelix.carhunter.dataprovider.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARAMETER")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParameterEntity {

    @Id
    @Column(name = "KEY", nullable = false, unique = true)
    private String key;

    @Column(name = "VALUE", nullable = false)
    private String value;
}
