/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.controller;

import com.gp.entity.Game;
import com.gp.entity.UserDetails;
import com.gp.modal.JsonResponse;
import com.gp.repository.GameRepository;
import com.gp.repository.UserDetailsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gbs02362
 */
@RestController(value = "/portal")
public class PortalController {
    @Autowired private GameRepository gameRepository;
    @Autowired private UserDetailsRepository userDetailsRepository;
    
    @RequestMapping(value="/games",method = {RequestMethod.GET})
    public JsonResponse getAllGames(){
        final List<Game> games = new ArrayList<>();
        final JsonResponse jsonResponse = new JsonResponse();
        try{
            gameRepository.findAll().forEach(x -> games.add(x));
            jsonResponse.getData().addAll(games);
        } catch(Exception exception){
            jsonResponse.setStatus("KO");
            jsonResponse.setError(exception.getMessage());
        }
        return jsonResponse;
    }
    
    @RequestMapping(value="/users/{handle}",method={RequestMethod.GET})
    public JsonResponse isUserExist(@PathVariable String handle){
        final JsonResponse jsonResponse = new JsonResponse();
        try{
            final UserDetails userDetails = userDetailsRepository.findByUserHandle(handle);
            if( null == userDetails || null == userDetails.getToken() || userDetails.getToken().trim().length() == 0){
                jsonResponse.setStatus("KO");
                jsonResponse.setError("User Token Does Not Exist");
            }
        } catch(Exception exception){
            jsonResponse.setStatus("KO");
            jsonResponse.setError(exception.getMessage());
        }
        return jsonResponse;
    }
    
    @RequestMapping(value="/users",method = {RequestMethod.GET})
    public JsonResponse getAllUserDetails(){
        final List<UserDetails> userDetailsList = new ArrayList<>();
        final JsonResponse jsonResponse = new JsonResponse();
        try{
            userDetailsRepository.findAll().forEach( x -> userDetailsList.add(x));
            jsonResponse.getData().addAll(userDetailsList);
        } catch(Exception exception){
            jsonResponse.setStatus("KO");
            jsonResponse.setError(exception.getMessage());
        }
        return jsonResponse;
    }
    
    @RequestMapping(value="/users/{handle}",method = {RequestMethod.PUT})
    public JsonResponse updateUserToken(@PathVariable final String handle,@RequestParam final String token){
        final JsonResponse jsonResponse = new JsonResponse();
        try{
            final UserDetails userDetails = userDetailsRepository.findByUserHandle(handle);
            if( null == userDetails){
                jsonResponse.setStatus("KO");
                jsonResponse.setError("User Does Not Exist");
            } else {
                userDetails.setToken(token);
                userDetailsRepository.saveAndFlush(userDetails);
            }
        } catch(Exception exception){
            jsonResponse.setStatus("KO");
            jsonResponse.setError(exception.getMessage());
        }
        return jsonResponse;
    }
    
}
