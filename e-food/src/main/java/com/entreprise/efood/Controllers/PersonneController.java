// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package com.entreprise.efood.Controllers;

// import com.entreprise.efood.Models.Personne;
// import com.entreprise.efood.repository.PersonneRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;

// /**
//  *
//  * @author david
//  */
// @Controller
// public class PersonneController {
//     private final   PersonneRepository pesonneRepository ;

//     @Autowired
//     public PersonneController(PersonneRepository pesonneRepository) {
//         this.pesonneRepository = pesonneRepository;
//     }
//     @GetMapping("/personne")
//     public String savePersonne(@ModelAttribute  Personne personne, Model model) {
//         //Pesonne p1=new personne();
//         //pesonneRepository.save(personne);
//          return  "home_page/index";
//     }
    
// }





