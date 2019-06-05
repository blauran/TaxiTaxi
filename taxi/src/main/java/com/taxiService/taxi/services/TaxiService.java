package com.taxiService.taxi.services;

import com.taxiService.taxi.exceptions.GenericException;
import com.taxiService.taxi.models.Request;
import com.taxiService.taxi.models.Role;
import com.taxiService.taxi.models.TaxiCar;
import com.taxiService.taxi.models.User;
import com.taxiService.taxi.models.data.RequestDao;
import com.taxiService.taxi.models.data.TaxiCarDao;
import com.taxiService.taxi.models.data.UserDao;
import com.taxiService.taxi.utils.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TaxiService {

    private UserDao userDao;
    private RequestDao requestDao;
    private TaxiCarDao taxiCarDao;

    @Autowired
    public TaxiService(UserDao userDao,RequestDao requestDao,TaxiCarDao taxiCarDao){
        this.requestDao = requestDao;
        this.taxiCarDao = taxiCarDao;
        this.userDao = userDao;
    }

    public List<User> findCompanies(){
        return userDao.findAllByRole(Role.COMPANY);
    }

    public void createUser(RegisterDto registerDto) throws GenericException {
        User user = new User();
        if(registerDto.getName() == null || registerDto.getName().length() < 3 ||
                registerDto.getUsername() == null || registerDto.getUsername().length() < 3 ||
                registerDto.getPassword() == null || registerDto.getPassword().length() < 3) {
            throw new GenericException("All fields must have al least 3 characters.");
        }

        user.setRole(Role.CLIENT);
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setName(registerDto.getName());

        userDao.save(user);
    }


    public void makeRequest(Request request, TaxiCar taxiCar){
        LocalDateTime time = request.getRequestTime();
        taxiCar.setTarif();


    }

}
