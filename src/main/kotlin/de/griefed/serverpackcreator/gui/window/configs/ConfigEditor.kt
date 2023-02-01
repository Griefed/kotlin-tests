package de.griefed.serverpackcreator.gui.window.configs

import de.griefed.serverpackcreator.gui.window.components.ScrollTextArea
import net.miginfocom.swing.MigLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.CompoundBorder
import javax.swing.border.EmptyBorder
import javax.swing.border.EtchedBorder

class ConfigEditor {
    val panel = JPanel()

    init {
        //[200!]0[fill]0[50!,shrink 0]0[50!,shrink 0]
        panel.layout = MigLayout(
            "wrap",
            "[::64]5[left]5[left,grow,fill]5[::64]5[::64]"
        )

        panel.add(createLabel("AA"), "cell 0 0")
        panel.add(createLabel("Modpack Directory"), "cell 1 0")
        panel.add(createLabel("C:\\Minecraft\\Game\\Instances\\Survive Create Prosper 4"), "cell 2 0")
        panel.add(createLabel("AAAAA"), "cell 3 0")
        panel.add(createLabel("BBBBB"), "cell 4 0")

        panel.add(createLabel("AA"), "cell 0 1")
        panel.add(createLabel("Server Properties"), "cell 1 1")
        panel.add(createLabel("C:/Minecraft/ServerPackCreator/server_files/scp3.properties"), "cell 2 1")
        panel.add(createLabel("AAAAA"), "cell 3 1")
        panel.add(createLabel("BBBBB"), "cell 4 1")

        panel.add(createLabel("AA"), "cell 0 2")
        panel.add(createLabel("Server Icon"), "cell 1 2")
        panel.add(createLabel("C:/Minecraft/ServerPackCreator/server_files/server-icon.png"), "cell 2 2")
        panel.add(createLabel("AAAAA"), "cell 3 2")
        panel.add(createLabel("BBBBB"), "cell 4 2")

        panel.add(createLabel("AA"), "cell 0 3")
        panel.add(createLabel("Mod-Exclusions"), "cell 1 3")
        panel.add(
            ScrollTextArea(
                "^Armor Status HUD-.*\$, ^[1.12.2]bspkrscore-.*\$, ^[1.12.2]DamageIndicatorsMod-.*\$, ^3dskinlayers-.*\$," +
                        " ^Absolutely-Not-A-Zoom-Mod-.*\$, ^AdvancedChat-.*\$, ^AdvancedCompas-.*\$, ^AdvancementPlaques-.*\$," +
                        " ^Ambience.*\$, ^AmbientEnvironment-.*\$, ^AmbientSounds_.*\$, ^antighost-.*\$, ^anviltooltipmod-.*\$," +
                        " ^appleskin-.*\$, ^armorchroma-.*\$, ^armorpointspp-.*\$, ^ArmorSoundTweak-.*\$, ^AromaBackup-.*\$," +
                        " ^authme-.*\$, ^autobackup-.*\$, ^autoreconnect-.*\$, ^auto-reconnect-.*\$, ^axolotl-item-fix-.*\$," +
                        " ^backtools-.*\$, ^Backups-.*\$, ^bannerunlimited-.*\$, ^Batty's Coordinates PLUS Mod.*\$, ^beenfo-1.19-.*\$," +
                        " ^BetterAdvancements-.*\$, ^BetterAnimationsCollection-.*\$, ^betterbiomeblend-.*\$, ^BetterDarkMode-.*\$," +
                        " ^BetterF3-.*\$, ^BetterFoliage-.*\$, ^BetterPingDisplay-.*\$, ^BetterPlacement-.*\$, ^better-recipe-book-.*\$," +
                        " ^BetterTaskbar-.*\$, ^BetterThirdPerson.*\$, ^BetterTitleScreen-.*\$, ^bhmenu-.*\$, ^BH-Menu-.*\$, ^blur-.*\$," +
                        " ^borderless-mining-.*\$, ^BorderlessWindow-.*\$, ^catalogue-.*\$, ^charmonium-.*\$, ^chat_heads-.*\$," +
                        " ^cherishedworlds-.*\$, ^ChunkAnimator-.*\$, ^cirback-1.0-.*\$, ^classicbar-.*\$, ^clickadv-.*\$, ^clienttweaks-.*\$," +
                        " ^ClientTweaks_.*\$, ^combat_music-.*\$, ^configured-.*\$, ^controllable-.*\$, ^Controller Support-.*\$," +
                        " ^Controlling-.*\$, ^CraftPresence-.*\$, ^CTM-.*\$, ^cullleaves-.*\$, ^cullparticles-.*\$, ^custom-crosshair-mod-.*\$," +
                        " ^CustomCursorMod-.*\$, ^customdiscordrpc-.*\$, ^CustomMainMenu-.*\$, ^darkness-.*\$, ^dashloader-.*\$, ^defaultoptions-.*\$," +
                        " ^DefaultOptions_.*\$, ^DefaultSettings-.*\$, ^DeleteWorldsToTrash-.*\$, ^desiredservers-.*\$, ^DetailArmorBar-.*\$," +
                        " ^Ding-.*\$, ^discordrpc-.*\$, ^DistantHorizons-.*\$, ^drippyloadingscreen-.*\$, ^drippyloadingscreen_.*\$," +
                        " ^DripSounds-.*\$, ^Durability101-.*\$, ^DurabilityNotifier-.*\$, ^dynamic-fps-.*\$, ^dynamiclights-.*\$," +
                        " ^dynamic-music-.*\$, ^DynamicSurroundings-.*\$, ^DynamicSurroundingsHuds-.*\$, ^dynmus-.*\$, ^effective-.*\$," +
                        " ^EffectsLeft-.*\$, ^eggtab-.*\$, ^eguilib-.*\$, ^eiramoticons-.*\$, ^EiraMoticons_.*\$, ^EnchantmentDescriptions-.*\$," +
                        " ^enchantment-lore-.*\$, ^EnhancedVisuals_.*\$, ^entityculling-.*\$, ^entity-texture-features-.*\$, ^EquipmentCompare-.*\$," +
                        " ^exhaustedstamina-.*\$, ^extremesoundmuffler-.*\$, ^FabricCustomCursorMod-.*\$, ^fabricemotes-.*\$, ^Fallingleaves-.*\$," +
                        " ^fancymenu_.*\$, ^fancymenu_video_extension.*\$, ^FancySpawnEggs.*\$, ^FancyVideo-API-.*\$, ^findme-.*\$," +
                        " ^FirstPersonMod.*\$, ^flickerfix-.*\$, ^fm_audio_extension_.*\$, ^FogTweaker-.*\$, ^ForgeCustomCursorMod-.*\$," +
                        " ^forgemod_VoxelMap-.*\$, ^FPS-Monitor-.*\$, ^FpsReducer-.*\$, ^FpsReducer2-.*\$, ^freelook-.*\$, ^ftb-backups-.*\$," +
                        " ^ftbbackups2-.*\$, ^FullscreenWindowed-.*\$, ^galacticraft-rpc-.*\$, ^GameMenuModOption-.*\$, ^gamestagesviewer-.*\$," +
                        " ^grid-.*\$, ^HealthOverlay-.*\$, ^hiddenrecipebook_.*\$, ^HorseStatsMod-.*\$, ^infinitemusic-.*\$, ^InventoryEssentials_.*\$," +
                        " ^InventoryHud_[1.17.1].forge-.*\$, ^inventoryprofiles.*\$, ^InventorySpam-.*\$, ^InventoryTweaks-.*\$, ^invtweaks-.*\$," +
                        " ^ItemBorders-.*\$, ^ItemPhysicLite_.*\$, ^ItemStitchingFix-.*\$, ^itemzoom.*\$, ^itlt-.*\$, ^JBRA-Client-.*\$, ^jeed-.*\$," +
                        " ^jehc-.*\$, ^jeiintegration_.*\$, ^justenoughbeacons-.*\$, ^JustEnoughCalculation-.*\$, ^justenoughdrags-.*\$, ^JustEnoughEffects-.*\$," +
                        " ^just-enough-harvestcraft-.*\$, ^JustEnoughProfessions-.*\$, ^JustEnoughResources-.*\$, ^justzoom_.*\$, ^keymap-.*\$, ^keywizard-.*\$," +
                        " ^konkrete_.*\$, ^konkrete_forge_.*\$, ^lazydfu-.*\$, ^LegendaryTooltips.*\$, ^LegendaryTooltips-.*\$, ^lightfallclient-.*\$," +
                        " ^LightOverlay-.*\$, ^light-overlay-.*\$, ^LLOverlayReloaded-.*\$, ^loadmyresources_.*\$, ^lock_minecart_view-.*\$, ^lootbeams-.*\$," +
                        " ^LOTRDRP-.*\$, ^lwl-.*\$, ^magnesium_extras-.*\$, ^maptooltip-.*\$, ^massunbind.*\$, ^mcbindtype-.*\$, ^mcwifipnp-.*\$," +
                        " ^medievalmusic-.*\$, ^mightyarchitect-.*\$, ^mindful-eating-.*\$, ^minetogether-.*\$, ^MoBends.*\$, ^mobplusplus-.*\$," +
                        " ^modcredits-.*\$, ^modernworldcreation_.*\$, ^modmenu-.*\$, ^modnametooltip-.*\$, ^modnametooltip_.*\$, ^moreoverlays-.*\$," +
                        " ^MouseTweaks-.*\$, ^mousewheelie-.*\$, ^movement-vision-.*\$, ^multihotbar-.*\$, ^musicdr-.*\$, ^music-duration-reducer-.*\$," +
                        " ^MyServerIsCompatible-.*\$, ^Neat-.*\$, ^Neat .*\$, ^neiRecipeHandlers-.*\$, ^NekosEnchantedBooks-.*\$, ^ngrok-lan-expose-mod-.*\$," +
                        " ^NoAutoJump-.*\$, ^NoFog-.*\$, ^nopotionshift_.*\$, ^notenoughanimations-.*\$, ^Notes-.*\$, ^NotifMod-.*\$, ^oculus-.*\$," +
                        " ^OldJavaWarning-.*\$, ^openbackup-.*\$, ^OptiFine.*\$, ^OptiForge.*\$, ^OptiForge-.*\$, ^ornaments-.*\$, ^overloadedarmorbar-.*\$," +
                        " ^PackMenu-.*\$, ^PackModeMenu-.*\$, ^panorama-.*\$, ^paperdoll-.*\$, ^phosphor-.*\$, ^PickUpNotifier-.*\$, ^Ping-.*\$," +
                        " ^preciseblockplacing-.*\$, ^PresenceFootsteps-.*\$, ^realm-of-lost-souls-.*\$, ^ReAuth-.*\$, ^rebrand-.*\$, ^replanter-.*\$," +
                        " ^ResourceLoader-.*\$, ^ResourcePackOrganizer.*\$, ^RPG-HUD-.*\$, ^rubidium-.*\$, ^rubidium_extras-.*\$, ^screenshot-to-clipboard-.*\$," +
                        " ^ShoulderSurfing-.*\$, ^ShulkerTooltip-.*\$, ^shutupexperimentalsettings-.*\$, ^shutupmodelloader-.*\$, ^signtools-.*\$," +
                        " ^simpleautorun-.*\$, ^simplebackup-.*\$, ^SimpleBackups-.*\$, ^SimpleDiscordRichPresence-.*\$, ^simple-rpc-.*\$, ^SimpleWorldTimer-.*\$," +
                        " ^smartcursor-.*\$, ^smoothboot-.*\$, ^smoothfocus-.*\$, ^sounddeviceoptions-.*\$, ^SoundFilters-.*\$, ^soundreloader-.*\$," +
                        " ^SpawnerFix-.*\$, ^spoticraft-.*\$, ^tconplanner-.*\$, ^textile_backup-.*\$, ^timestamps-.*\$, ^Tips-.*\$, ^TipTheScales-.*\$," +
                        " ^Toast Control-.*\$, ^ToastControl-.*\$, ^Toast-Control-.*\$, ^tooltipscroller-.*\$, ^torchoptimizer-.*\$, ^torohealth-.*\$," +
                        " ^totaldarkness.*\$, ^toughnessbar-.*\$, ^TRansliterationLib-.*\$, ^TravelersTitles-.*\$, ^VoidFog-.*\$, ^WindowedFullscreen-.*\$," +
                        " ^wisla-.*\$, ^WorldNameRandomizer-.*\$, ^xlifeheartcolors-.*\$, ^yisthereautojump-.*\$"
            ),
            "cell 2 3,grow,width 10:500:,height 150!"
        )
        panel.add(createLabel("AAAAA"), "cell 3 3")
        panel.add(createLabel("BBBBB"), "cell 4 3")

        panel.add(createLabel("AA"), "cell 0 4")
        panel.add(createLabel("Server-files"), "cell 1 4")

        panel.add(
            ScrollTextArea(
                "^Armor Status HUD-.*\$, ^[1.12.2]bspkrscore-.*\$, ^[1.12.2]DamageIndicatorsMod-.*\$, ^3dskinlayers-.*\$," +
                        " ^Absolutely-Not-A-Zoom-Mod-.*\$, ^AdvancedChat-.*\$, ^AdvancedCompas-.*\$, ^AdvancementPlaques-.*\$," +
                        " ^Ambience.*\$, ^AmbientEnvironment-.*\$, ^AmbientSounds_.*\$, ^antighost-.*\$, ^anviltooltipmod-.*\$," +
                        " ^appleskin-.*\$, ^armorchroma-.*\$, ^armorpointspp-.*\$, ^ArmorSoundTweak-.*\$, ^AromaBackup-.*\$," +
                        " ^authme-.*\$, ^autobackup-.*\$, ^autoreconnect-.*\$, ^auto-reconnect-.*\$, ^axolotl-item-fix-.*\$," +
                        " ^backtools-.*\$, ^Backups-.*\$, ^bannerunlimited-.*\$, ^Batty's Coordinates PLUS Mod.*\$, ^beenfo-1.19-.*\$," +
                        " ^BetterAdvancements-.*\$, ^BetterAnimationsCollection-.*\$, ^betterbiomeblend-.*\$, ^BetterDarkMode-.*\$," +
                        " ^BetterF3-.*\$, ^BetterFoliage-.*\$, ^BetterPingDisplay-.*\$, ^BetterPlacement-.*\$, ^better-recipe-book-.*\$," +
                        " ^BetterTaskbar-.*\$, ^BetterThirdPerson.*\$, ^BetterTitleScreen-.*\$, ^bhmenu-.*\$, ^BH-Menu-.*\$, ^blur-.*\$," +
                        " ^borderless-mining-.*\$, ^BorderlessWindow-.*\$, ^catalogue-.*\$, ^charmonium-.*\$, ^chat_heads-.*\$," +
                        " ^cherishedworlds-.*\$, ^ChunkAnimator-.*\$, ^cirback-1.0-.*\$, ^classicbar-.*\$, ^clickadv-.*\$, ^clienttweaks-.*\$," +
                        " ^ClientTweaks_.*\$, ^combat_music-.*\$, ^configured-.*\$, ^controllable-.*\$, ^Controller Support-.*\$," +
                        " ^Controlling-.*\$, ^CraftPresence-.*\$, ^CTM-.*\$, ^cullleaves-.*\$, ^cullparticles-.*\$, ^custom-crosshair-mod-.*\$," +
                        " ^CustomCursorMod-.*\$, ^customdiscordrpc-.*\$, ^CustomMainMenu-.*\$, ^darkness-.*\$, ^dashloader-.*\$, ^defaultoptions-.*\$," +
                        " ^DefaultOptions_.*\$, ^DefaultSettings-.*\$, ^DeleteWorldsToTrash-.*\$, ^desiredservers-.*\$, ^DetailArmorBar-.*\$," +
                        " ^Ding-.*\$, ^discordrpc-.*\$, ^DistantHorizons-.*\$, ^drippyloadingscreen-.*\$, ^drippyloadingscreen_.*\$," +
                        " ^DripSounds-.*\$, ^Durability101-.*\$, ^DurabilityNotifier-.*\$, ^dynamic-fps-.*\$, ^dynamiclights-.*\$," +
                        " ^dynamic-music-.*\$, ^DynamicSurroundings-.*\$, ^DynamicSurroundingsHuds-.*\$, ^dynmus-.*\$, ^effective-.*\$," +
                        " ^EffectsLeft-.*\$, ^eggtab-.*\$, ^eguilib-.*\$, ^eiramoticons-.*\$, ^EiraMoticons_.*\$, ^EnchantmentDescriptions-.*\$," +
                        " ^enchantment-lore-.*\$, ^EnhancedVisuals_.*\$, ^entityculling-.*\$, ^entity-texture-features-.*\$, ^EquipmentCompare-.*\$," +
                        " ^exhaustedstamina-.*\$, ^extremesoundmuffler-.*\$, ^FabricCustomCursorMod-.*\$, ^fabricemotes-.*\$, ^Fallingleaves-.*\$," +
                        " ^fancymenu_.*\$, ^fancymenu_video_extension.*\$, ^FancySpawnEggs.*\$, ^FancyVideo-API-.*\$, ^findme-.*\$," +
                        " ^FirstPersonMod.*\$, ^flickerfix-.*\$, ^fm_audio_extension_.*\$, ^FogTweaker-.*\$, ^ForgeCustomCursorMod-.*\$," +
                        " ^forgemod_VoxelMap-.*\$, ^FPS-Monitor-.*\$, ^FpsReducer-.*\$, ^FpsReducer2-.*\$, ^freelook-.*\$, ^ftb-backups-.*\$," +
                        " ^ftbbackups2-.*\$, ^FullscreenWindowed-.*\$, ^galacticraft-rpc-.*\$, ^GameMenuModOption-.*\$, ^gamestagesviewer-.*\$," +
                        " ^grid-.*\$, ^HealthOverlay-.*\$, ^hiddenrecipebook_.*\$, ^HorseStatsMod-.*\$, ^infinitemusic-.*\$, ^InventoryEssentials_.*\$," +
                        " ^InventoryHud_[1.17.1].forge-.*\$, ^inventoryprofiles.*\$, ^InventorySpam-.*\$, ^InventoryTweaks-.*\$, ^invtweaks-.*\$," +
                        " ^ItemBorders-.*\$, ^ItemPhysicLite_.*\$, ^ItemStitchingFix-.*\$, ^itemzoom.*\$, ^itlt-.*\$, ^JBRA-Client-.*\$, ^jeed-.*\$," +
                        " ^jehc-.*\$, ^jeiintegration_.*\$, ^justenoughbeacons-.*\$, ^JustEnoughCalculation-.*\$, ^justenoughdrags-.*\$, ^JustEnoughEffects-.*\$," +
                        " ^just-enough-harvestcraft-.*\$, ^JustEnoughProfessions-.*\$, ^JustEnoughResources-.*\$, ^justzoom_.*\$, ^keymap-.*\$, ^keywizard-.*\$," +
                        " ^konkrete_.*\$, ^konkrete_forge_.*\$, ^lazydfu-.*\$, ^LegendaryTooltips.*\$, ^LegendaryTooltips-.*\$, ^lightfallclient-.*\$," +
                        " ^LightOverlay-.*\$, ^light-overlay-.*\$, ^LLOverlayReloaded-.*\$, ^loadmyresources_.*\$, ^lock_minecart_view-.*\$, ^lootbeams-.*\$," +
                        " ^LOTRDRP-.*\$, ^lwl-.*\$, ^magnesium_extras-.*\$, ^maptooltip-.*\$, ^massunbind.*\$, ^mcbindtype-.*\$, ^mcwifipnp-.*\$," +
                        " ^medievalmusic-.*\$, ^mightyarchitect-.*\$, ^mindful-eating-.*\$, ^minetogether-.*\$, ^MoBends.*\$, ^mobplusplus-.*\$," +
                        " ^modcredits-.*\$, ^modernworldcreation_.*\$, ^modmenu-.*\$, ^modnametooltip-.*\$, ^modnametooltip_.*\$, ^moreoverlays-.*\$," +
                        " ^MouseTweaks-.*\$, ^mousewheelie-.*\$, ^movement-vision-.*\$, ^multihotbar-.*\$, ^musicdr-.*\$, ^music-duration-reducer-.*\$," +
                        " ^MyServerIsCompatible-.*\$, ^Neat-.*\$, ^Neat .*\$, ^neiRecipeHandlers-.*\$, ^NekosEnchantedBooks-.*\$, ^ngrok-lan-expose-mod-.*\$," +
                        " ^NoAutoJump-.*\$, ^NoFog-.*\$, ^nopotionshift_.*\$, ^notenoughanimations-.*\$, ^Notes-.*\$, ^NotifMod-.*\$, ^oculus-.*\$," +
                        " ^OldJavaWarning-.*\$, ^openbackup-.*\$, ^OptiFine.*\$, ^OptiForge.*\$, ^OptiForge-.*\$, ^ornaments-.*\$, ^overloadedarmorbar-.*\$," +
                        " ^PackMenu-.*\$, ^PackModeMenu-.*\$, ^panorama-.*\$, ^paperdoll-.*\$, ^phosphor-.*\$, ^PickUpNotifier-.*\$, ^Ping-.*\$," +
                        " ^preciseblockplacing-.*\$, ^PresenceFootsteps-.*\$, ^realm-of-lost-souls-.*\$, ^ReAuth-.*\$, ^rebrand-.*\$, ^replanter-.*\$," +
                        " ^ResourceLoader-.*\$, ^ResourcePackOrganizer.*\$, ^RPG-HUD-.*\$, ^rubidium-.*\$, ^rubidium_extras-.*\$, ^screenshot-to-clipboard-.*\$," +
                        " ^ShoulderSurfing-.*\$, ^ShulkerTooltip-.*\$, ^shutupexperimentalsettings-.*\$, ^shutupmodelloader-.*\$, ^signtools-.*\$," +
                        " ^simpleautorun-.*\$, ^simplebackup-.*\$, ^SimpleBackups-.*\$, ^SimpleDiscordRichPresence-.*\$, ^simple-rpc-.*\$, ^SimpleWorldTimer-.*\$," +
                        " ^smartcursor-.*\$, ^smoothboot-.*\$, ^smoothfocus-.*\$, ^sounddeviceoptions-.*\$, ^SoundFilters-.*\$, ^soundreloader-.*\$," +
                        " ^SpawnerFix-.*\$, ^spoticraft-.*\$, ^tconplanner-.*\$, ^textile_backup-.*\$, ^timestamps-.*\$, ^Tips-.*\$, ^TipTheScales-.*\$," +
                        " ^Toast Control-.*\$, ^ToastControl-.*\$, ^Toast-Control-.*\$, ^tooltipscroller-.*\$, ^torchoptimizer-.*\$, ^torohealth-.*\$," +
                        " ^totaldarkness.*\$, ^toughnessbar-.*\$, ^TRansliterationLib-.*\$, ^TravelersTitles-.*\$, ^VoidFog-.*\$, ^WindowedFullscreen-.*\$," +
                        " ^wisla-.*\$, ^WorldNameRandomizer-.*\$, ^xlifeheartcolors-.*\$, ^yisthereautojump-.*\$"
            ),
            "cell 2 4,grow,width 10:500:,height 100!"
        )
        panel.add(createLabel("AAAAA"), "cell 3 4")
        panel.add(createLabel("BBBBB"), "cell 4 4")
    }

    private fun createLabel(text: String): JLabel? {
        val label = JLabel(text)
        label.border = CompoundBorder(EtchedBorder(), EmptyBorder(5, 5, 5, 5))
        return label
    }
}