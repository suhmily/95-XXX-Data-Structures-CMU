/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.adder;

import java.math.BigInteger;
import java.util.function.BiConsumer;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Shubham
 */
@WebService(serviceName = "AdderService")
@Stateless()
public class AdderService {
    BigInteger ctr = BigInteger.valueOf(0);
    @WebMethod(operationName = "bump")
    public boolean bump() {
       ctr = ctr.add(BigInteger.ONE);
       return true;        
    }
    
    @WebMethod(operationName = "get")
    public BigInteger get() {
      return ctr;
    }
}
