/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.repository;

import com.gp.entity.UserDetails;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author gbs02362
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDetailsRepositoryTests {
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private UserDetailsRepository userDetailsRepository;
    
    @Test
    public void testFindByUserHandle(){
        String userHandle = "USER5";
        final UserDetails userDetails = new UserDetails("AT", userHandle, null);
        testEntityManager.persist(userDetails);
        final UserDetails userDetailsFound = userDetailsRepository.findByUserHandle(userHandle);
        Assertions.assertThat(userDetailsFound).hasFieldOrPropertyWithValue("userHandle", userHandle);
    }
}
