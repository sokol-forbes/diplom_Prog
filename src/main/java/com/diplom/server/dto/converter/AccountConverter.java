package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Accounts;
import com.diplom.server.dto.AccountDto;

public class AccountConverter implements EntityConverter<Accounts, AccountDto>{

    @Override
    public AccountDto getDto(Accounts entity) {
        return AccountDto.builder()
                .id(entity.getId())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .role(entity.getRole()).build();
    }

    @Override
    public Accounts getEntity(AccountDto dto) {
        Accounts accounts = new Accounts();
        accounts.setLogin(dto.getLogin());
        accounts.setPassword(dto.getPassword());
        accounts.setRole(dto.getRole());
        return accounts;
    }
}
