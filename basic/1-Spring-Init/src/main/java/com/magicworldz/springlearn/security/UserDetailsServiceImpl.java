package com.magicworldz.springlearn.security;

import com.magicworldz.springlearn.security.entity.*;
import com.magicworldz.springlearn.security.jpa.UserRepository;
import com.magicworldz.springlearn.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        var authorities = new HashSet<Authority>();
        authorities.addAll(user.getUserAuthorities().stream()
                .map(UserAuthority::getAuthority).collect(Collectors.toList()));
        Set<GroupAuthority> groupAuthorities = user.getGroupMembers().stream().map(GroupMember::getGroup)
                .map(Group::getGroupAuthorities).reduce((l, r)-> CollectionUtil.merge(l, r)).get();
        authorities.addAll(groupAuthorities.stream()
                .map(GroupAuthority::getAuthority).collect(Collectors.toList()));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
