package com.samasoft.reception.WEBAPI;

import com.samasoft.reception.SERVICES.Commune.CommuneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/commune")
public class CommuneWebApi {
    private CommuneService communeService;
}
