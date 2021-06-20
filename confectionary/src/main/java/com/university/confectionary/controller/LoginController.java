//package com.university.confectionary.controller;
//
//import com.university.confectionary.dto.*;
//import com.university.confectionary.service.UserService;
//import com.university.confectionary.utils.JwtTokenGenerator;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class LoginController {
//    private final UserService userService;
//    private final JwtTokenGenerator jwtUtil;
//    private final UserDetailsService userDetailsService;
//    private final AuthenticationManager authenticationManager;
//
//    // get all orders by endpoint  /orders?size=6&page=2
//    @RequestMapping(value = "/my-login", method = RequestMethod.POST)
//    public ResponseLoginDto loginPost(
//            @RequestBody final LoginDto loginDto
//    ) throws Exception {
//        System.out.println("qwerrrrrrrrrrrrrrrr");
//        String result = userService.login(loginDto);
//
//        authenticate(loginDto.getLogin(), loginDto.getPassword());
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getLogin());
//        final String token = jwtUtil.generateToken(userDetails);
//        System.out.println("TOKN" + token);
//
//        System.out.println("rees");
//        System.out.println(result);
//
//        ResponseLoginDto responseLoginDto = new ResponseLoginDto(result);
//        return responseLoginDto;
//    }
//
//    private void authenticate(String username, String password) throws Exception{
//        try{
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        }catch (DisabledException e){
//            throw new Exception("USER_DISABLED", e);
//        }catch (BadCredentialsException e){
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//}
