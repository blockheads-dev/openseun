package io.seun.seunswap.security;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Component
public class FieldEncryptor implements AttributeConverter<String, String> {

    private String ENCRYPTION_ALGORITHM = "AES";

    private String ENCRYPTION_KEY = "#Xvc#P6CdLA$uqxK";

    private final Key key;

    private final Cipher cipher;

    @SneakyThrows
    public FieldEncryptor() {
        key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), ENCRYPTION_ALGORITHM);
        cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
    }

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(String field) {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(field.getBytes(StandardCharsets.UTF_8)));
    }

    @SneakyThrows
    @Override
    public String convertToEntityAttribute(String databaseData) {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(databaseData)));
    }

}
