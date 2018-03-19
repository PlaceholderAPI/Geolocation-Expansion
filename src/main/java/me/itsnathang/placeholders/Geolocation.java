package me.itsnathang.placeholders;

import me.clip.placeholderapi.expansion.Cleanable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Geolocation extends PlaceholderExpansion implements Cleanable {

    private Map<UUID, LocationInfo> cache = new HashMap<>();

    @Override
    public String getAuthor() {
        return "NathanG";
    }

    @Override
    public String getIdentifier() {
        return "geolocation";
    }

    @Override
    public String getPlugin() {
        return null;
    }

    @Override
    public String getVersion() {
        return "1.1";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (cache.containsKey(player.getUniqueId()))
            return cache.get(player.getUniqueId()).getData(identifier);

        InetSocketAddress ip = player.getAddress();
        LocationInfo info = new LocationInfo(ip);

        if (info.isValid())
            cache.put(player.getUniqueId(), info);

        return info.getData(identifier);
    }

    @Override
    public void cleanup(Player p) {
        cache.remove(p.getUniqueId());
    }
}
