package com.example.Simone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GarbageDTO {
    private int id;
    private String nome;
    private int eta;
    private String fattoSulProprioGatto;
}
