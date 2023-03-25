package com.dmm.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dmm.task1.data.entity.Tasks;
import com.dmm.task1.data.repository.TasksRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService{
	@Autowired
	private TasksRepository repository;

	public UserDetails loadUserByUsername(Long id) throws UsernameNotFoundException {
		if (id == null || "".equals(id)) {
			throw new UsernameNotFoundException("ユーザー名が空です");
		}
		// データベースからアカウント情報を取得する
		Tasks user = repository.findById(id).get();
		if (user != null) {
			// UserDetailsの実装クラスを生成して返す
			return new AccountUserDetails(user);
		}
		throw new UsernameNotFoundException(id + "は見つかりません。");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}