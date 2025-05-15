package com.example.crudapi.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.crudapi.demo.dto.UserDto;
import com.example.crudapi.demo.entity.User;
import com.example.crudapi.demo.entity.UserListing;

import jakarta.servlet.ServletException;

public interface UserService {

	String addUser(UserDto userDTO);

	List<UserDto> getAllUser();

	UserDto getUserById(Long id);

	String updateUser(Long id, UserDto userDTO);

	void delete(Long id);

	List<User> fetchAllProposerByStringBuilder(UserListing listing);

	String exportUsersToExcel() throws ServletException, IOException;

	void importExcelToUser(InputStream file) throws IOException;

	String batchProcessing(MultipartFile file) throws IOException;
}
