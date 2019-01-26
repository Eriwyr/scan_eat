package com.codev.scan_eat_api.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TokenStore {
    private static TokenStore instance=null;
    private Map<String, String> tokens;

    private TokenStore() {
        tokens = new HashMap<>();
    }

    private static TokenStore getInstance() {
        if(instance == null) {
            instance = new TokenStore();
        }
        return instance;
    }

    public static void saveToken(String token, String username) {
        getInstance().tokens.put(token, username);
    }

    public static Optional<String> getUsernameByToken(String token) {
        if(getInstance().tokens.containsKey(token)) {
            return Optional.of(getInstance().tokens.get(token));
        } else {
            return Optional.empty();
        }
    }

    public static void deleteToken(String token) {
        getInstance().tokens.remove(token);
    }

}
