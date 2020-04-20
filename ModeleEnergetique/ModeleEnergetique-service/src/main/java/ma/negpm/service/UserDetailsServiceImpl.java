package ma.negpm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.negpm.dao.RoleRepository;
import ma.negpm.dao.UserRepository;
import ma.negpm.domain.User;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private RoleRepository roleRepository;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userName));

//		return UserDetailsImpl.build(user);
 
        System.out.println("Found User: " + user);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.roleRepository.getRoleNames(user.getUserId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(), //
        		user.getEncrytedPassword(), grantList);
 
        return userDetails;
    }
 
}
