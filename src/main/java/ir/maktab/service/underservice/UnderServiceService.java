package ir.maktab.service.underservice;

import ir.maktab.model.BaseEntity;
import ir.maktab.model.UnderService;

public interface UnderServiceService {

    void save(UnderService underService);

    UnderService findById(long id);
}
