package com.cjava.sales.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @CurrentTimestamp
    private LocalDateTime date;
    private Double amount;
    @Transient
    private Integer port;

}
