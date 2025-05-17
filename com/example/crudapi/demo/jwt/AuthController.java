package com.example.crudapi.demo.jwt;

import com.example.crudapi.demo.response.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    public ResponseHandler test() {
        ResponseHandler response = new ResponseHandler();
        try {
            response.setStatus(true);
            response.setMessage("Hello Everyone");
            response.setData("Hello Everyone");
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage("Failed to say hello");
            response.setData(null);
        }
        return response;
    }

    @PostMapping("/register")
    public ResponseHandler register(@RequestBody EmployeeDTO employeeDto) {
        ResponseHandler response = new ResponseHandler();
        try {
            Employee employee = employeeService.register(employeeDto);
            response.setStatus(true);
            response.setMessage("Registration successful");
            response.setData(employee);
        } catch (IllegalArgumentException e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage("Registration failed");
            response.setData(null);
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseHandler login(@RequestBody LoginRequest request) {
        ResponseHandler response = new ResponseHandler();
        try {
            LoginResponse loginResponse = authService.authenticateUser(request);
            response.setStatus(true);
            response.setMessage("Login successful");
            response.setData(loginResponse);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(false);
            response.setMessage("Invalid credentials");
            response.setData(null);
        }
        return response;
    }
}
