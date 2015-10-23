package client;

import javax.annotation.Resource;

import org.junit.Test;

import base.BaseJunit4Test;

import com.wangp.cache.beans.Account;
import com.wangp.cache.service.MyAccountService;

public class Client extends BaseJunit4Test {

	@Resource
	MyAccountService myAccountService;

	@Test
	public void myAccountServiceTest() {
		try {
			// 第一次查询，应该走数据库
			System.out.print("first query...");
			myAccountService.getAccountByName("somebody");
			// 第二次查询，应该不查数据库，直接返回缓存的值
			System.out.print("second query...");
			myAccountService.getAccountByName("somebody");
			System.out.println();

			System.out.println("start testing clear cache..."); // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
			Account account1 = myAccountService.getAccountByName("somebody1");
			Account account2 = myAccountService.getAccountByName("somebody2");
			// 开始更新其中一个 account1.setId(1212);
			myAccountService.updateAccount(account1);
			myAccountService.getAccountByName("somebody1");// 因为被更新了，所以会查询数据库
			myAccountService.getAccountByName("somebody2");// 没有更新过，应该走缓存
			myAccountService.getAccountByName("somebody1");// 再次查询，应该走缓存
			// 更新所有缓存
			myAccountService.reload();
			myAccountService.getAccountByName("somebody1");// 应该会查询数据库
			myAccountService.getAccountByName("somebody2");// 应该会查询数据库
			myAccountService.getAccountByName("somebody1");// 应该走缓存
			myAccountService.getAccountByName("somebody2");// 应该走缓存
			
			System.out.println("start testing condition cache...");
			myAccountService.reload();
			myAccountService.getAccountByNameAndCondition("somebody");// 长度大于 4，不会被缓存
			myAccountService.getAccountByNameAndCondition("sbd");// 长度小于 4，会被缓存
			myAccountService.getAccountByNameAndCondition("somebody");// 还是查询数据库
			myAccountService.getAccountByNameAndCondition("sbd");// 会从缓存返回
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
