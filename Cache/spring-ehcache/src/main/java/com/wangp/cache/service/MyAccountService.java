package com.wangp.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.wangp.cache.beans.Account;

public class MyAccountService {
	@Cacheable(value = "accountCache" , key="#userName")
	// 使用了一个缓存名叫 accountCache
	public Account getAccountByName(String userName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("real query account." + userName);
		return getFromDB(userName);
	}

	@Cacheable(value = "accountCache", condition = "#userName.length() <= 4")
	// 缓存名叫 accountCache
	public Account getAccountByNameAndCondition(String userName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		return getFromDB(userName);
	}

	 @CachePut(value="accountCache",key="#account.getName()")// 更新 accountCache 缓存
	 public void updateAccountAndPutInToCache(Account account) { 
	   updateDB(account); 
	 } 
	
	@CacheEvict(value = "accountCache", key = "#account.getName()")
	// 清空 accountCache 缓存
	public void updateAccount(Account account) {
		updateDB(account);
	}

	@CacheEvict(value = "accountCache", allEntries = true)
	// 清空 accountCache 缓存
	public void reload() {
	}

	private Account getFromDB(String acctName) {
		System.out.println("real querying db..." + acctName);
		return new Account(acctName);
	}

	private void updateDB(Account account) {
		System.out.println("real update db..." + account.getName());
	}
}
