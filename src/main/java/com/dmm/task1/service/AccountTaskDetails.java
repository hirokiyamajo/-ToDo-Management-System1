package com.dmm.task1.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.dmm.task1.data.entity.Tasks;

public class AccountTaskDetails implements UserDetails{
	private Tasks task;

	public AccountTaskDetails(Tasks task) {
		this.task = task;
	}

	//idを返す
	public Long getId() {
		return task.getId();
	}
	
	public String getTitle() {
		return task.getTitle();
	}

	
	public String getName() {
		return task.getName();
	}
	
	public String getText() {
		return task.getText();
	}
	
	public LocalDatetime getDate() {
		return task.getName();
	}
	
	public boolean isDone() {
		return true;
	}

	// アカウントの有効期限の状態を判定する
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// アカウントのロック状態を判定する
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 資格情報の有効期限の状態を判定する
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 有効なユーザかを判定する
	@Override
	public boolean isEnabled() {
		return true;
	}

	// Entityを返す
	public Tasks getTask() {
		return task;
	}

	
}
