package ir.maktab.service.service;

import ir.maktab.model.Service;

import java.util.List;

public interface ServiceService {

    void save(Service service);

    Service findById(long id);

    List<Service> findAll();
}
