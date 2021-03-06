package com.wfs.gateway.controller;

import com.wfs.gateway.model.BusinessPartner;
import com.wfs.gateway.model.security.CurrentUser;
import com.wfs.gateway.model.security.UserDetails;
import com.wfs.gateway.service.BusinessPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aaltamir on 8/18/16.
 */
@RestController
@RequestMapping("/rest")
public class BusinessPartnerController extends BaseController {
    BusinessPartnerService businessPartnerService;

    @Autowired
    public BusinessPartnerController(BusinessPartnerService businessPartnerService) {
        this.businessPartnerService = businessPartnerService;
    }

    @RequestMapping(value = "/business-partners", method = RequestMethod.GET)
    public List<BusinessPartner> getAllBusinessPartners(@CurrentUser UserDetails userDetails)
    {
        if( userDetails != null ) {
            System.out.println("User Roles: " + userDetails.getRoles());
        }
        return businessPartnerService.getAllBusinessPartners();
    }
}
