# Send to AI Assistant

JetBrains plugin for all IDEs that have the AI Assistant plugin installed.

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

**Requirements:** JDK 17+, internet connection (to download Gradle and IntelliJ IDEA Community SDK)

```bash
# Clone or unpack the project
cd send-to-ai-plugin

# Build the plugin
./gradlew buildPlugin

# The plugin will be located at:
# build/distributions/send-to-ai-plugin-1.1.0.zip
```

> The first build may take 5–10 minutes — it downloads the IntelliJ IDEA Community SDK (~700 MB)

## Compatibility

Works with any JetBrains IDE that has the **AI Assistant plugin** installed:

- IntelliJ IDEA (Community & Ultimate)
- WebStorm
- PyCharm (Community & Professional)
- PhpStorm
- GoLand
- RubyMine
- CLion
- Rider
- RustRover
- DataGrip
- Android Studio

## Installation in JetBrains IDEs

1. Open your JetBrains IDE → **Settings** → **Plugins**
2. Gear icon (⚙️) → **Install Plugin from Disk...**
3. Select `build/distributions/send-to-ai-plugin-1.1.0.zip`
4. Restart the IDE

## Usage

- Select code → right-click → **Send to AI Assistant Chat**
- Or use the hotkey: `⌥⇧A` (macOS) / `Alt+Shift+A` (Windows/Linux)

## Changing the hotkey

**Settings** → **Keymap** → search for `Send to AI Assistant Chat` → assign your own.

## Troubleshooting

**AI Assistant tool window not found?**
Make sure the JetBrains AI Assistant plugin is installed and enabled in your IDE (Settings → Plugins → Marketplace → search "AI Assistant").

**Text is not pasted automatically?**
This may be caused by macOS permissions for the Robot API.
Solution: System Preferences → Privacy & Security → Accessibility → add your JetBrains IDE.
