package ir.maktab.service.offer;

import ir.maktab.model.Offer;

import java.util.List;

public interface OfferService {

    void save(Offer offer);

    Offer findById(long id);

    List<Offer> findAll();
}
