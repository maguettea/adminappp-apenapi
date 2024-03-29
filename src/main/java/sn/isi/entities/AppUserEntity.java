package sn.isi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//le data gere les getters et les setters
@Data
//les constructeur sans arguments
@NoArgsConstructor
//les constructeur avec arguments
@AllArgsConstructor
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length=150)
    private String nom;
    @Column(nullable = false,length=200)
    private String prenom;
    @Column(nullable = false,length=200)
    private String email;
    @Column(nullable = false,length=200)
    private String password;
    private int etat;
    @ManyToMany
    private List<AppRolesEntity> appRoleEntities;
    @OneToMany(mappedBy ="appUserEntity")
    private List <ProduitEntity> produitEntities;
}
