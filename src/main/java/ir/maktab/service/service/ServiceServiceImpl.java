package ir.maktab.service.service;

import ir.maktab.model.Service;
import ir.maktab.repository.ServiceRepository;

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
}
