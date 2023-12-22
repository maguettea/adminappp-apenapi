package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.AppUserEntity;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
  //c comme ça qu'on récupére un user a partir de son email
    AppUserEntity findByEmail(String email);
}
