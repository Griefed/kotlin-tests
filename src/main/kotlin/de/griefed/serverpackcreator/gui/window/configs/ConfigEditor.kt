package de.griefed.serverpackcreator.gui.window.configs

import de.griefed.serverpackcreator.gui.window.components.*
import de.griefed.serverpackcreator.gui.window.components.interactivetable.InteractiveTable
import net.miginfocom.swing.MigLayout
import java.awt.FlowLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*

class ConfigEditor(private val configs: Configs) : JPanel(
    MigLayout(
        "left,wrap",
        "[left,::64]5[left]5[left,grow]5[left,::64]5[left,::64]", "30"
    )
) {
    private val modpackInfo = JLabel(configs.infoIcon)
    private val propertiesInfo = JLabel(configs.infoIcon)
    private val serverInfo = JLabel(configs.infoIcon)
    private val filesInfo = JLabel(configs.infoIcon)
    private val suffixInfo = JLabel(configs.infoIcon)
    private val minecraftInfo = JLabel(configs.infoIcon)
    private val javaVersionInfo = JLabel(configs.infoIcon)
    private val modloaderInfo = JLabel(configs.infoIcon)
    private val modloaderVersionInfo = JLabel(configs.infoIcon)
    private val includeIconInfo = JLabel(configs.infoIcon)
    private val includeZIPInfo = JLabel(configs.infoIcon)
    private val includePropertiesInfo = JLabel(configs.infoIcon)
    private val includeServerInfo = JLabel(configs.infoIcon)

    val modpackDirectory = FileTextField("C:\\Minecraft\\Game\\Instances\\Survive Create Prosper 4")
    val modpackBrowser = JButton(configs.folderIcon)
    val modpackInspect = JButton(configs.inspectIcon)
    val propertiesFile = FileTextField("C:/Minecraft/ServerPackCreator/server_files/scp3.properties")
    val propertiesQuickSelect = JComboBox(DefaultComboBoxModel(arrayOf("server.properties")))
    val propertiesBrowser = JButton(configs.folderIcon)
    val propertiesOpen = JButton(configs.openIcon)
    val iconFile = FileTextField("C:/Minecraft/ServerPackCreator/server_files/server-icon.png")
    val iconQuickSelect = JComboBox(DefaultComboBoxModel(arrayOf("server-icon.png")))
    val iconBrowser = JButton(configs.folderIcon)
    val iconPreview = JLabel(configs.serverIcon)
    val serverPackFiles = ScrollTextArea("config, customnpcs, mods, scripts")
    val serverPackFilesRevert = JButton(configs.revertIcon)
    val serverPackFilesBrowser = JButton(configs.folderIcon)
    val serverPackFilesReset = JButton(configs.resetIcon)
    val serverPackSuffix = JTextField("-4,0,0")
    val minecraftVersion = JComboBox(DefaultComboBoxModel(arrayOf("1.16.5", "1.18.2", "1.12.2")))
    val javaVersion = ElementLabel("8", 16)
    val modloader = JComboBox(DefaultComboBoxModel(arrayOf("Forge", "Fabric", "Quilt", "LegacyFabric")))
    val modloaderVersion = JComboBox(DefaultComboBoxModel(arrayOf("1.2.3", "4.5.6")))
    val includeIcon = JCheckBox("Include Server Icon")
    val includeZip = JCheckBox("Create ZIP Archive")
    val includeProperties = JCheckBox("Include Server Properties")
    val prepareServer = JCheckBox("Prepare Local Server")

    val exclusions = ScrollTextArea(
        "^Armor Status HUD-.*\$, ^[1.12.2]bspkrscore-.*\$, ^[1.12.2]DamageIndicatorsMod-.*\$, ^3dskinlayers-.*\$, ^Absolutely-Not-A-Zoom-Mod-.*\$, ^AdvancedChat-.*\$, ^AdvancedCompas-.*\$, ^AdvancementPlaques-.*\$, ^Ambience.*\$, ^AmbientEnvironment-.*\$, ^AmbientSounds_.*\$, ^antighost-.*\$, ^anviltooltipmod-.*\$, ^appleskin-.*\$, ^armorchroma-.*\$, ^armorpointspp-.*\$, ^ArmorSoundTweak-.*\$, ^AromaBackup-.*\$, ^authme-.*\$, ^autobackup-.*\$, ^autoreconnect-.*\$, ^auto-reconnect-.*\$, ^axolotl-item-fix-.*\$, ^backtools-.*\$, ^Backups-.*\$, ^bannerunlimited-.*\$, ^Batty's Coordinates PLUS Mod.*\$, ^beenfo-1.19-.*\$, ^BetterAdvancements-.*\$, ^BetterAnimationsCollection-.*\$, ^betterbiomeblend-.*\$, ^BetterDarkMode-.*\$, ^BetterF3-.*\$, ^BetterFoliage-.*\$, ^BetterPingDisplay-.*\$, ^BetterPlacement-.*\$, ^better-recipe-book-.*\$, ^BetterTaskbar-.*\$, ^BetterThirdPerson.*\$, ^BetterTitleScreen-.*\$, ^bhmenu-.*\$, ^BH-Menu-.*\$, ^blur-.*\$, ^borderless-mining-.*\$, ^BorderlessWindow-.*\$, ^catalogue-.*\$, ^charmonium-.*\$, ^chat_heads-.*\$, ^cherishedworlds-.*\$, ^ChunkAnimator-.*\$, ^cirback-1.0-.*\$, ^classicbar-.*\$, ^clickadv-.*\$, ^clienttweaks-.*\$, ^ClientTweaks_.*\$, ^combat_music-.*\$, ^configured-.*\$, ^controllable-.*\$, ^Controller Support-.*\$, ^Controlling-.*\$, ^CraftPresence-.*\$, ^CTM-.*\$, ^cullleaves-.*\$, ^cullparticles-.*\$, ^custom-crosshair-mod-.*\$, ^CustomCursorMod-.*\$, ^customdiscordrpc-.*\$, ^CustomMainMenu-.*\$, ^darkness-.*\$, ^dashloader-.*\$, ^defaultoptions-.*\$, ^DefaultOptions_.*\$, ^DefaultSettings-.*\$, ^DeleteWorldsToTrash-.*\$, ^desiredservers-.*\$, ^DetailArmorBar-.*\$, ^Ding-.*\$, ^discordrpc-.*\$, ^DistantHorizons-.*\$, ^drippyloadingscreen-.*\$, ^drippyloadingscreen_.*\$, ^DripSounds-.*\$, ^Durability101-.*\$, ^DurabilityNotifier-.*\$, ^dynamic-fps-.*\$, ^dynamiclights-.*\$, ^dynamic-music-.*\$, ^DynamicSurroundings-.*\$, ^DynamicSurroundingsHuds-.*\$, ^dynmus-.*\$, ^effective-.*\$, ^EffectsLeft-.*\$, ^eggtab-.*\$, ^eguilib-.*\$, ^eiramoticons-.*\$, ^EiraMoticons_.*\$, ^EnchantmentDescriptions-.*\$, ^enchantment-lore-.*\$, ^EnhancedVisuals_.*\$, ^entityculling-.*\$, ^entity-texture-features-.*\$, ^EquipmentCompare-.*\$, ^exhaustedstamina-.*\$, ^extremesoundmuffler-.*\$, ^FabricCustomCursorMod-.*\$, ^fabricemotes-.*\$, ^Fallingleaves-.*\$, ^fancymenu_.*\$, ^fancymenu_video_extension.*\$, ^FancySpawnEggs.*\$, ^FancyVideo-API-.*\$, ^findme-.*\$, ^FirstPersonMod.*\$, ^flickerfix-.*\$, ^fm_audio_extension_.*\$, ^FogTweaker-.*\$, ^ForgeCustomCursorMod-.*\$, ^forgemod_VoxelMap-.*\$, ^FPS-Monitor-.*\$, ^FpsReducer-.*\$, ^FpsReducer2-.*\$, ^freelook-.*\$, ^ftb-backups-.*\$, ^ftbbackups2-.*\$, ^FullscreenWindowed-.*\$, ^galacticraft-rpc-.*\$, ^GameMenuModOption-.*\$, ^gamestagesviewer-.*\$, ^grid-.*\$, ^HealthOverlay-.*\$, ^hiddenrecipebook_.*\$, ^HorseStatsMod-.*\$, ^infinitemusic-.*\$, ^InventoryEssentials_.*\$, ^InventoryHud_[1.17.1].forge-.*\$, ^inventoryprofiles.*\$, ^InventorySpam-.*\$, ^InventoryTweaks-.*\$, ^invtweaks-.*\$, ^ItemBorders-.*\$, ^ItemPhysicLite_.*\$, ^ItemStitchingFix-.*\$, ^itemzoom.*\$, ^itlt-.*\$, ^JBRA-Client-.*\$, ^jeed-.*\$, ^jehc-.*\$, ^jeiintegration_.*\$, ^justenoughbeacons-.*\$, ^JustEnoughCalculation-.*\$, ^justenoughdrags-.*\$, ^JustEnoughEffects-.*\$, ^just-enough-harvestcraft-.*\$, ^JustEnoughProfessions-.*\$, ^JustEnoughResources-.*\$, ^justzoom_.*\$, ^keymap-.*\$, ^keywizard-.*\$, ^konkrete_.*\$, ^konkrete_forge_.*\$, ^lazydfu-.*\$, ^LegendaryTooltips.*\$, ^LegendaryTooltips-.*\$, ^lightfallclient-.*\$, ^LightOverlay-.*\$, ^light-overlay-.*\$, ^LLOverlayReloaded-.*\$, ^loadmyresources_.*\$, ^lock_minecart_view-.*\$, ^lootbeams-.*\$, ^LOTRDRP-.*\$, ^lwl-.*\$, ^magnesium_extras-.*\$, ^maptooltip-.*\$, ^massunbind.*\$, ^mcbindtype-.*\$, ^mcwifipnp-.*\$, ^medievalmusic-.*\$, ^mightyarchitect-.*\$, ^mindful-eating-.*\$, ^minetogether-.*\$, ^MoBends.*\$, ^mobplusplus-.*\$, ^modcredits-.*\$, ^modernworldcreation_.*\$, ^modmenu-.*\$, ^modnametooltip-.*\$, ^modnametooltip_.*\$, ^moreoverlays-.*\$, ^MouseTweaks-.*\$, ^mousewheelie-.*\$, ^movement-vision-.*\$, ^multihotbar-.*\$, ^musicdr-.*\$, ^music-duration-reducer-.*\$, ^MyServerIsCompatible-.*\$, ^Neat-.*\$, ^Neat .*\$, ^neiRecipeHandlers-.*\$, ^NekosEnchantedBooks-.*\$, ^ngrok-lan-expose-mod-.*\$, ^NoAutoJump-.*\$, ^NoFog-.*\$, ^nopotionshift_.*\$, ^notenoughanimations-.*\$, ^Notes-.*\$, ^NotifMod-.*\$, ^oculus-.*\$, ^OldJavaWarning-.*\$, ^openbackup-.*\$, ^OptiFine.*\$, ^OptiForge.*\$, ^OptiForge-.*\$, ^ornaments-.*\$, ^overloadedarmorbar-.*\$, ^PackMenu-.*\$, ^PackModeMenu-.*\$, ^panorama-.*\$, ^paperdoll-.*\$, ^phosphor-.*\$, ^PickUpNotifier-.*\$, ^Ping-.*\$, ^preciseblockplacing-.*\$, ^PresenceFootsteps-.*\$, ^realm-of-lost-souls-.*\$, ^ReAuth-.*\$, ^rebrand-.*\$, ^replanter-.*\$, ^ResourceLoader-.*\$, ^ResourcePackOrganizer.*\$, ^RPG-HUD-.*\$, ^rubidium-.*\$, ^rubidium_extras-.*\$, ^screenshot-to-clipboard-.*\$, ^ShoulderSurfing-.*\$, ^ShulkerTooltip-.*\$, ^shutupexperimentalsettings-.*\$, ^shutupmodelloader-.*\$, ^signtools-.*\$, ^simpleautorun-.*\$, ^simplebackup-.*\$, ^SimpleBackups-.*\$, ^SimpleDiscordRichPresence-.*\$, ^simple-rpc-.*\$, ^SimpleWorldTimer-.*\$, ^smartcursor-.*\$, ^smoothboot-.*\$, ^smoothfocus-.*\$, ^sounddeviceoptions-.*\$, ^SoundFilters-.*\$, ^soundreloader-.*\$, ^SpawnerFix-.*\$, ^spoticraft-.*\$, ^tconplanner-.*\$, ^textile_backup-.*\$, ^timestamps-.*\$, ^Tips-.*\$, ^TipTheScales-.*\$, ^Toast Control-.*\$, ^ToastControl-.*\$, ^Toast-Control-.*\$, ^tooltipscroller-.*\$, ^torchoptimizer-.*\$, ^torohealth-.*\$, ^totaldarkness.*\$, ^toughnessbar-.*\$, ^TRansliterationLib-.*\$, ^TravelersTitles-.*\$, ^VoidFog-.*\$, ^WindowedFullscreen-.*\$, ^wisla-.*\$, ^WorldNameRandomizer-.*\$, ^xlifeheartcolors-.*\$, ^yisthereautojump-.*\$"
    )
    val exclusionsRevert = JButton(configs.revertIcon)
    val exclusionsBrowser = JButton(configs.folderIcon)
    val exclusionsReset = JButton(configs.resetIcon)
    val startArgs =
        ScrollTextArea("-Xms8G -Xmx8G -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=8M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=15 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 -Dusing.aikars.flags=https://mcflags.emc.gs -Daikars.new.flags=true")
    val aikarsFlags = JButton()
    val scriptKVPairs = InteractiveTable()
    val scriptKVPairsRevert = JButton(configs.revertIcon)
    val scriptKVPairsBrowser = JButton(configs.folderIcon)
    val scriptKVPairsReset = JButton(configs.resetIcon)

    val advancedSettings = AdvancedSettings(configs, this)
    val pluginsSettings = PluginsSettings()
    val collapsibleAdvanced = CollapsiblePanel("Advanced Settings", advancedSettings)
    val collapsiblePlugins = CollapsiblePanel("Plugins", pluginsSettings)
    val title: Title

    init {

        // Modpack directory
        add(modpackInfo, "cell 0 0,grow")
        add(ElementLabel("Modpack Directory"), "cell 1 0,grow")
        add(modpackDirectory, "cell 2 0,grow")
        add(modpackBrowser, "cell 3 0, h 30!,w 30!")
        add(modpackInspect, "cell 4 0")

        // Server Properties
        add(propertiesInfo, "cell 0 1,grow")
        add(ElementLabel("Server Properties"), "cell 1 1,grow")
        add(propertiesFile, "cell 2 1, split 3,grow")
        add(ElementLabel("Quick select:"), "cell 2 1")
        add(propertiesQuickSelect, "cell 2 1,w 200!")
        add(propertiesBrowser, "cell 3 1")
        add(propertiesOpen, "cell 4 1")

        // Server Icon
        add(serverInfo, "cell 0 2,grow")
        add(ElementLabel("Server Icon"), "cell 1 2,grow")
        add(iconFile, "cell 2 2, split 2,grow")
        add(ElementLabel("Quick select:"), "cell 2 2")
        add(iconQuickSelect, "cell 2 2,w 200!")
        add(iconBrowser, "cell 3 2")
        add(iconPreview, "cell 4 2")

        // Server Files
        add(filesInfo, "cell 0 3 1 3,grow")
        add(ElementLabel("Server-files"), "cell 1 3 1 3,grow")
        add(serverPackFiles, "cell 2 3 1 3,grow,w 10:500:,h 100!")
        add(serverPackFilesRevert, "cell 3 3 2 1, h 30!, aligny center, alignx center,growx")
        add(serverPackFilesBrowser, "cell 3 4 2 1, h 30!, aligny center, alignx center,growx")
        add(serverPackFilesReset, "cell 3 5 2 1, h 30!, aligny top, alignx center,growx")

        // Server Pack Suffix
        add(suffixInfo, "cell 0 6,grow")
        add(ElementLabel("Server Pack Suffix"), "cell 1 6,grow")
        add(serverPackSuffix, "cell 2 6,grow")

        // Minecraft Version
        add(minecraftInfo, "cell 0 7,grow")
        add(ElementLabel("Minecraft Version"), "cell 1 7,grow")
        add(minecraftVersion, "cell 2 7,w 200!")
        // Java Version Of Minecraft Version
        add(javaVersionInfo, "cell 2 7, w 40!, gapleft 40")
        add(ElementLabel("Java", 16), "cell 2 7")
        add(javaVersion, "cell 2 7, w 40!")

        // Modloader
        add(modloaderInfo, "cell 0 8,grow")
        add(ElementLabel("Modloader"), "cell 1 8,grow")
        add(modloader, "cell 2 8,w 200!")
        // Include Server Icon
        add(includeIconInfo, "cell 2 8, w 40!, gapleft 40,grow")
        add(includeIcon, "cell 2 8, w 200!")
        //Create ZIP Archive
        add(includeZIPInfo, "cell 2 8, w 40!,grow")
        add(includeZip, "cell 2 8, w 200!")

        //Modloader Version
        add(modloaderVersionInfo, "cell 0 9,grow")
        add(ElementLabel("Modloader Version"), "cell 1 9,grow")
        add(modloaderVersion, "cell 2 9,w 200!")
        //Include Server Properties
        add(includePropertiesInfo, "cell 2 9, w 40!, gapleft 40,grow")
        add(includeProperties, "cell 2 9, w 200!")
        //Install Local Server
        add(includeServerInfo, "cell 2 9, w 40!,grow")
        add(prepareServer, "cell 2 9, w 200!")

        aikarsFlags.icon = CompoundIcon(
            arrayOf(
                TextIcon(aikarsFlags, "Aikars"),
                TextIcon(aikarsFlags, "Flats")
            ),
            5,
            CompoundIcon.Axis.Y_AXIS
        )

        // Advanced Settings
        add(collapsibleAdvanced, "cell 0 10 5,grow")

        // Plugins
        add(collapsiblePlugins, "cell 0 11 5,grow")

        title = Title()
    }

    inner class Title : JPanel(FlowLayout(FlowLayout.LEFT, 0, 0)) {

        val titleLabel = JLabel(modpackDirectory.file.name)
        val closeButton = JButton(configs.closeIcon)

        init {
            isOpaque = false
            titleLabel.border = BorderFactory.createEmptyBorder(0, 0, 0, 5)
            add(titleLabel)
            closeButton.addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent?) {
                    val currentTab = configs.tabs.selectedIndex
                    configs.tabs.remove(this@ConfigEditor)

                    if (currentTab - 1 > 0) {
                        configs.tabs.selectedIndex = currentTab - 1
                    }
                }
            })
            closeButton.isVisible = false
            add(closeButton)
        }
    }
}