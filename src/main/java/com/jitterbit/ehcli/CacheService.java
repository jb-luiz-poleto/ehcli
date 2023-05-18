package com.jitterbit.ehcli;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.InvalidConfigurationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@ShellComponent
@SuppressWarnings("unused")
public class CacheService {
    private final CacheManager manager;
    private Cache userCodeCache;

    public CacheService() throws IOException {
        Resource resource = new ClassPathResource("ehcache.xml");
        InputStream input = resource.getInputStream();
        manager = CacheManager.newInstance(input);
    }

    @ShellMethod(value = "Connect to a Cache")
    public void connect(String cacheName) {
        Cache newCache = manager.getCache(cacheName);

        if (newCache == null) {
            throw new InvalidConfigurationException("Cache " + cacheName + " doesn't exsits.");
        }

        userCodeCache = newCache;
    }

    /**
     * Should have the following caches:
     * AuthenticationToken
     * AgentMessage
     * MessageToRevive
     * MessageId
     * TFACode
     * Lock
     * WhiteListIpCache
     * agentIdLocationRegistry
     * nodeToAgentServicesInstanceRegistry
     */
    @ShellMethod(value = "List available caches", key = "show")
    public String listCaches() {
        String[] cacheNames = manager.getCacheNames();

        StringBuilder sb = new StringBuilder();
        for (String s : cacheNames) {
            sb.append(s);
            sb.append('\n');
        }

        return sb.toString();
    }

    @ShellMethod(value = "Get all keys from cache", key = "keys")
    public String getKeys() {
        StringBuilder keys = new StringBuilder();

        for (Object key : userCodeCache.getKeys()) {
            keys.append((String) key);
            keys.append('\n');
        }

        return keys.toString();
    }

    @ShellMethod(value = "Get all keys from cache that match the given regexp (Java style)", key = "key")
    public String getMatchingKeys(String regexp) {
        Pattern pattern = Pattern.compile(regexp);
        StringBuilder keys = new StringBuilder();

        for (Object key : userCodeCache.getKeys()) {
            Matcher matcher = pattern.matcher((String) key);
            if (matcher.find()) {
                keys.append((String) key);
                keys.append('\n');
            }
        }

        return keys.toString();
    }

    @ShellMethod(value = "Get value for a given key", key = "get")
    public Object getValue(String key) {
        Element element = userCodeCache.get(key);
        if (element != null) {
            return element.getObjectValue();
        } else {
            return "Key " + key + " not found";
        }
    }

    @ShellMethod(value = "Put a key and value in the cache", key = "put")
    public void putValue(String key, String value) {
        Element element = new Element(key, value);
        userCodeCache.put(element);
    }

    @ShellMethod(value = "Remove a key", key = "del")
    public String remove(String key) {
        boolean removed = userCodeCache.remove(key);

        if (removed) {
            return "Key " + key + " removed.";
        } else {
            return "Key " + key + " not found in cache.";
        }
    }

}
