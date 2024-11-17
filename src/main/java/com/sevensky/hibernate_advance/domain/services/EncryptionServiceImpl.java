package com.sevensky.hibernate_advance.domain.services;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    @Override
    public String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    @Override
    public String decrypt(String encryptedText)
    {
        return new String(Base64.getDecoder().decode(encryptedText));
    }
}
