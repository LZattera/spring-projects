package com.zattera.first_spring_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zattera.first_spring_app.domain.User;
import com.zattera.first_spring_app.services.HelloWorldService;

//Essa anotação indiCa que essa classe é um controller REST
//Essa anotação esta combinando duas anotações a @Controller 
// e a @ResponseBody
@RestController
@RequestMapping("/hello-world") 
public class HelloWorldController{

    //outro forma de trabalhar com injeção de dependencia para chamr um service e suas funções
    @Autowired
    private HelloWorldService helloWorldService;

    //Uma maneira de trabalhar com injeção de dependencia
    //construtor que chama o service edepois podemos char as funções dentro do service
    // public HelloWorldController(HelloWorldService helloWorldService){
        // this.helloWorldService = helloWorldService;
    // }
    
    // @GetMapping("/get") //Metodo GET
    @GetMapping
    public String helloWorld(){ return helloWorldService.helloWorld("Leticia"); }

    @PostMapping("/{id}")
    //ANOTAÇÃO de path variable
    //@RequestBody é uma ANOTAÇÃO 
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter,@RequestBody User body){
        return "Hello post " + body.getName() + " " + filter;
    }
}