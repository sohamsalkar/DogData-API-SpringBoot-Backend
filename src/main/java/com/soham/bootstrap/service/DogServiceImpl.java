package com.soham.bootstrap.service;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soham.bootstrap.entity.Dog;
import com.soham.bootstrap.repository.DogRepository;

@Service
public class DogServiceImpl implements DogService{
	@Autowired
	DogRepository dogRespository;
	public List<Dog> retrieveDogs()
	{
		return (List<Dog>)dogRespository.findAll() ;
	}
	@Override
	public List<String> retrieveDogBreed() {
		return (List<String>)dogRespository.findAllBreed();
	}
	@Override
	public String retrieveDogBreedById(Long id) {
		Optional<String> optionalBreed = Optional.ofNullable(dogRespository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
	}
	@Override
	public List<String> retrieveDogNames() {
		return (List<String>)dogRespository.findAllName();
	}
	

}
