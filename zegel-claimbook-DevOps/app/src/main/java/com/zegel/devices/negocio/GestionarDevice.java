package com.zegel.devices.negocio;

import com.zegel.devices.entidades.Device;
import com.zegel.devices.repositorio.DeviceRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionarDevice {
    @Autowired
    private DeviceRepositorio deviceRepositorio;
    public Device grabar(Device device){
        return deviceRepositorio.save(device);
    }
    public List<Device> obtenerDevices(){
        return (List<Device>) deviceRepositorio.findAll();
    }
    public Device actualizar(Device device){
        Device c = deviceRepositorio.findById(device.getId()).get();
        if(c!= null){
            return deviceRepositorio.save(device);
        }else {return null;}
    }
    public Device borrarDevice(Long id){
        Device c = deviceRepositorio.findById(id).get();
        if(c!= null){
            deviceRepositorio.delete(c);
        }else {return null;}
        return c;
    }

}
