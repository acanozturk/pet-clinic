package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Visit;
import com.practice.petclinic.services.VisitService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
@NoArgsConstructor
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {

}
