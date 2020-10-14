package com.api.crowdlending.controller;


import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.api.crowdlending.model.User;

import com.api.crowdlending.model.Adminstrateur;

import com.api.crowdlending.repository.UserRepository;

import com.api.crowdlending.model.ContactModel;

import com.api.crowdlending.repository.ContactVisitorRepository;

import com.api.crowdlending.functionsUtils.*;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
	UserRepository userRepository;

    @Autowired
	ContactVisitorRepository _contactVisitorRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;




    @PostMapping(value = "/visitor/createMessageContact")
    @ResponseBody
    public ResponseEntity<ContactModel> createMessageContact(@RequestBody ContactModel newMessage) {

    	System.out.println("newMessage="+ newMessage.toString());

 	    String  newToken = MethodesUtils.generateAlphanumericStringToken();


 	   newMessage.setToken(newToken);


        return ResponseEntity.ok(_contactVisitorRepository.save(newMessage));

       // return ResponseEntity.ok().build();
     }

    @PostMapping("/admin/listMessagesContact")
    public ResponseEntity<List<ContactModel>> getAllMessagesContact(@RequestBody Adminstrateur infosAdmin) {

    	List<ContactModel> messages = _contactVisitorRepository.findAll();

    	return ResponseEntity.ok(messages);

    }



   @PostMapping(value = "/users/create")
   @ResponseBody
   public User createUser(@RequestBody User newUser) throws NoSuchAlgorithmException {
	    String  newToken = MethodesUtils.generateAlphanumericStringToken();
	    User userBdd = new User();

	    userBdd.setDateNaissance(newUser.getDateNaissance());

	    userBdd.setNom(newUser.getNom());

	    userBdd.setPrenom(newUser.getPrenom());

	    userBdd.setSex(newUser.getSex());

	    userBdd.setPhotoUser(newUser.getPhotoUser());

	    userBdd.setLogin(newUser.getLogin());

	    userBdd.setPassword(passwordEncoder.encode(newUser.getPassword()));

	    userBdd.setToken(newToken);

	    userBdd.setTypeCompte(newUser.getTypeCompte());

	    userBdd.setPseudo_name(newUser.getPseudo_name());

	    System.out.println("newUser.getNom()="+ newUser.getNom());



       return userRepository.save(userBdd);
    }

    @PostMapping("/users/checkUser")
    @ResponseBody
    public ResponseEntity<User> checkUser(@Valid @RequestBody User infosUser) throws NoSuchAlgorithmException{




 	    System.out.println("infosUser.login="+ infosUser.getLogin());

 	    System.out.println("infosUser.password="+ infosUser.getPassword());

 	    String passwordMd5 = MethodesUtils.getMD5Hex(infosUser.getPassword());

        return ResponseEntity.ok(userRepository.getUserByEmailAndPassword(infosUser.getLogin(),passwordMd5));


     }

    @PostMapping("/users/checkExistMailUser")
    @ResponseBody
    public ResponseEntity<User> checkExistMailUser(@Valid @RequestBody User infosUser) {


 	    System.out.println("infosUser.login="+ infosUser.getLogin());




        return ResponseEntity.ok(userRepository.checkExistMailUser(infosUser.getLogin()));


     }

    @PutMapping(value = "/users/update")
    @ResponseBody
    public ResponseEntity<User>  updateUser(@RequestBody User updateUser) throws NoSuchAlgorithmException {

    	 System.out.println("infosUser.token="+ updateUser.getToken());

    	 Optional<User>  userBdd = userRepository.checkExistUserByToken(updateUser.getToken());

    	 if(userBdd.isPresent()) {

    		 User _user = userBdd.get();

    		 _user.setDate_naissance(updateUser.getDateNaissance());

    		 _user.setDate_update(updateUser.getDate_update());

    		 _user.setNom(updateUser.getNom());

    		 _user.setPrenom(updateUser.getPrenom());

    		 _user.setPhotoUser(updateUser.getPhotoUser());

    		 _user.setSex(updateUser.getSex());

    		 _user.setPassword(MethodesUtils.getMD5Hex(updateUser.getPassword()));

    		 _user.setLogin(updateUser.getLogin());

    		 _user.setPseudo_name(updateUser.getPseudo_name());

    		 System.out.println("userbdd exist"+_user.getNom());

    		 return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);

    	 }else {

    		 System.out.println("non-userbdd exist");

    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }



     }




}
