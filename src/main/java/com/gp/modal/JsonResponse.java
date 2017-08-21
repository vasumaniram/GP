/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gbs02362
 */

public class JsonResponse implements Serializable {
    private String status;
    private List  data;
    private String error;

    public JsonResponse(){
        this.status = "OK";
        this.data = new ArrayList(1);
        this.error = "";
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
