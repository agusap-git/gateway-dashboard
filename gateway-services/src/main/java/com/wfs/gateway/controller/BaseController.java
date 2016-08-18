package com.wfs.gateway.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aaltamir on 8/18/16.
 */
@RestController
public class BaseController {
    protected final Logger log = Logger.getLogger(this.getClass().getName());
}
