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
public class AppUser {

    private int id;
    @NotNull(message = "le nom ne doit pas etre null ")
    private String nom;
    @NotNull(message = "le prenom ne doit pas etre null ")
    private String prenom;
    @NotNull (message = "l'email ne doit pas etre null ")
    private String email;
    @NotNull (message = "le mot de pass ne doit pas etre null ")
    private String password;
    @NotNull
    private int etat;

}
