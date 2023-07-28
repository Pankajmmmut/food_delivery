package com.test.FoodDelivery.service;

import com.test.FoodDelivery.model.AuthenticationToken;
import com.test.FoodDelivery.model.Customer;
import com.test.FoodDelivery.model.dto.SignInInput;
import com.test.FoodDelivery.model.dto.SignUpOutput;
import com.test.FoodDelivery.repository.IAuthToken;
import com.test.FoodDelivery.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    ICustomerRepo customerRepo;

    @Autowired
    IAuthToken authToken;

    public SignUpOutput signUpCustomer(Customer customer) {
        boolean SignUpStatus=true;
        String SignUpMessage=null;
        String newEmail = customer.getEmail();

        Customer existingCustomer = customerRepo.findFirstByEmail(newEmail);
        if(existingCustomer!=null){
            SignUpMessage="email already registerd!";
            SignUpStatus=false;
            return new SignUpOutput(SignUpStatus,SignUpMessage);
        }

        customerRepo.save(customer);
        SignUpMessage = "customer signed up.";
        SignUpStatus = true;

        return new SignUpOutput(SignUpStatus,SignUpMessage);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public String updateCustomerbyId(Integer id, String contact) {
        List<Customer> customer=getAllCustomers();
        for(Customer required : customer){
            if(required.getCustomerId()==id){
                required.setMobileNumber(contact);
                customerRepo.save(required);
                return "updated.";
            }
        }
        return "invalid id";
    }

    public String deleteCustomerbyId(Integer id) {
        List<Customer> customers=customerRepo.findAll();
        for (Customer required : customers){
            if(required.getCustomerId()==id){
                customerRepo.deleteById(id);
                return "deleted customer :"+id;
            }
        }
        return "not found";
    }

    public String signInCustomer(SignInInput signInInput) {
            String signInMessage=null;

            String signInEmail = signInInput.getEmail();

            Customer existingCustomer = customerRepo.findFirstByEmail(signInEmail);
            if(existingCustomer==null){
                signInMessage="email not valid.";
                return signInMessage;
            }

            String newPass = signInInput.getPassword();
            if(existingCustomer.getPassword().equals(newPass)){
                AuthenticationToken authenticationToken = new AuthenticationToken(existingCustomer);
                authToken.save(authenticationToken);
                return authenticationToken.getTokenValue()+" : copy token";
            }
            else{
                signInMessage = "Invalid email or password!!";
                return signInMessage;
            }
    }
}
