package de.griefed.serverpackcreator.gui.window.configs

import de.griefed.serverpackcreator.gui.window.components.scripttable.ScriptTable
import de.griefed.serverpackcreator.gui.window.components.ScrollTextArea
import net.miginfocom.swing.MigLayout
import javax.swing.*
import javax.swing.border.CompoundBorder
import javax.swing.border.EmptyBorder
import javax.swing.border.EtchedBorder

class ConfigEditor {
    val panel = JPanel()

    init {
        panel.layout = MigLayout(
            "left,wrap",
            "[left,::64]5[left]5[left,grow]5[left,::64]5[left,::64]","30"
        )

        // Modpack directory
        panel.add(createLabel("AA"), "cell 0 0")
        panel.add(createLabel("Modpack Directory"), "cell 1 0")
        panel.add(createLabel("C:\\Minecraft\\Game\\Instances\\Survive Create Prosper 4"), "cell 2 0")
        panel.add(createLabel("AAAAA"), "cell 3 0")
        panel.add(createLabel("BBBBB"), "cell 4 0")

        // Server Properties
        panel.add(createLabel("AA"), "cell 0 1")
        panel.add(createLabel("Server Properties"), "cell 1 1")
        panel.add(createLabel("C:/Minecraft/ServerPackCreator/server_files/scp3.properties"), "cell 2 1")
        panel.add(createLabel("AAAAA"), "cell 3 1")
        panel.add(createLabel("BBBBB"), "cell 4 1")

        // Server Icon
        panel.add(createLabel("AA"), "cell 0 2")
        panel.add(createLabel("Server Icon"), "cell 1 2")
        panel.add(createLabel("C:/Minecraft/ServerPackCreator/server_files/server-icon.png"), "cell 2 2")
        panel.add(createLabel("AAAAA"), "cell 3 2")
        panel.add(createLabel("BBBBB"), "cell 4 2")

        // Mod Exclusions
        panel.add(createLabel("AA"), "cell 0 3 1 3")
        panel.add(createLabel("Mod-Exclusions"), "cell 1 3 1 3")
        panel.add(
            ScrollTextArea(
                "^Armor Status HUD-.*\$, ^[1.12.2]bspkrscore-.*\$, ^[1.12.2]DamageIndicatorsMod-.*\$, ^3dskinlayers-.*\$, ^Absolutely-Not-A-Zoom-Mod-.*\$, ^AdvancedChat-.*\$, ^AdvancedCompas-.*\$, ^AdvancementPlaques-.*\$, ^Ambience.*\$, ^AmbientEnvironment-.*\$, ^AmbientSounds_.*\$, ^antighost-.*\$, ^anviltooltipmod-.*\$, ^appleskin-.*\$, ^armorchroma-.*\$, ^armorpointspp-.*\$, ^ArmorSoundTweak-.*\$, ^AromaBackup-.*\$, ^authme-.*\$, ^autobackup-.*\$, ^autoreconnect-.*\$, ^auto-reconnect-.*\$, ^axolotl-item-fix-.*\$, ^backtools-.*\$, ^Backups-.*\$, ^bannerunlimited-.*\$, ^Batty's Coordinates PLUS Mod.*\$, ^beenfo-1.19-.*\$, ^BetterAdvancements-.*\$, ^BetterAnimationsCollection-.*\$, ^betterbiomeblend-.*\$, ^BetterDarkMode-.*\$, ^BetterF3-.*\$, ^BetterFoliage-.*\$, ^BetterPingDisplay-.*\$, ^BetterPlacement-.*\$, ^better-recipe-book-.*\$, ^BetterTaskbar-.*\$, ^BetterThirdPerson.*\$, ^BetterTitleScreen-.*\$, ^bhmenu-.*\$, ^BH-Menu-.*\$, ^blur-.*\$, ^borderless-mining-.*\$, ^BorderlessWindow-.*\$, ^catalogue-.*\$, ^charmonium-.*\$, ^chat_heads-.*\$, ^cherishedworlds-.*\$, ^ChunkAnimator-.*\$, ^cirback-1.0-.*\$, ^classicbar-.*\$, ^clickadv-.*\$, ^clienttweaks-.*\$, ^ClientTweaks_.*\$, ^combat_music-.*\$, ^configured-.*\$, ^controllable-.*\$, ^Controller Support-.*\$, ^Controlling-.*\$, ^CraftPresence-.*\$, ^CTM-.*\$, ^cullleaves-.*\$, ^cullparticles-.*\$, ^custom-crosshair-mod-.*\$, ^CustomCursorMod-.*\$, ^customdiscordrpc-.*\$, ^CustomMainMenu-.*\$, ^darkness-.*\$, ^dashloader-.*\$, ^defaultoptions-.*\$, ^DefaultOptions_.*\$, ^DefaultSettings-.*\$, ^DeleteWorldsToTrash-.*\$, ^desiredservers-.*\$, ^DetailArmorBar-.*\$, ^Ding-.*\$, ^discordrpc-.*\$, ^DistantHorizons-.*\$, ^drippyloadingscreen-.*\$, ^drippyloadingscreen_.*\$, ^DripSounds-.*\$, ^Durability101-.*\$, ^DurabilityNotifier-.*\$, ^dynamic-fps-.*\$, ^dynamiclights-.*\$, ^dynamic-music-.*\$, ^DynamicSurroundings-.*\$, ^DynamicSurroundingsHuds-.*\$, ^dynmus-.*\$, ^effective-.*\$, ^EffectsLeft-.*\$, ^eggtab-.*\$, ^eguilib-.*\$, ^eiramoticons-.*\$, ^EiraMoticons_.*\$, ^EnchantmentDescriptions-.*\$, ^enchantment-lore-.*\$, ^EnhancedVisuals_.*\$, ^entityculling-.*\$, ^entity-texture-features-.*\$, ^EquipmentCompare-.*\$, ^exhaustedstamina-.*\$, ^extremesoundmuffler-.*\$, ^FabricCustomCursorMod-.*\$, ^fabricemotes-.*\$, ^Fallingleaves-.*\$, ^fancymenu_.*\$, ^fancymenu_video_extension.*\$, ^FancySpawnEggs.*\$, ^FancyVideo-API-.*\$, ^findme-.*\$, ^FirstPersonMod.*\$, ^flickerfix-.*\$, ^fm_audio_extension_.*\$, ^FogTweaker-.*\$, ^ForgeCustomCursorMod-.*\$, ^forgemod_VoxelMap-.*\$, ^FPS-Monitor-.*\$, ^FpsReducer-.*\$, ^FpsReducer2-.*\$, ^freelook-.*\$, ^ftb-backups-.*\$, ^ftbbackups2-.*\$, ^FullscreenWindowed-.*\$, ^galacticraft-rpc-.*\$, ^GameMenuModOption-.*\$, ^gamestagesviewer-.*\$, ^grid-.*\$, ^HealthOverlay-.*\$, ^hiddenrecipebook_.*\$, ^HorseStatsMod-.*\$, ^infinitemusic-.*\$, ^InventoryEssentials_.*\$, ^InventoryHud_[1.17.1].forge-.*\$, ^inventoryprofiles.*\$, ^InventorySpam-.*\$, ^InventoryTweaks-.*\$, ^invtweaks-.*\$, ^ItemBorders-.*\$, ^ItemPhysicLite_.*\$, ^ItemStitchingFix-.*\$, ^itemzoom.*\$, ^itlt-.*\$, ^JBRA-Client-.*\$, ^jeed-.*\$, ^jehc-.*\$, ^jeiintegration_.*\$, ^justenoughbeacons-.*\$, ^JustEnoughCalculation-.*\$, ^justenoughdrags-.*\$, ^JustEnoughEffects-.*\$, ^just-enough-harvestcraft-.*\$, ^JustEnoughProfessions-.*\$, ^JustEnoughResources-.*\$, ^justzoom_.*\$, ^keymap-.*\$, ^keywizard-.*\$, ^konkrete_.*\$, ^konkrete_forge_.*\$, ^lazydfu-.*\$, ^LegendaryTooltips.*\$, ^LegendaryTooltips-.*\$, ^lightfallclient-.*\$, ^LightOverlay-.*\$, ^light-overlay-.*\$, ^LLOverlayReloaded-.*\$, ^loadmyresources_.*\$, ^lock_minecart_view-.*\$, ^lootbeams-.*\$, ^LOTRDRP-.*\$, ^lwl-.*\$, ^magnesium_extras-.*\$, ^maptooltip-.*\$, ^massunbind.*\$, ^mcbindtype-.*\$, ^mcwifipnp-.*\$, ^medievalmusic-.*\$, ^mightyarchitect-.*\$, ^mindful-eating-.*\$, ^minetogether-.*\$, ^MoBends.*\$, ^mobplusplus-.*\$, ^modcredits-.*\$, ^modernworldcreation_.*\$, ^modmenu-.*\$, ^modnametooltip-.*\$, ^modnametooltip_.*\$, ^moreoverlays-.*\$, ^MouseTweaks-.*\$, ^mousewheelie-.*\$, ^movement-vision-.*\$, ^multihotbar-.*\$, ^musicdr-.*\$, ^music-duration-reducer-.*\$, ^MyServerIsCompatible-.*\$, ^Neat-.*\$, ^Neat .*\$, ^neiRecipeHandlers-.*\$, ^NekosEnchantedBooks-.*\$, ^ngrok-lan-expose-mod-.*\$, ^NoAutoJump-.*\$, ^NoFog-.*\$, ^nopotionshift_.*\$, ^notenoughanimations-.*\$, ^Notes-.*\$, ^NotifMod-.*\$, ^oculus-.*\$, ^OldJavaWarning-.*\$, ^openbackup-.*\$, ^OptiFine.*\$, ^OptiForge.*\$, ^OptiForge-.*\$, ^ornaments-.*\$, ^overloadedarmorbar-.*\$, ^PackMenu-.*\$, ^PackModeMenu-.*\$, ^panorama-.*\$, ^paperdoll-.*\$, ^phosphor-.*\$, ^PickUpNotifier-.*\$, ^Ping-.*\$, ^preciseblockplacing-.*\$, ^PresenceFootsteps-.*\$, ^realm-of-lost-souls-.*\$, ^ReAuth-.*\$, ^rebrand-.*\$, ^replanter-.*\$, ^ResourceLoader-.*\$, ^ResourcePackOrganizer.*\$, ^RPG-HUD-.*\$, ^rubidium-.*\$, ^rubidium_extras-.*\$, ^screenshot-to-clipboard-.*\$, ^ShoulderSurfing-.*\$, ^ShulkerTooltip-.*\$, ^shutupexperimentalsettings-.*\$, ^shutupmodelloader-.*\$, ^signtools-.*\$, ^simpleautorun-.*\$, ^simplebackup-.*\$, ^SimpleBackups-.*\$, ^SimpleDiscordRichPresence-.*\$, ^simple-rpc-.*\$, ^SimpleWorldTimer-.*\$, ^smartcursor-.*\$, ^smoothboot-.*\$, ^smoothfocus-.*\$, ^sounddeviceoptions-.*\$, ^SoundFilters-.*\$, ^soundreloader-.*\$, ^SpawnerFix-.*\$, ^spoticraft-.*\$, ^tconplanner-.*\$, ^textile_backup-.*\$, ^timestamps-.*\$, ^Tips-.*\$, ^TipTheScales-.*\$, ^Toast Control-.*\$, ^ToastControl-.*\$, ^Toast-Control-.*\$, ^tooltipscroller-.*\$, ^torchoptimizer-.*\$, ^torohealth-.*\$, ^totaldarkness.*\$, ^toughnessbar-.*\$, ^TRansliterationLib-.*\$, ^TravelersTitles-.*\$, ^VoidFog-.*\$, ^WindowedFullscreen-.*\$, ^wisla-.*\$, ^WorldNameRandomizer-.*\$, ^xlifeheartcolors-.*\$, ^yisthereautojump-.*\$"
            ),
            "cell 2 3 1 3,grow,width 10:500:,height 150!"
        )
        panel.add(createLabel("AAAAA"), "cell 3 3 2 1, height 30!, aligny center, alignx center")
        panel.add(createLabel("BBBBB"), "cell 3 4 2 1, height 30!, aligny center, alignx center")
        panel.add(createLabel("CCCCC"), "cell 3 5 2 1, height 30!, aligny top, alignx center")

        // Server Files
        panel.add(createLabel("AA"), "cell 0 6 1 3")
        panel.add(createLabel("Server-files"), "cell 1 6 1 3")
        panel.add(ScrollTextArea("config, customnpcs, mods, scripts"), "cell 2 6 1 3,grow,width 10:500:,height 100!")
        panel.add(createLabel("AAAAA"), "cell 3 6 2 1, height 30!, aligny center, alignx center")
        panel.add(createLabel("BBBBB"), "cell 3 7 2 1, height 30!, aligny center, alignx center")
        panel.add(createLabel("CCCCC"), "cell 3 8 2 1, height 30!, aligny top, alignx center")

        // Server Pack Suffix
        panel.add(createLabel("AA"), "cell 0 9")
        panel.add(createLabel("Server Pack Suffix"), "cell 1 9")
        panel.add(JTextField("-4,0,0"), "cell 2 9,grow")
        panel.add(createLabel("AAAAA"), "cell 3 9")
        panel.add(createLabel("BBBBB"), "cell 4 9")

        // Minecraft Version
        panel.add(createLabel("AA"), "cell 0 10")
        panel.add(createLabel("Minecraft Version"), "cell 1 10")
        panel.add(JComboBox(DefaultComboBoxModel<String>()), "cell 2 10,w 200!")
        // Java Version Required By Minecraft Version
        panel.add(createLabel("Required Java Version:"), "cell 2 10, w 200!, gapleft 80")
        panel.add(createLabel("8"), "cell 2 10, w 40!")

        // Modloader
        panel.add(createLabel("AA"), "cell 0 11")
        panel.add(createLabel("Modloader"), "cell 1 11")
        panel.add(JComboBox(DefaultComboBoxModel<String>()), "cell 2 11,w 200!")
        // Include Server Icon
        panel.add(createLabel("AA"), "cell 2 11, w 40!, gapleft 80")
        panel.add(JCheckBox("Include Server Icon"), "cell 2 11, w 200!")
        //Create ZIP Archive
        panel.add(createLabel("AA"), "cell 2 11, w 40!")
        panel.add(JCheckBox("Create ZIP Archive"), "cell 2 11, w 200!")

        //Modloader Version
        panel.add(createLabel("AA"), "cell 0 12")
        panel.add(createLabel("Modloader Version"), "cell 1 12")
        panel.add(JComboBox(DefaultComboBoxModel<String>()), "cell 2 12,w 200!")
        //Include Server Properties
        panel.add(createLabel("AA"), "cell 2 12, w 40!, gapleft 80")
        panel.add(JCheckBox("Include Server Properties"), "cell 2 12, w 200!")
        //Install Local Server
        panel.add(createLabel("AA"), "cell 2 12, w 40!")
        panel.add(JCheckBox("Prepare Local Server"), "cell 2 12, w 200!")

        // Java Arguments
        panel.add(createLabel("AA"), "cell 0 13 1 3")
        panel.add(createLabel("Run Arguments"), "cell 1 13 1 3")
        panel.add(
            ScrollTextArea(
                "-Xms8G -Xmx8G -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=8M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=15 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 -Dusing.aikars.flags=https://mcflags.emc.gs -Daikars.new.flags=true"
            ),
            "cell 2 13 1 3,grow,width 10:500:,height 100!"
        )
        panel.add(createLabel("AAAAA"), "cell 3 13 2 1, height 30!, aligny center, alignx center")

        // Script Key-Value Pairs
        panel.add(createLabel("AA"), "cell 0 16 1 3")
        panel.add(createLabel("Script Key-Value Pairs"), "cell 1 16 1 3")
        panel.add(ScriptTable().scrollPanel, "cell 2 16 1 3,grow,width 10:500:,height 200!")
        panel.add(createLabel("AAAAA"), "cell 3 16 2 1, height 30!, aligny center, alignx center")
        panel.add(createLabel("BBBBB"), "cell 3 17 2 1, height 30!, aligny center, alignx center")
        panel.add(createLabel("CCCCC"), "cell 3 18 2 1, height 30!, aligny top, alignx center")
    }

    private fun createLabel(text: String): JLabel? {
        val label = JLabel(text)
        label.border = CompoundBorder(EtchedBorder(), EmptyBorder(5, 5, 5, 5))
        return label
    }
}