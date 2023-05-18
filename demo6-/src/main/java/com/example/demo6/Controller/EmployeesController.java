package com.example.demo6.Controller;

import Model.Employee;
import com.example.demo6.ApiResponse.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeesController {
    ArrayList<Employee> employees=new ArrayList<>();
    @GetMapping ("/get")
     public ArrayList get(){
         return employees;
     }
    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }
    //update
    @PutMapping("/update/{index}")
    public ResponseEntity updatemployee(@Valid @RequestBody Employee employee,Errors errors,@PathVariable int index) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body(new ApiResponse("User Update it"));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUsers(@PathVariable int index){
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("User delete it"));
    }
    @PutMapping("/applay/{index}")
    public ResponseEntity applayAnuuel(@Valid@PathVariable Employee employee,int index,Errors errors) {
        if (errors.hasErrors()) {

                String message = errors.getFieldError().getDefaultMessage();
            if (employees.get(index).getAnnualLeave() == 0 & employees.get(index).isOnLeave()!=false)

                return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        //i need to make sure
      employees.set(index,employee.setAnnualLeave()-1) ;
        employees.set(index,employee.setOnLeave()=true);
//        employees.set(index,employee).isOnLeave(index)=true;
        //اذا

        return ResponseEntity.status(200).body(new ApiResponse("User Applaye Succefully"));

    }
}
