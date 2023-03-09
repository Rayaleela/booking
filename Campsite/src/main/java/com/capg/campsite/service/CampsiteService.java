package com.capg.campsite.service;
 
import java.util.List;
 
import com.capg.campsite.dto.CampsiteDto;
import com.capg.campsite.entity.Campsite;
import com.capg.campsite.exception.CampsiteNotFoundException;

 
public interface CampsiteService {
    public Campsite addCampsite(CampsiteDto campsite,List<Long> userId) throws Exception;
 
    public Campsite updateCampsite(CampsiteDto campsite,int campsiteId) throws CampsiteNotFoundException;
 
    public Campsite getCampsite(int siteId) throws CampsiteNotFoundException;
 
    public List<Campsite> getCampsiteDetails() throws CampsiteNotFoundException;

    public void deleteCampsite(int siteId) throws CampsiteNotFoundException;
 
}
