package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Speciality;
import com.practice.petclinic.services.SpecialityService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
@NoArgsConstructor
public class SpecialityMapService extends AbstractMapService<Speciality> implements SpecialityService {

}
