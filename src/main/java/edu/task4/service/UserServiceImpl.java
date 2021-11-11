package edu.task4.service;

import edu.task4.model.Users;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "edu.task4.service.UserService")
public class UserServiceImpl implements UserService{
    @Override
    @WebMethod
    public Users getUsers() {
        return new Users();
    }
}
