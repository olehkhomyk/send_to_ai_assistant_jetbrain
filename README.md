# Send to AI Assistant — WebStorm Plugin

Виділяєш код → `⌥⇧A` → код з файлом і рядками вставляється в AI Assistant чат.

## Що робить

1. Бере виділений текст з редактора
2. Формує повідомлення: назва файлу, рядки, код у блоці
3. Відкриває AI Assistant панель
4. Вставляє текст у поле вводу (НЕ відправляє — можеш дописати питання)

**Приклад результату в чаті:**
```
File: `UserService.ts` lines 42–58
```
// твій виділений код
```
```

## Збірка

**Потрібно:** JDK 17+, інтернет (для завантаження Gradle і WebStorm SDK)

```bash
# Клонуй або розпакуй проект
cd send-to-ai-plugin

# Збери плагін
./gradlew buildPlugin

# Плагін буде тут:
# build/distributions/send-to-ai-plugin-1.0.0.zip
```

> Перша збірка може зайняти 5–10 хвилин — завантажується WebStorm SDK (~1GB)

## Встановлення в WebStorm

1. WebStorm → **Settings** → **Plugins**
2. Шестерня (⚙️) → **Install Plugin from Disk...**
3. Вибери `build/distributions/send-to-ai-plugin-1.0.0.zip`
4. Перезапусти WebStorm

## Використання

- Виділи код → правий клік → **Send to AI Assistant Chat**
- Або хоткей: `⌥⇧A` (macOS) / `Alt+Shift+A` (Windows/Linux)

## Зміна хоткея

**Settings** → **Keymap** → пошук `Send to AI Assistant Chat` → призначи свій.

## Troubleshooting

**Текст не вставляється автоматично?**
Це може бути через права доступу macOS до Robot API.
Рішення: System Preferences → Privacy & Security → Accessibility → додай WebStorm.

Текст все одно буде в буфері — просто натисни `⌘V` вручну в полі чату.
