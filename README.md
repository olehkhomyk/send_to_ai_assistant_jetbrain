# Send to AI Assistant

JetBrains plugin for WebStorm and IntelliJ IDEA Ultimate.

Select code → `⌥⇧A` → code with filename and line numbers is pasted into the AI Assistant chat.

## What it does

1. Takes the selected text from the editor
2. Formats a message: filename, line range, code in a code block
3. Opens the AI Assistant panel
4. Pastes the text into the input field (does NOT send — you can add your question first)

**Example output in chat:**
```
File: `UserService.ts` lines 42–58
```
// your selected code
```
```

## Build

**Requirements:** JDK 17+, internet connection (to download Gradle and WebStorm SDK)

```bash
# Clone or unpack the project
cd send-to-ai-plugin

# Build the plugin
./gradlew buildPlugin

# The plugin will be located at:
# build/distributions/send-to-ai-plugin-1.0.0.zip
```

> The first build may take 5–10 minutes — it downloads the WebStorm SDK (~1GB)

## Compatibility

- WebStorm
- IntelliJ IDEA Ultimate

The plugin depends on the bundled `JavaScript` plugin, so IntelliJ IDEA Community is not a supported target.

## Installation in JetBrains IDEs

1. WebStorm or IntelliJ IDEA Ultimate → **Settings** → **Plugins**
2. Gear icon (⚙️) → **Install Plugin from Disk...**
3. Select `build/distributions/send-to-ai-plugin-1.0.0.zip`
4. Restart WebStorm

## Usage

- Select code → right-click → **Send to AI Assistant Chat**
- Or use the hotkey: `⌥⇧A` (macOS) / `Alt+Shift+A` (Windows/Linux)

## Changing the hotkey

**Settings** → **Keymap** → search for `Send to AI Assistant Chat` → assign your own.

## Troubleshooting

**Text is not pasted automatically?**
This may be caused by macOS permissions for the Robot API.
Solution: System Preferences → Privacy & Security → Accessibility → add your JetBrains IDE.

The text will still be in the clipboard — just press `⌘V` manually in the chat input field.
