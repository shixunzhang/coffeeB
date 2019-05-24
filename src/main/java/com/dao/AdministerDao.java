package com.dao;

import com.entity.CoffeeAdminister;

public interface AdministerDao {

    /**
     *
     * @param administerName
     * @return
     */
    CoffeeAdminister findAdministerByName(String administerName);
}
