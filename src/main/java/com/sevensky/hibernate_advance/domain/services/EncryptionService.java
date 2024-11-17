package com.sevensky.hibernate_advance.domain.services;

import org.springframework.stereotype.Component;

public interface EncryptionService {
     String encrypt(String plainText);
     String decrypt(String encryptedText);
}
