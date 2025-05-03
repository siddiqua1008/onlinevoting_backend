package com.example.ovsback.service;

import com.example.ovsback.model.Admin;

public interface AdminService {
Admin save(Admin a);
Admin login(String em,String ps);
}
