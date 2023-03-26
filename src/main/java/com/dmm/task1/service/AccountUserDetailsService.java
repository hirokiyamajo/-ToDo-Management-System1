package com.dmm.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dmm.task1.data.entity.Tasks;
import com.dmm.task1.data.repository.TasksRepository;

@Service // Spring管理Beanであることを指定
public class AccountUserDetailsService implements UserDetailsService {

	@Autowired
	private TasksRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (userName == null || "".equals(userName)) {
			throw new UsernameNotFoundException("ユーザー名が空です");
		}
		// データベースからアカウント情報を取得する
		Tasks user = repository.findById(userName).get();
		if (user != null) {
			// UserDetailsの実装クラスを生成して返す
			return new AccountUserDetails(user);
		}
		throw new UsernameNotFoundException(userName + "は見つかりません。");
	}
}