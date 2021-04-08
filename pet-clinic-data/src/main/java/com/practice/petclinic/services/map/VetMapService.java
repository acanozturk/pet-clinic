package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Vet;
import com.practice.petclinic.services.VetService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
@NoArgsConstructor
public class VetMapService extends AbstractMapService<Vet> implements VetService {

}
