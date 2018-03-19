package me.itsnathang.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

import java.net.InetSocketAddress;

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
        if (cache.containsKey(player.getUuid())) {
            return cache.get(player.getUniqueId()).getData(identifier);
        }
        InetSocketAddress ip = player.getAddress();
        LocationInfo info = new LocationInfo(ip);
        if (info.isValid()) {
            cache.put(player.getUniqueId(), info);
        }
        return info.getData(identifier);
    }

    @Override
    public void clean(Player p) {
        cache.remove(p.getUniqueId());
    }
}
