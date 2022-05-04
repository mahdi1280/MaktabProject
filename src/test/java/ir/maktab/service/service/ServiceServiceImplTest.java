package ir.maktab.service.service;

import ir.maktab.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void findAll(){
        List<Service> all = serviceService.findAll();
        Assertions.assertEquals(all.size(),serviceService.findAll().size());
    }

}