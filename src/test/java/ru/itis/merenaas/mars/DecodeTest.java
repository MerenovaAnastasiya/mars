package ru.itis.merenaas.mars;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeTest  {

    private static final Logger log = Logger.getLogger(EncodeTest1.class);

    @SneakyThrows
    @Test
    public void decrypt()  {
        BufferedReader reader = new BufferedReader(new FileReader("decrypt.txt"));
        while (reader.ready()) {
            String key = reader.readLine();
            log.info(String.format("Ключ равен: %s", key));
            String out = reader.readLine();
            log.info(String.format("Ожидаемый результат: %s", out));
            String in = reader.readLine();
            log.info(String.format("Входящая строка: %s", in));

            byte[] inBytes = Hex.decodeHex(in.toCharArray());
            byte[] inKey = Hex.decodeHex(key.toCharArray());

            MarsCipherAlgorithm mars = new MarsCipherAlgorithm(inKey);
            byte[] result = mars.decrypt(inBytes);
            assertEquals(Hex.encodeHexString(result).toUpperCase(), out);
            log.info("Тест пройден успешно!");
            reader.readLine();
        }
    }
}
