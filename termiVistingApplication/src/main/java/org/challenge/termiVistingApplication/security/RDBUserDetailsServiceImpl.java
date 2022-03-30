package org.challenge.termiVistingApplication.security;


import org.challenge.termiVistingApplication.data.models.Authority;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.data.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RDBUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StaffRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Staff appUser = appUserRepository.findByEmail(username).orElse(null);
        
        if(appUser == null){
            throw new UsernameNotFoundException("this user with " + username + "does not exist");
        }

        List<Authority> authorities = new ArrayList<>();
        authorities.add(appUser.getAuthority());
        return new User(appUser.getEmail(), appUser.getPhoneNumber(), getAuthorities(authorities));
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Authority> authorities) {

        return authorities.stream().map(authority -> {
            return new SimpleGrantedAuthority(authority.name());
        }).collect(Collectors.toList());
    }


}
