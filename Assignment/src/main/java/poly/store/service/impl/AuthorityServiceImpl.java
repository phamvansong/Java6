package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.dao.AuthorityDAO;
import poly.store.entity.Account;
import poly.store.entity.Authority;
import poly.store.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityDAO dao;
	@Autowired
	AccountDAO acdao;

	@Override
	public List<Authority> findAll() {
		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> account = acdao.getAdministrators();
		return dao.authoritiesOf(account);
	}

}
