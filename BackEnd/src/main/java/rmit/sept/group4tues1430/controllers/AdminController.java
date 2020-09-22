package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.Admin;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.services.AdminService;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable String id)
    {
        Admin admin = adminService.findByID(id);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewAdmin(@Valid @RequestBody Admin admin, BindingResult result) {

        Admin admin1 = adminService.saveOrUpdateAdmin(admin);
        return new ResponseEntity<Admin>(admin1, HttpStatus.CREATED);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAdminByName(@PathVariable String name)
    {
        Admin admin = adminService.getAdminByName(name);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @GetMapping("/allAdmins")
    public Iterable<Admin> findAllAdmins()
    {
        return adminService.findAllAdmins();
    }

    @DeleteMapping("/id/{id}")
    public void deleteAdminById(@PathVariable String id)
    {
        adminService.deleteAdminById(id);
    }

}
