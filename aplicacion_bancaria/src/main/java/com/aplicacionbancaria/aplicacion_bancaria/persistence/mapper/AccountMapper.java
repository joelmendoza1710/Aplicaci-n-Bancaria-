package com.aplicacionbancaria.aplicacion_bancaria.persistence.mapper;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Account;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Accounts;

@Mapper(componentModel="spring",uses = {TransactionMapper.class})
public interface AccountMapper {

    
    @Mappings({
        @Mapping(source = "id",target = "accountid"),
        @Mapping(source = "usuarioId",target = "userid"),
        @Mapping(source = "numeroCuenta",target = "numberaccount"),
        @Mapping(source = "saldo",target = "balance"),
        @Mapping(source = "saldo",target = "balance"),
        @Mapping(source = "transactions",target = "transaction"),
        @Mapping(source = "users",target = "user"),





    })
    Account toaccount(Accounts accounts);
   
    List<Account> toaccounts(List<Accounts>Accounts);

@InheritInverseConfiguration
Accounts toaccounts(Account account);



}
