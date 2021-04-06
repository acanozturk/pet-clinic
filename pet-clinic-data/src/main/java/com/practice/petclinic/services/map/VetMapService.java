package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Vet;
import com.practice.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet> implements VetService {

}
