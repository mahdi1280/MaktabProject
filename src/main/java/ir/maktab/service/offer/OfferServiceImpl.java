package ir.maktab.service.offer;

import ir.maktab.model.Offer;
import ir.maktab.repository.OfferRepository;

public class OfferServiceImpl implements OfferService{

    private final OfferRepository offerRepository;

    public OfferServiceImpl(){
        this.offerRepository=new OfferRepository() {};
    }

    @Override
    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    @Override
    public Offer findById(long id) {
        return offerRepository.findById(Offer.class,id);
    }
}
