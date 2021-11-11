package edu.task4.service;

import edu.task4.model.Users;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod
    Users getUsers();
}
