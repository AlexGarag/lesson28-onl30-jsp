package by.tms.lesson28.onl30.jsp.servants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public class FileProcessor {

    public static void saveUser(String uuidUser, String nameUser, String loginUser, String passwordUser, byte[] avatarUser) {
        //todo не работает преобразование byte[] -> String
//        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
//        CharBuffer charBuffer = null;
//        try {
//            charBuffer = decoder.decode(ByteBuffer.wrap(avatarUser));
//        } catch (CharacterCodingException e) {
//            throw new RuntimeException(e);
//        }
//        String imageString = charBuffer.toString();

        String lineFileCsv = String.format(USERS_CSV_FORMAT_TEMPLATE,
                uuidUser,
                nameUser,
                loginUser,
                passwordUser,
                new String(avatarUser));
        Thread saveUser = new Thread(() -> {
            try {
                Files.write(Paths.get(USERS_CSV_FILE), lineFileCsv.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(USERS_CSV_FILE)));
            }
        });
        saveUser.start();
    }

    public static String readFile(String nameFile) {
        String historyString = null;
        try {
            historyString = Files.readString(Paths.get(nameFile));
        } catch (IOException ex) {
            logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(nameFile)));
        }
        return historyString;
    }
}