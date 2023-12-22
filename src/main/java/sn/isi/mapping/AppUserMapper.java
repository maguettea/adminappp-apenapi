package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.AppUser;
import sn.isi.entities.AppUserEntity;
@Mapper
public interface AppUserMapper {
    // tu passe en parametre à appUser et on va le transformé en AppUser
    AppUser toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser(AppUser appUser);


}
