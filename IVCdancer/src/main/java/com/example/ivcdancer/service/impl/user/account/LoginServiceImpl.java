package com.example.ivcdancer.service.impl.user.account;

import com.example.ivcdancer.pojo.User;
import com.example.ivcdancer.service.impl.utils.UserDetailsImpl;
import com.example.ivcdancer.service.user.account.LoginService;
import com.example.ivcdancer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getId().toString());
        String email = user.getEmail();
        Map<String, String> map = new HashMap<>();
        map.put("message", "");
        map.put("token", jwt);
        map.put("username", username);
        map.put("password", password);
        map.put("email", email);
        return map;
    }
}
