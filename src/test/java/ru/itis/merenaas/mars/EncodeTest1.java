package ru.itis.merenaas.mars;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodeTest1 {

    private static final Logger log = Logger.getLogger(EncodeTest1.class);

    @SneakyThrows
    @Test
    public void encodeTest128()  {
        BufferedReader reader = new BufferedReader(new FileReader("128.txt"));
        while (reader.ready()) {
            String index = reader.readLine().substring(2);
            log.info(String.format("Сканирование элемента с индексом %s", index));
            String key = reader.readLine().substring(4);
            log.info(String.format("Ключ равен: %s", key));
            String in = reader.readLine().substring(3);
            log.info(String.format("Входящая строка: %s", in));
            String out = reader.readLine().substring(3);
            log.info(String.format("Ожидаемый результат: %s", out));

            byte[] inBytes = Hex.decodeHex(in.toCharArray());
            byte[] inKey = Hex.decodeHex(key.toCharArray());

            MarsCipherAlgorithm mars = new MarsCipherAlgorithm(inKey);
            byte[] result = mars.encrypt(inBytes);
            assertEquals(Hex.encodeHexString(result).toUpperCase(), out);
            log.info("Тест пройден успешно!");
            reader.readLine();
        }
    }

    @SneakyThrows
    @Test
    public void encodeTest192()  {
        BufferedReader reader = new BufferedReader(new FileReader("192.txt"));
        while (reader.ready()) {
            String index = reader.readLine().substring(2);
            log.info(String.format("Сканирование элемента с индексом %s", index));
            String key = reader.readLine().substring(4);
            log.info(String.format("Ключ равен: %s", key));
            String in = reader.readLine().substring(3);
            log.info(String.format("Входящая строка: %s", in));
            String out = reader.readLine().substring(3);
            log.info(String.format("Ожидаемый результат: %s", out));

            byte[] inBytes = Hex.decodeHex(in.toCharArray());
            byte[] inKey = Hex.decodeHex(key.toCharArray());

            MarsCipherAlgorithm mars = new MarsCipherAlgorithm(inKey);
            byte[] result = mars.encrypt(inBytes);
            assertEquals(Hex.encodeHexString(result).toUpperCase(), out);
            log.info("Тест пройден успешно!");
            reader.readLine();
        }
    }

    @SneakyThrows
    @Test
    public void encodeTest256()  {
        BufferedReader reader = new BufferedReader(new FileReader("192.txt"));
        while (reader.ready()) {
            String index = reader.readLine().substring(2);
            log.info(String.format("Сканирование элемента с индексом %s", index));
            String key = reader.readLine().substring(4);
            log.info(String.format("Ключ равен: %s", key));
            String in = reader.readLine().substring(3);
            log.info(String.format("Входящая строка: %s", in));
            String out = reader.readLine().substring(3);
            log.info(String.format("Ожидаемый результат: %s", out));

            byte[] inBytes = Hex.decodeHex(in.toCharArray());
            byte[] inKey = Hex.decodeHex(key.toCharArray());

            MarsCipherAlgorithm mars = new MarsCipherAlgorithm(inKey);
            byte[] result = mars.encrypt(inBytes);
            assertEquals(Hex.encodeHexString(result).toUpperCase(), out);
            log.info("Тест пройден успешно!");
            reader.readLine();
        }
    }

}
