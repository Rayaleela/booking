package com.capg.campsite.service;
 
import java.util.ArrayList;
import java.util.List;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.capg.campsite.dto.CampsiteDto;
import com.capg.campsite.entity.Campsite;
import com.capg.campsite.entity.User;
import com.capg.campsite.exception.CampsiteNotFoundException;
import com.capg.campsite.exception.UserNotFoundException;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.repository.CampsiteRepository;
import com.capg.campsite.repository.UserRepository;
 
@Service
public class CampsiteServiceImpl implements CampsiteService {
 
    @Autowired
    private CampsiteRepository campsiteRepository;
    private static final Logger logger =  LoggerFactory.getLogger(CampsiteServiceImpl.class);

    @Autowired
    UserRepository repository;
 
    @Override
    public Campsite addCampsite(CampsiteDto campsite, List<Long> userId) throws Exception {
        List<User> u = new ArrayList<>();
        for (int i = 0; i < userId.size(); i++) {
            Long j = userId.get(i);
            User u1 = repository.findById(userId.get(i))
                    .orElseThrow(() -> new UserNotFoundException("User not found in the database with id : " + j));
 
            if (u1.getUserId() == userId.get(i)) {
                u.add(u1);
            }
        }
        Campsite campsite2 = new Campsite();
        campsite2.setAvailability(campsite.isAvailability());
        campsite2.setCampsiteTent(campsite.isCampsiteTent());
        campsite2.setCapacity(campsite.getCapacity());
        campsite2.setDrinkingWater(campsite.isDrinkingWater());
        campsite2.setFirePit(campsite.isFirePit());
        campsite2.setRestrooms(campsite.isRestrooms());
        campsite2.setUser(u);
        logger.info("add campsite");
        return campsiteRepository.save(campsite2);
    }
 
    @Override
    public Campsite updateCampsite(CampsiteDto campsite, int campsiteId) throws CampsiteNotFoundException {
        Campsite c = campsiteRepository.findById(campsiteId)
                .orElseThrow(() -> new CampsiteNotFoundException("Campsite is not exists with id :" + campsiteId));
        campsiteRepository.delete(c);
        c.setAvailability(campsite.isAvailability());
        c.setCampsiteTent(campsite.isCampsiteTent());
        c.setCapacity(campsite.getCapacity());
        c.setDrinkingWater(campsite.isDrinkingWater());
        c.setFirePit(campsite.isFirePit());
        c.setRestrooms(campsite.isRestrooms());
        logger.info("update campsite");
        return campsiteRepository.save(c);
    }
 
    @Override
    public Campsite getCampsite(int siteId) throws CampsiteNotFoundException {
        logger.info("get campsite");
        return campsiteRepository.findById(siteId)
                .orElseThrow(() -> new CampsiteNotFoundException("Campsite is not exists with id :" + siteId));
 
    }
 
    @Override
    public List<Campsite> getCampsiteDetails() throws CampsiteNotFoundException {
        if (campsiteRepository.findAll().isEmpty()) {

        }
        logger.info("get campsite details");
        return campsiteRepository.findAll();
    }
 
    @Override
    public void deleteCampsite(int siteId) throws CampsiteNotFoundException {
        Campsite c = campsiteRepository.findById(siteId)
                .orElseThrow(() -> new CampsiteNotFoundException("Campsite is not Present with id " + siteId));
        logger.info("delete campsite");
        campsiteRepository.delete(c);
    }
 
}
