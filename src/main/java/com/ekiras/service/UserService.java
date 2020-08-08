package com.ekiras.service;

import com.ekiras.domain.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
