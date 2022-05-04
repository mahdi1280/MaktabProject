package ir.maktab.service.underservice;

import ir.maktab.model.Service;
import ir.maktab.model.UnderService;
import ir.maktab.service.service.ServiceService;
import ir.maktab.service.service.ServiceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UnderServiceServiceImplTest {

    UnderServiceService underServiceService = new UnderServiceServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();

    @Test
    void save() {
        Service service = Service.builder()
                .title("manzel")
                .build();
        serviceService.save(service);
        UnderService underService = UnderService.builder()
                .details("asdasd")
                .service(service)
                .basePrice(123)
                .build();
        underServiceService.save(underService);
        Assertions.assertEquals(underService.getId(),underServiceService.findById(underService.getId()).getId());
    }

    @Test
    void findAll(){
        List<UnderService> all = underServiceService.findAll();
        Assertions.assertEquals(all.size(),underServiceService.findAll().size());
    }
}