package sn.isi.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IAppUserRepository;
import sn.isi.dto.AppUser;
import sn.isi.entities.AppUserEntity;
import sn.isi.mapping.AppUserMapper;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppUserService {
    private IAppUserRepository appUserRepository;
    private AppUserMapper appUserMapper;

    public AppUserService(IAppUserRepository appUserRepository, AppUserMapper appUserMapper) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
    }

    @Transactional(readOnly = true)
    public List<AppUser> getAppUsers() {
        return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUser)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppUser getAppUser(int id) {
        return appUserMapper.toAppUser(appUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + id)));
    }

    @Transactional
    public AppUser createAppUser(AppUser appUser) {
        AppUserEntity appUserEntity = appUserMapper.fromAppUser(appUser);
        return appUserMapper.toAppUser(appUserRepository.save(appUserEntity));
    }

    @Transactional
    public AppUser updateAppUser(int id, AppUser appUser) {
        if (!appUserRepository.existsById(id)) {
            throw new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + id);
        }

        AppUserEntity updatedAppUserEntity = appUserMapper.fromAppUser(appUser);
        updatedAppUserEntity.setId(id);

        return appUserMapper.toAppUser(appUserRepository.save(updatedAppUserEntity));
    }


    @Transactional
    public void deleteAppUser(int id) {
        try {
            appUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException("Erreur lors de la suppression de l'utilisateur avec l'ID : " + id, HttpStatus.CONFLICT);
        }
    }
}
