package com.wfs.gateway.service.impl;

import com.wfs.gateway.model.BusinessPartner;
import com.wfs.gateway.service.BusinessPartnerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaltamir on 8/18/16.
 */
@Service
public class BusinessPartnerServiceImpl implements BusinessPartnerService {

    /**
     *
     * @return
     */
    @Override
    public List<BusinessPartner> getAllBusinessPartners() {
        List<BusinessPartner> results = new ArrayList<>();
        BusinessPartner tmp = null;

        for (int i = 0; i < 10; i++) {
            tmp = new BusinessPartner( "1" , "partnerCode " + String.valueOf(i), "partnerName", "partyName", new Boolean(true), "createdBy", "lastUpdateDate", "lastUpdatedDate", "lastUpdatedBy", BusinessPartner.STATUS_ACTIVE );
            results.add(tmp);
        }

        return results;
    }
}
