package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.VipUser;

public interface IVipUserRepo extends CrudRepository<VipUser, Integer>{

}
