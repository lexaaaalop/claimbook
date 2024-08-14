package com.zegel.devices.rest;

import com.zegel.devices.entidades.Device;
import com.zegel.devices.entidades.seguridad.User;
import com.zegel.devices.negocio.GestionarDevice;
import com.zegel.devices.negocio.UserNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/zegel")
public class deviceRest {
    @Autowired
    private GestionarDevice gestionarDevice;
    @Autowired
    private UserNegocio userNegocio;

    @PostMapping("/device")
    public Device grabar(@RequestBody Device device){
        return gestionarDevice.grabar(device);
    }

    @GetMapping("/devices")
    public List<Device> obtenerDevices(){
        try{
            return gestionarDevice.obtenerDevices();
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }
    @PutMapping("/actualizar")
    public Device actualizar(@RequestBody Device device){
        try{
            return gestionarDevice.actualizar(device);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar");
        }
    }
    @DeleteMapping("/device/{id}")
    public Device borrarDevice(@PathVariable(value = "id") Long id){
        return gestionarDevice.borrarDevice(id);
    }


// User

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User newUser = userNegocio.grabar(user);
        return ResponseEntity.ok("User created successfully with id: " + newUser.getId());
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userNegocio.obtenerUsuarios();
        return ResponseEntity.ok(users);
    }
}
