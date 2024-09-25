package com.apibanco.bancoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apibanco.bancoapi.model.entity.Cuenta;
import com.apibanco.bancoapi.model.payload.MensajeResponse;
import com.apibanco.bancoapi.service.ICuenta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CuentaController {
    @Autowired
    private ICuenta cuentaService;

    @PostMapping("cuenta")
    public ResponseEntity<?> create(@RequestBody Cuenta cuenta) {
        Cuenta cuentasave = null;
        try {
            cuentasave = cuentaService.save(cuenta);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Guardado correctamente").object(cuentasave).build()
            ,HttpStatus.CREATED);

        

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder().mensaje(exDt.getMessage()).object(null).build(),
            HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping("cuenta")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody Cuenta cuenta) {
       Cuenta cuentaupdate = null;
        try {
            cuentaupdate = cuentaService.save(cuenta);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Actualizado correctamente").object(cuentaupdate).build()
            ,HttpStatus.CREATED);

        

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder().mensaje(exDt.getMessage()).object(null).build(),
            HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("cuenta/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cuenta cuentadelete = cuentaService.findbyCuenta(id);
            cuentaService.delete(cuentadelete);
            return new ResponseEntity<>(cuentadelete, HttpStatus.NO_CONTENT);

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder().mensaje(exDt.getMessage()).object(null).build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("cuenta/{id}")

    public  ResponseEntity<?> showById(@PathVariable Integer id) {
        Cuenta cuentas= cuentaService.findbyCuenta(id);

        if (cuentas==null) {
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("El registro que intenta buscar, no existe!").object(null).build(),
            HttpStatus.INTERNAL_SERVER_ERROR);
 
        }
        return new ResponseEntity<>(cuentas, HttpStatus.OK);

         
    }

    // Obtener todas las cuentas
    @GetMapping("/cuentas")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<List<Cuenta>> getAll() {
        List<Cuenta> cuentas = cuentaService.getAll();
        if (cuentas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

}
