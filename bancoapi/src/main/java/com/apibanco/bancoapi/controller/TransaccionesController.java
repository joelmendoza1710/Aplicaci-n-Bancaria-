package com.apibanco.bancoapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apibanco.bancoapi.model.entity.Transacciones;
import com.apibanco.bancoapi.service.ITransacciones;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins={"http://localhost:4200"})
public class TransaccionesController {
    @Autowired
    private ITransacciones iTransacciones;
    @PostMapping("transaccion")
    public Transacciones create(@RequestBody Transacciones transacciones){
       return iTransacciones.save(transacciones);
    }

    @PutMapping("transaccion")
    public Transacciones update(@RequestBody Transacciones transacciones){
        return iTransacciones.save(transacciones);
     }

     @DeleteMapping("transaccion/{id}")
    public void delete(@PathVariable Integer id){
        Transacciones transacciones=iTransacciones.findbyTransacciones(id);
        iTransacciones.delete(transacciones);
     }

     @GetMapping("transaccion/{id}")
     public Transacciones showById(@PathVariable Integer id){
       return iTransacciones.findbyTransacciones(id);
     }
      // Obtener todas las cuentas
    @GetMapping("/transacciones")
    public ResponseEntity<List<Transacciones>> getAll() {
        List<Transacciones> transacciones = iTransacciones.getAll();
        if (transacciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }


}
