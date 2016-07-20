package com.ezdi.daos;

import com.ezdi.beans.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by EZDI\ganesh.s on 15/7/16.
 */

public interface UserRepository extends CrudRepository<User, String> {
}
