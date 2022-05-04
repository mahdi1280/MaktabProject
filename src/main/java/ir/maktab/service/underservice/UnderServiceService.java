package ir.maktab.service.underservice;

import ir.maktab.model.UnderService;

import java.util.List;

public interface UnderServiceService {

    void save(UnderService underService);

    UnderService findById(long id);

    List<UnderService> findAll();
}
