package sn.isi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


//le data gere les getters et les setters
@Data
//les constructeur sans arguments
@NoArgsConstructor
//les constructeur avec arguments
@AllArgsConstructor
public class Produit {
    private int id;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
    @NotNull
    private double qtStock;
}
