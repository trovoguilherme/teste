package br.com.guilherme.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private double altura;

}
