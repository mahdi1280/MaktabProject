package ir.maktab.service.underservice;

import ir.maktab.model.UnderService;
import ir.maktab.repository.UnderServiceRepository;

import java.util.List;

public class UnderServiceServiceImpl implements UnderServiceService {

    private final UnderServiceRepository underServiceRepository;

    public UnderServiceServiceImpl(){
        this.underServiceRepository=new UnderServiceRepository() {};
    }
    @Override
    public void save(UnderService underService) {
        this.underServiceRepository.save(underService);
    }

    @Override
    public UnderService findById(long id) {
        return underServiceRepository.findById(UnderService.class,id);
    }

    @Override
    public List<UnderService> findAll() {
        return underServiceRepository.findAll(UnderService.class);
    }
}
