package ir.maktab.service.service;

import ir.maktab.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceServiceImplTest {

    ServiceService serviceService=new ServiceServiceImpl();

    @Test
    void save(){
        Service service=Service.builder()
                        .title("manzel")
                .build();
        serviceService.save(service);
        Assertions.assertEquals(service.getTitle(),serviceService.findById(service.getId()).getTitle());
    }

}