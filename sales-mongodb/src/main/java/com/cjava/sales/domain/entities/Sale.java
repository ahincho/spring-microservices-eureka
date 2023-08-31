package com.cjava.sales.domain.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

import java.time.LocalDateTime;

@Document(collection = "sales")
@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    private Long id;
    private Long userId;
    @CreatedDate
    private LocalDateTime date;
    private Double amount;

}
