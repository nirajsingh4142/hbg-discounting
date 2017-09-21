/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbg.otc.discounting.service;

import java.util.Collection;

import com.hbg.otc.discounting.model.SuspiciousOperation;

/**
 *
 * @author esteban
 */
public interface SuspiciousOperationService {
    public Collection<SuspiciousOperation> getSuspiciousOperationsByCustomer(Long customerId);
}
