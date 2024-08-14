package com.zegel.devices.repositorio;

import com.zegel.devices.entidades.seguridad.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorio extends CrudRepository<User, Long> {
    User findByUsername(String username);
}