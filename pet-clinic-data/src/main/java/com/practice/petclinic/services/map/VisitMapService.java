package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Visit;
import com.practice.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {

}
