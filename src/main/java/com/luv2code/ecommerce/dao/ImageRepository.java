package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageModel, Long> {

    Optional<ImageModel> findByName(String imageName);


}