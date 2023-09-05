package com.learn_with_me.modelsResponse;

import com.learn_with_me.modelsRequest.LoginRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	String token;
}
