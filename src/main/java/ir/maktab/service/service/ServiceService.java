package ir.maktab.service.service;

import ir.maktab.model.Service;

public interface ServiceService {

    void save(Service service);

    Service findById(long id);

}
