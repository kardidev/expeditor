package com.ignesis.expeditor.services;

import org.springframework.stereotype.Service;

/**
 * Created by Kardi on 31.05.2015.
 */

@Service
public class MainServiceImpl implements MainService {

    public boolean isUserValid(String user, String password) {
        return true;
    }

}
