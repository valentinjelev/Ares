# Ares
This plugin disables commands specified in the configuration and prevents granting the "OP" authority to people not authorized in the plugin configuration.

# Screenshots
![alt text](https://cdn.discordapp.com/attachments/768045969199595520/920024284938768384/unknown.png)
![alt text](https://cdn.discordapp.com/attachments/768045969199595520/920025048654446592/unknown.png)

# Config.yml
```
Ops:
- galactic22
Command: ban {playername} &f&l{&4&lAres&f&l} &fНЕ СТЕ ОТОРИЗИРАНО ЛИЦЕ!
BLOCKED_COMMANDS:
- /pl
- /plugins
- /bukkit:plugins
- /bukkit:?
- /?
- /essentials:help
- //
- /mv
```

# Lang.yml
```
PREFIX: '&f&l{&4&lAres&f&l} '
BLOCKED_CMD: '&fНЕ СТЕ ОТОРИЗИРАНО ЛИЦЕ!'
NO_PERMISSION: '&cНямате право да използвате тази команда.'
```

### Commands
/ares reload - Reload config.yml
### Permission
ares.use

