package ir.maktab.service.offer;

import ir.maktab.model.Offer;

public interface OfferService {

    void save(Offer offer);

    Offer findById(long id);
}
