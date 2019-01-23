package lab.librari.service;

import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import lab.librari.service.impl.BrowsingServiceImpl;

public class BrowsingServiceStarter {

    public static void main(String[] args) {
        System.out.println("BrowsingServiceStarter.main");

        BrowsingService bs = new BrowsingServiceImpl();
        
        Publisher p = bs.getPublisher(1L);

        System.out.println("p = " + p);
        
        
    }
}
