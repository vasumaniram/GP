/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.repository;

import com.gp.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gbs02362
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
    public UserDetails findByUserHandle(final String userHandle);
}
