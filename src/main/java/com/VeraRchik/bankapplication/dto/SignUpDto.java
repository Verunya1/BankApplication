package com.VeraRchik.bankapplication.dto;


public record SignUpDto (String firstName, String lastName, String phone, String login, char[] password) { }