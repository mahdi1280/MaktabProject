package ir.maktab.service.service;

import ir.maktab.model.Service;
import ir.maktab.repository.ServiceRepository;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl() {
        this.serviceRepository = new ServiceRepository() {};
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service findById(long id) {
        return serviceRepository.findById(Service.class,id);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll(Service.class);
    }
}
