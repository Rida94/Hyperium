[ ![Discord](https://canary.discordapp.com/api/guilds/411619823445999637/widget.png) ](https://discord.gg/8GakFcT)
[ ![Travis-CI](https://travis-ci.org/HyperiumClient/Hyperium.svg?branch=master)](https://travis-ci.org/HyperiumClient/Hyperium)
# Hyperium (A Community Client for Hypixel - Not affiliated with Hypixel INC, produced by independent developers)
## What is Hyperium? ##
The Hyperium is a Minecraft modification in development. It will combine many popular features in addition to suggestions and ideas from the community to provide a unique experience designed for Hypixel.

## Features ##
- [ChromaHUD](https://www.youtube.com/watch?v=eyh6pcsGMpo)
- [Keystrokes v4](https://www.youtube.com/watch?v=tA1SmI8nfY4)
- [MouseDelayFix](https://prplz.io/mousedelayfix)
- [NoCloseMyChat](https://hypixel.net/threads/1260752/)
- [1.7 Animations](https://www.youtube.com/watch?v=9-LoFff-3fI)
- [Levelhead](https://sk1er.club/levelhead)
- [AutoGG](https://www.youtube.com/watch?v=1eETPGuSQWA)
- [AutoWho](https://www.youtube.com/watch?v=osJW53GA_1I)
- [ToggleChat](https://www.youtube.com/watch?v=guD8kAk-Wn4)
- [MemoryFix](https://prplz.io/memoryfix)
- [Perspective Mod](https://www.youtube.com/watch?v=7FdMMpzNdUk)
- [Sidebar Mod](https://www.youtube.com/watch?v=cn9VvT43yRs)

## Contributing ##

## Building the project with IntelliJ ##

If you don't know how, you shouldn't. Go join our beta in <a href="https://discord.gg/RNyRgtv">Discord</a>, or wait for release!

## Code Style ##

We use [Google's Java Code style](https://google.github.io/styleguide/javaguide.html) for Hyperium. It would be appreciated if you follow this as well.

## FAQ ##
Q: Please help, I can't build Hyperium!

A: Wait for a new beta or release! 


Q: Release, when?

A: We don't know! However, open beta testing has began at our <a href="https://discord.gg/RNyRgtv">Discord</a>!


Q: ETA?

A: For beta, now! Join the <a href="https://discord.gg/RNyRgtv">Discord</a> or visit our <a href="hyperium.cc">website</a>! For release, we don't know!


Q: Is there an addon tutorial?

A: Yes, its at https://www.youtube.com/watch?v=RXTIFdoNA8c.


Q: I found a bug. Where do I report it?

A: Join the <a href="https://discord.gg/RNyRgtv">Discord</a> and run `-new` in the commands channel. Then explain your issue!


Q: My game keeps crashing!

A: If you have reported the issue using the automatic promopt, join the <a href="https://discord.gg/RNyRgtv">Discord</a> and ask a developer to review your issue. If there are none online, please be patient!

## Addons ##
**Requirement:** Built Hyperium, JDK 8+, IDE

**Dependency:**
add Hyperium that you built as dependency for the project

```java
package com.example;

import cc.hyperium.event.*;
import cc.hyperium.internal.addons.IAddon;
import net.minecraft.client.Minecraft;

public class AddonExample implements IAddon {

    @Override
    public void onLoad() {
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    private void onChatMessage(ChatEvent event) {
        if (event.getChat().getUnformattedText().contains("secret message!")) {
            Minecraft.getMinecraft().toggleFullscreen();
        }
    }

    @Override
    public void onClose() {
        System.out.println("Closing...");
    }
    
    @Override
    public void sendDebugInfo() {
    }
}
```

**addon.json**
```json
{
  "name": "Addon Example",
  "version": "1.0",
  "mainClass": "com.example.AddonExample"
}
```
**Examples [here](https://github.com/HyperiumClient/Addon-Workspace)**
## Developers ##
[![](https://cdn.discordapp.com/avatars/376817315830038530/87dd80c68e0598ea39af4e0472b299b7.png)](https://github.com/Sk1er)
[![](https://cdn.discordapp.com/avatars/248159137370734601/8a8b49df90cda7ccd55f28c1f5293ad6.png)](https://github.com/CoalCoding)
[![](https://cdn.discordapp.com/avatars/247785387919933440/e8f6af129f0d6d4db93d8c7360aac15a.png)](https://github.com/KevinPriv)
[![](https://cdn.discordapp.com/avatars/290921387655430144/1495ae41593665e29f683d63d502c600.png)](https://github.com/Cubxity)
[![](https://cdn.discordapp.com/avatars/207440827385905153/a660fb23803674f65f290f7b399ad125.png)](https://github.com/boomboompower)



## Special Thanks ##

[![yk](https://www.yourkit.com/images/yklogo.png)](https://www.yourkit.com/java/profiler/)

YourKit supports open source projects with its full-featured Java Profiler.
YourKit, LLC is the creator of <a href="https://www.yourkit.com/java/profiler/">YourKit Java Profiler</a>
and <a href="https://www.yourkit.com/.net/profiler/">YourKit .NET Profiler</a>,
innovative and intelligent tools for profiling Java and .NET applications.
