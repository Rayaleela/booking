package com.capg.campsite.service;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
 
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capg.campsite.dto.CampsiteDto;
import com.capg.campsite.entity.Campsite;
import com.capg.campsite.entity.User;
import com.capg.campsite.exception.CampsiteNotFoundException;

import com.capg.campsite.repository.CampsiteRepository;


@ExtendWith(MockitoExtension.class)
public class CampsiteServiceTest {

    @Mock
    private CampsiteRepository campsiteRepository;

    @InjectMocks
    private CampsiteServiceImpl campsiteService;

    @Test
    public void testGetCampsiteById() throws CampsiteNotFoundException {
        
        int siteId = 1;
        Campsite campsite = new Campsite();
        
    }
    @Test
    public void testGetCampsiteDetails()throws CampsiteNotFoundException {
        List<Campsite> campsiteList = new ArrayList<>();
        campsiteList.add(new Campsite());
        campsiteList.add(new Campsite());

        Mockito.when(campsiteRepository.findAll()).thenReturn(campsiteList);

        List<Campsite> result = campsiteService.getCampsiteDetails();

        Assert.assertEquals(2, result.size());
    }
   @Test
    public void testAddCampsite() throws Exception {
        List<Long> userIdList = new ArrayList<>();
        userIdList.add(1L);
        userIdList.add(2L);

        User user1 = new User();
        user1.setUserId(1L);
        User user2 = new User();
        user2.setUserId(2L);

       

        CampsiteDto campsiteDto = new CampsiteDto(false, false, 0, false, false, false, userIdList);
        campsiteDto.setAvailability(true);
        campsiteDto.setCampsiteTent(true);
        campsiteDto.setCapacity(10);
        campsiteDto.setDrinkingWater(true);
        campsiteDto.setFirePit(true);
        campsiteDto.setRestrooms(true);
        campsiteDto.setUserIdies(userIdList);
 
        }

    @Test
    public void testUpdateCampsite() throws CampsiteNotFoundException {
      
        int campsiteId = 1;
        CampsiteDto campsiteDto = new CampsiteDto(false, false, campsiteId, false, false, false, null);
        campsiteDto.setAvailability(true);
        campsiteDto.setCampsiteTent(true);
        campsiteDto.setCapacity(4);
        campsiteDto.setDrinkingWater(true);
        campsiteDto.setFirePit(true);
        campsiteDto.setRestrooms(true);
        Campsite c = new Campsite();
        c.setSiteId(campsiteId);
        c.setAvailability(false);
        c.setCampsiteTent(false);
        c.setCapacity(2);
        c.setDrinkingWater(false);
        c.setFirePit(false);
        c.setRestrooms(false);

        when(campsiteRepository.findById(campsiteId)).thenReturn(Optional.of(c));
        when(campsiteRepository.save(any(Campsite.class))).thenReturn(c);

        
        Campsite result = campsiteService.updateCampsite(campsiteDto, campsiteId);

        
        assertEquals(campsiteDto.isAvailability(), result.isAvailability());
        assertEquals(campsiteDto.isCampsiteTent(), result.isCampsiteTent());
        assertEquals(campsiteDto.getCapacity(), result.getCapacity());
        assertEquals(campsiteDto.isDrinkingWater(), result.isDrinkingWater());
        assertEquals(campsiteDto.isFirePit(), result.isFirePit());
        assertEquals(campsiteDto.isRestrooms(), result.isRestrooms());
    }
 
        
    }



