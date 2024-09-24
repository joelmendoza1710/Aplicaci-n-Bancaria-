package com.aplicacionbancaria.aplicacion_bancaria.persistence.mapper;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Transaction;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Transactions;

@Mapper(componentModel="spring",uses = {AccountMapper.class})
public interface TransactionMapper {

    @Mappings({
        @Mapping(source = "id",target = "transactionid"),
        @Mapping(source = "cuentaOrigenId",target = "accountoriginid"),
        @Mapping(source = "cuentaDestinoId",target = "accountdestinationid"),
        @Mapping(source = "fecha",target = "date"),
        @Mapping(source = "monto",target = "amount"),
        @Mapping(source = "descripcion",target = "description"),
        @Mapping(source = "accounts",target = "account"),

        



    })
    Transaction toTransaction(Transactions transactions);
  
    List<Transaction>totransactions(List<Transactions> transactions);

    @InheritInverseConfiguration
    Transactions totransactionsinverse(Transaction transaction); 

}
