package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.AppRoles;
import sn.isi.dto.AppUser;
import sn.isi.entities.AppRolesEntity;
import sn.isi.entities.AppUserEntity;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(AppRoles appRoles);

}
