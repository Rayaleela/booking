	package com.capg.campsite.controller;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.capg.campsite.dto.CampsiteDto;
import com.capg.campsite.entity.Campsite;
import com.capg.campsite.exception.CampsiteNotFoundException;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.service.CampsiteService;
 
@RestController
@RequestMapping("/campsite")
public class CampsiteController {
 
    @Autowired
    private CampsiteService campsiteService;
 
    @PostMapping("/add-campsite/{userId}")
    public ResponseEntity<?> addCampsite(@RequestBody CampsiteDto campsite)
            throws Exception {
        return new ResponseEntity<Campsite>(campsiteService.addCampsite(campsite, campsite.getUserIdies()), HttpStatus.CREATED);
    }
 
    @PutMapping("/update-campsite/{campsiteId}")
    public ResponseEntity<?> updateCampsite(@RequestBody CampsiteDto campsite, @PathVariable int campsiteId)
            throws CampsiteNotFoundException {
 
        return ResponseEntity.ok(campsiteService.updateCampsite(campsite, campsiteId));
    }
 
    @GetMapping("/get-campsite-by-id/{siteId}")
    public ResponseEntity<?> getCampsiteById(@PathVariable int siteId) throws CampsiteNotFoundException {
        return ResponseEntity.ok(campsiteService.getCampsite(siteId));
    }
 
    @GetMapping("/get-all-campsite")
    public ResponseEntity<?> getAllCampsite() throws CampsiteNotFoundException {
 
        return ResponseEntity.ok(campsiteService.getCampsiteDetails());
    }
 
    @DeleteMapping("/delete-campsite-by-id/{siteId}")
    public ResponseEntity<?> deleteCampsite(@PathVariable int siteId) throws CampsiteNotFoundException {
        campsiteService.deleteCampsite(siteId);
        return new ResponseEntity<>("Campsite Deleted Successfully with Id : " + siteId, HttpStatus.OK);
    }
 
}
