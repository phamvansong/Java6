package poly.store.dao;

import poly.store.entity.Account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountDAO extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN('DIRE','STAF')")
	List<Account> getAdministrators();

}
