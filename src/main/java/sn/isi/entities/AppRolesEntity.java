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

public class AppRolesEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Column(unique = true,nullable = false,length=100)
     private String nom;
     @ManyToMany(mappedBy ="appRoleEntities")
     private List<AppUserEntity> appUserEntity;

}
