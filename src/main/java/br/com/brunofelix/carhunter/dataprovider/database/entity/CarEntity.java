package br.com.brunofelix.carhunter.dataprovider.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "CAR")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private String id;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "KM", nullable = false)
    private Integer km;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "MODEL_YEAR", nullable = false)
    private Integer modelYear;

    @Column(name = "TRANSMISSION", nullable = false)
    private String transmission;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "DT_CREATE", updatable = false)
    @CreationTimestamp
    private LocalDateTime dtCreate;

    @Column(name = "DT_UPDATE")
    @UpdateTimestamp
    private LocalDateTime dtUpdate;
}
