package com.cjava.client.domain.dtos;

import lombok.*;

@Builder @Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

    private Long id;
    private String name;
    private Double salesAmount;

}
