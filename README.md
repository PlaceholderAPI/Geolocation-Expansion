## Geolocation

Geolocation is an expansion for the plugin [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) that provides placeholders related to a player's geographical location.

### Installation

Simply issue the command `/papi ecloud download Geolocation`.

Alternatively, download and drop the `Expansion-Geolocation.jar` file into `plugins/PlaceHolderAPI/expansions` and then reload PlaceholderAPI.

### Usage

Geolocation provides the following placeholders:

Replace `<identifier>` in `%geolocation_<identifier>%` to use.

- __county__ Returns the player's country. _Ex: United States_
- __countryCode__ Returns the player's country code. _Ex: US_
- __regionName__ Returns the player's region name. _Ex: Virginia_
- __region__ Returns the player's region code. _Ex: VA_
- __city__ Returns the player's city name. _Ex: Chantilly_
- __zip__ Returns the player's zip code. _Ex: 20151_
- __lat__ Returns the player's latitude. _Ex: 38.9036_
- __lon__ Returns the player's longitude. _Ex: -77.4512_
- __timezone__ Returns the player's timezone. _Ex: America/New_York_
- __isp__ Returns the player's internet service provider. _Ex: Example ISP_

## Tools Used

- [ip-api](http://ip-api.com)

__NOTE__: ip-api only allows up to 150 requests per minute. If you try to call these placeholders more often than that, it is possible that your server IP will be banned from using the service. You can remove the IP ban [here](http://ip-api.com/docs/unban).

### License

PluginInfo is licensed under the MIT License. For more information please refer to the LICENSE file.
